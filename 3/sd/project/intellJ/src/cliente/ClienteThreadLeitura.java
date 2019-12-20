package cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClienteThreadLeitura extends Thread {

    private BufferedReader br;

    public ClienteThreadLeitura(Socket cliente){
        try {
            this.br = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        int flag = 0;
            try {
                while(true){
                String reply = this.br.readLine();
                if (reply == null){
                    System.out.println("Conexão com servidor perdida! Tente mais tarde!");
                    System.exit(1);
                    break;
                }
                    String[] tmp2;
                    String output = "";
                    if (reply.charAt(0) == 'q' || reply.charAt(0) == 'w' || reply.charAt(0) == 'e' || reply.charAt(0) == 'r' || reply.charAt(0) == 't' || reply.charAt(0) == 'y') {
                        if (reply.length() != 2) {
                            tmp2 = reply.split("_");
                            output = tmp2[1];
                        } else {
                            output = "";
                        }
                        reply = String.valueOf(reply.charAt(0));
                    }
                    switch (reply) {
                        case "0":
                            System.out.println("Erro ao inserir!");
                            break;
                        case "1":
                            System.out.println("Autenticado com sucesso!");
                            break;
                        case "2":
                            System.out.println("Password Incorreta!");
                            break;
                        case "3":
                            System.out.println("Email não existe!");
                            break;
                        case "4":
                            System.out.println("Proposta submetida com sucesso aguarde pelo fim do leilão!");
                            break;
                        case "5":
                            System.out.println("Insucesso na proposta, tente um valor mais alto!");
                            break;
                        case "6":
                            System.out.println("Servidor não existe!");
                            break;
                        case "7":
                            System.out.println("Leilão terminou!");
                            break;
                        case "9":   //  Erro interno
                            flag = 1;
                            break;
                        case "10":  //  Erro interno
                            flag = 1;
                            break;
                        case "11":  //  Erro interno
                            System.out.println("Libertou servidor com sucesso!");
                            break;
                        case "12":  //  Erro interno
                            flag = 1;
                            break;
                        case "13":  //  Erro interno
                            flag = 1;
                            break;
                        case "14":  //  Erro interno
                            flag = 1;
                            break;
                        case "15":
                            System.out.println("Não está autenticado no sistema, por favor faça-o!");
                            break;
                        case "q":
                            System.out.println("Reservou o servidor com id =" + output + "!");
                            break;
                        case "w":
                            System.out.println("O seu saldo = " + output + "€!");
                            break;
                        case "e":
                            if (output.equals("")) System.out.println("Não tem servidores reservados!");
                            else System.out.println("Servidores do sistema =" + output + "!");
                            break;
                        case "r":
                            if (output.equals("")) System.out.println("Não tem reservas!");
                            else System.out.println("Suas reservas = " + output + "!");
                            break;
                        case "t":   //  isto é para estar preparado para receber, mas do lado do servidor ainda não está a enviar o "#"
                            System.out.println("Ganhou um servidor a leilão!");
                            break;
                        case "y":
                            System.out.println("Perdeu o servidor com id = "+output +", que lhe foi atribuído em leilão!");
                            break;
                        default:
                            break;
                    }
                    if(flag == 1){
                        System.out.println("Erro interno, contacte o apoio ao cliente da aplicação!");
                        System.exit(1);
                    }
                }
                br.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
    }
}
