package ex1;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args){
        ServerSocket server;
        Socket cliente = null;
        try {
            server = new ServerSocket(1234);    //  devemos usar portas acima de 1024
            cliente = server.accept();
            InputStreamReader input = new InputStreamReader(cliente.getInputStream());
            char[] mensagem = new char[200];
            while(true){
                input.read(mensagem,0,200);
                System.out.println(new String(mensagem,0,mensagem.length).toUpperCase());
            }
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
