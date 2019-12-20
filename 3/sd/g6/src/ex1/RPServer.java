package ex1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class RPServer {
    public static void main(String[] args) throws Exception{
        //  int port = Integer.parseInt(args[0]);
        //  temos que usar o telnet localhost 1234, como um cliente, neste exercício
        //  o professor vitor sugeriu aprendermos a usar o netcat
        int port = 1234;
        ServerSocket ss = new ServerSocket(port);
        while(true){
            Socket cs= ss.accept();
            PrintWriter pw = new PrintWriter(cs.getOutputStream());
            BufferedReader br = new BufferedReader(
                    new InputStreamReader((cs.getInputStream())));
            //System.out.println("Cliente conectado!");
            while(true){    //  IMPORTANTE: ISTO NÃO É EM CONCORRÊNCIA!!!
                String line = br.readLine();
                if(line == null)break;
                pw.println(line.toUpperCase());
                pw.flush();
            }
            pw.close();
            cs.close();
        }
    }
}
