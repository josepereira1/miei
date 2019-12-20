package ex3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    //  Quando o cliente não quiser mandar mais números, ele pode fazer close do socket
    //  mas ele assim não vai conseguir receber a média dos números pq ele fechei o socket,
    //  ou seja, já não há ligação, para fechar apenas um dos caminhos, input ou output, faço
    //  shutDownInput ou shutDownOutput, o close do Socket é uma combinação deste dois métodos.
    //  para indicar ao servidor que acabamos de inserir, ou seja, shutDow, enviamos um EOF, Ctrl+D.
    public static void main(String[] args)throws Exception{
        int port = 1025, cnt = 0;
        float soma = 0;

        ServerSocket servidor = new ServerSocket(port);
        while(true) {
            Socket cliente = servidor.accept();
            PrintWriter pw = new PrintWriter(cliente.getOutputStream());
            BufferedReader br = new BufferedReader(
                    new InputStreamReader((cliente.getInputStream())));
            while (true) {
                String msg = br.readLine();
                if (msg == null) {
                    pw.println("media=" + (soma / cnt));
                    pw.flush();
                    cnt = 0;
                    soma = 0;
                    break;
                }
                cnt++;
                soma += Integer.parseInt(msg);
                pw.println("soma=" + soma);
                pw.flush();
            }
            pw.close();
            br.close();
            cliente.close();

        }
    }
}
