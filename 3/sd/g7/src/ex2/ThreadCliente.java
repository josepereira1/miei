package ex2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;

public class ThreadCliente extends Thread{
    private Servidor servidor;
    private Socket cliente;

    public ThreadCliente(Servidor servidor, Socket cliente){
        this.servidor = servidor;
        this.cliente = cliente;
    }

    public void run(){
        System.out.println("cliente conectou-se");
        try{
            PrintWriter pw = new PrintWriter(cliente.getOutputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader((cliente.getInputStream())));
            String msg;
            while(true){
                msg = br.readLine();
                if(msg == null)break;
                for(Socket c1 : this.servidor.getClientes()){
                    synchronized (c1) {
                        if(c1.equals(cliente))continue;
                        PrintWriter novoPw = new PrintWriter(c1.getOutputStream());
                        novoPw.println(msg);
                        novoPw.flush();
                    }
                }
            }
            cliente.close();
            pw.close();
            br.close();
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            this.servidor.removeCliente(this.cliente);
            System.out.println("cliente desconectou-se");
        }
    }
}
