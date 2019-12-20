package ex5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ThreadCliente extends Thread {
    public Socket cliente;

    public ThreadCliente(Socket cliente){
        this.cliente = cliente;
    }

    @Override
    public void run() {
        try{
            PrintWriter pw = new PrintWriter(cliente.getOutputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
            String msg;
            while(true){
                msg = br.readLine();
                System.out.println("mensagem enviada pelo cliente:"+msg);
                if(msg == null)break;
                pw.println(msg.toUpperCase());
                pw.flush();
            }
            cliente.close();
            pw.close();
            pw.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
