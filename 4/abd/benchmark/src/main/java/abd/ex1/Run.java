package abd.ex1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;

public class Run extends Thread {

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

    public void run() {
        try {
            Connection c = DriverManager.getConnection("jdbc:postgresql://localhost/mydb");
            Statement s = c.createStatement();

            // simular utilizador
            Random rand = new Random();

            while(!terminou()) {
                int op = rand.nextInt(1);

                long antes = System.nanoTime();


                switch (op) {
                    case 0: // consultar
                        //ResultSet rs = s.executeQuery("select count(*) from t1 where b > 500");
                        ResultSet rs = s.executeQuery("select * from V3Mat;");
                        while (rs.next())
                            ;
                        rs.close();
                        op1++;
                        break;
                    case 1: // atualizar
                        int v = rand.nextInt(1024) | rand.nextInt(1024);
                        // CUIDADO: Não se devem criar statements sql assim!!!!!
                        s.executeUpdate("update t1 set b=b+1 where a= " + v + "");
                        op2++;
                        break;
                }

                long depois = System.nanoTime();

                regista(depois-antes);
            }

            s.close();
            c.close();
        } catch(Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws Exception {
        Run[] r = new Run[8];

        for(int i=0; i<r.length; i++)
            r[i] = new Run();

        for(int i=0; i<r.length; i++)
            r[i].start();

        Thread.sleep(5000); // aquecimento

        startBench();

        Thread.sleep(tempo*1000);  // medidas!!!

        stopBench();

        for(int i=0; i<r.length; i++)
            r[i].join();

    }

}
