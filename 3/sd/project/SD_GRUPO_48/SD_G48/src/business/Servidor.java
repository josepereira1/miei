package business;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor extends ServerSocket {

    private static final int N = 10000;

    private final static int PORT = 1234;   //  porta do servidor
    private GS gs;

    /**
     * Construtor parametrizado
     * @param port porta do servidor.
     * @throws IOException exception de input e ouput.
     */
    public Servidor(int port) throws IOException{
        super(port);
        this.gs = new GS();

        // popular business.GS para testar
        for(int i=0; i<N; i++) {
            try {
                this.gs.criarCliente(Integer.toString(i), Integer.toString(i));
            } catch (ClienteExisteException e) {
                e.printStackTrace();
            }
        }

        // popular GP para testar
        try {
            this.gs.criarProduto("t3.micro", 7.73f);
            this.gs.criarProduto("amazon.micro", 11.95f);
        } catch (ProdutoExisteException e) {
            e.printStackTrace();
        }
    }



    public static void main(String[] args){
        try {
            Servidor servidor = new Servidor(PORT); // criação do servidor
            Socket cliente;

            while(true) {
                cliente = servidor.accept(); //  aceitar/estabelecer ligação com cliente
                new ThreadCliente(cliente, servidor.gs).start();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
