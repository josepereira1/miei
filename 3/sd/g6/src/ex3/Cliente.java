package ex3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) throws Exception{
        Socket cliente = new Socket(InetAddress.getLocalHost(), 1025);
        PrintWriter pw = new PrintWriter(cliente.getOutputStream());
        BufferedReader br = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
        Scanner input = new Scanner(System.in);
        String msg = null;
        while(true){
            if (input.hasNextLine()) msg = input.nextLine();
            else {
                cliente.shutdownOutput();
                System.out.println(br.readLine());
                break;
            }
            pw.println(msg);
            pw.flush();

            System.out.println(br.readLine());
        }
    }
}
