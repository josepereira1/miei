import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) throws Exception{
        Socket cliente = new Socket("192.168.1.37", 1234);
        PrintWriter pw = new PrintWriter(cliente.getOutputStream());
        BufferedReader br = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
        Scanner input = new Scanner(System.in);
        String mensagem = null;
        while(true){
            mensagem = input.nextLine();
            if(mensagem == null)break;  //  terminou a comunicação entre o cliente e o servidor
            pw.write(mensagem+'\n');
            pw.flush();

            System.out.println(br.readLine());
        }
        pw.close();
        br.close();
        cliente.close();
    }
}