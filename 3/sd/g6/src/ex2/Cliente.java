package ex2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) throws Exception{
        Socket cliente = new Socket(InetAddress.getLocalHost(), 1234);
        //  o próprio construtor faz o connect ao servidor, sem ser preciso chamar
        //  o método connect, pq ele faz isso dentro dele (construtor);

        //  as portas abaixo do 1024 estão reservadas para o Sistema Operativo
        //  /etc/servers estão as portas mais usadas

        //  as portas dos servidores são únicas, ou seja, não posso criar dois servidores com a mesma porta
        //  netstat -p grep numero_porta    lista as portas usadas na minha rede

        //  serversocketopt()   orbiga a criar o servidor, mesmo que a porta esteja a ser ocupado por outro

        //  os inputs e outputs tem que ser bem escolhidos, de forma a ter máxima eficiência

        //  os Sockets são bidirecionais, e FIFO
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
