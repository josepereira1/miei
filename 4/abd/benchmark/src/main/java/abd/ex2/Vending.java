package abd.ex2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Vending extends Thread{

    private static boolean started, stopped;
    private static int n;
    private static long total;
    private static int op1 = 0;
    private static int op2 = 0;

    private static final long tempo = 10;

    public synchronized static boolean terminou() {
        return stopped;
    }

    public synchronized static void startBench() {
        started = true;

        System.out.println("Started!");
    }

    public synchronized static void stopBench() {
        stopped = true;

        System.out.println("op1 = " + op1 + " | op2 = "+ op2);
        System.out.println("response time = "+(total/(n*1e9d)));
        System.out.println("throughput = "+(n/((double)tempo)));
    }

    public synchronized static void regista(long tr) {
        if (started && !stopped) {
            n++;
            total += tr;
        }
    }

    /*
        OPERAÇÕES VENDING:
     */

    public synchronized int getId(Statement s, String table) throws SQLException {
        ResultSet rs = null;
        try {
            rs = s.executeQuery("select max(id) from " + table + ";");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (rs.next()) {
            return rs.getInt(1) + 1;
        }
        return -1;
    }

    public synchronized boolean sell(Connection conn, Statement s,  List<Integer> productsIds, int clientId){
        int invoiceId, invoiceLineId;

        try {
            invoiceId = getId(s, "invoice");    //  devolve o id da última invoice
            System.out.println("actual-invoice-id = "+invoiceId);
            if(invoiceId == 0)return false;
            s.executeUpdate("insert into Invoice values (" + invoiceId + " , " + clientId + ")");

            for(Integer productId : productsIds){
                invoiceLineId = getId(s, "invoiceLine");
                System.out.println("actual-invoice-line-id = "+invoiceId);
                if(invoiceLineId == 0)return false;
                s.executeUpdate("insert into InvoiceLine values (" + invoiceLineId + " , " + invoiceId + " , " + productId + ")");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public synchronized int addClient(Statement s, String name, String address) throws SQLException {
        int id = getId(s,"client");
        System.out.println("actual-client-id = " + id);
        s.executeUpdate("insert into Client values (" + id + " , '" + name + "' , '" + address + "')");
        return id;
    }

    public void run() {
        try {
            Connection c = DriverManager.getConnection("jdbc:postgresql://localhost/mydb");
            Statement s = c.createStatement();

            Random random = new Random();

            int clientId = addClient(s, String.valueOf((char) (random.nextInt(25) + 65)), String.valueOf((char) (random.nextInt(25) + 65)));

            ArrayList<Integer> productIds = new ArrayList<>();
            productIds.add(1);
            productIds.add(2);

            sell(c,s, productIds, clientId);

            s.close();
            c.close();
        } catch(Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws Exception {
        Vending[] r = new Vending[8];

        for(int i=0; i<r.length; i++)
            r[i] = new Vending();

        for(int i=0; i<r.length; i++) {
            //Thread.sleep(1000);
            r[i].start();
        }

        Thread.sleep(5000); // aquecimento

        startBench();

        Thread.sleep(tempo*1000);  // medidas!!!

        stopBench();

        for(int i=0; i<r.length; i++)
            r[i].join();

    }
}
