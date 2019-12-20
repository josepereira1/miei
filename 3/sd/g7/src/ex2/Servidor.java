package ex2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Servidor extends ServerSocket {

    private List<Socket> clientes;

    public Servidor(int port)throws IOException{
        super(port);
        this.clientes = new ArrayList<Socket>();
    }

    /**
     * Retorna a lista de clientes que estão conectados ao servidor.
     * @return retorna a lista de clientes que estão conectados ao servidor.
     */
    public List<Socket> getClientes(){
        return this.clientes;
    }

    /**
     * Adiciona um cliente ao buffer do servidor.
     * @param cliente cliente a adicionar
     */
    public void addCliente(Socket cliente){
        synchronized (this.clientes) {
            this.clientes.add(cliente);
        }
    }

    /**
     * Remove um cliente do buffer do servidor.
     * @param cliente cliente a remover
     */
    public void removeCliente(Socket cliente) {
        synchronized (this.clientes) {
            this.clientes.remove(cliente);
        }
    }

    public static void main(String[] args){
        try {
            Servidor servidor = new Servidor(1234);
            Socket cliente;
            while (true) {
                cliente = servidor.accept();
                servidor.addCliente(cliente);
                new ThreadCliente(servidor,cliente).start();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
