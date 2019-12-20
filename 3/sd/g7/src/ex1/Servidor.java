package ex1;

import java.net.ServerSocket;
import java.net.Socket;

public class Servidor extends ServerSocket{ //  a class Servidor herda a class ServerSocket

    private Banco banco;

    public Servidor(int port) throws Exception{
        super(port);    //  a porta que vamos usar para o servidor
        this.banco = new Banco();
    }

    public Banco getBanco(){
        return this.banco;  //  visto que o Banco é private necessitamos de um método para o "buscar"
    }

    //  importante referir que a class Banco tem que estar bem definida, isto é, todos os métodos
    //  sejam syncronized,
    //


    public static void main(String[] args) throws Exception{
        Servidor servidor = new Servidor(1234); //  criamos o servidor, dando-lhe o valor da porta do mesmo
        Socket cliente;

        while(true){
            cliente = servidor.accept();    //  aceita-se a ligação do cliente ao nosso servidor
            new ThreadCliente(cliente, servidor.getBanco()).start();    //  cria-se uma THREAD para cada Cliente que pedir acesso.
        }

    }
}
