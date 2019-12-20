package ex5;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor extends ServerSocket {

    public Servidor(int porta) throws Exception{
        super(porta);
    }

    public static void main(String[] args){
        try{
            Servidor servidor = new Servidor(1234);
            while(true){
                Socket cliente = servidor.accept();
                new ThreadCliente(cliente).start();
            }
        }catch (IOException e1){
            e1.printStackTrace();
        }catch (Exception e2) {
            e2.printStackTrace();
        }

    }
}
