import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws Exception{
        int port = Integer.parseInt(args[0]);
        ServerSocket servidor = new ServerSocket(port);
        Socket cliente = new Socket();
        cliente = servidor.accept();
        PrintWriter pw = new PrintWriter(cliente.getOutputStream());
        BufferedReader br = new BufferedReader(
                new InputStreamReader((cliente.getInputStream())));
        while(true){
            String line = br.readLine();
            if(line == null)break;
            pw.println("Server reply:"+line.toUpperCase());
            pw.flush();
        }
        pw.close();
        cliente.close();
    }
}
