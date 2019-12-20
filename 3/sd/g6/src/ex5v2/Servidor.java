package ex5v2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor extends ServerSocket {

    private static final int port = 1024;

    public Servidor(int port) throws IOException {
        super(port);
    }

    public static void main(String[] args) throws IOException {

        Socket cs;
        Servidor servidor = new Servidor(port);
        int count = 0;

        while (true) {
            cs = servidor.accept(); // aceita o socket do cliente
            ClienteHandler clienteHandler = new ClienteHandler(cs, String.valueOf(count)); // cria o handler para o cliente
            clienteHandler.start(); // inicia o handler
            count++;
        }
    }
}