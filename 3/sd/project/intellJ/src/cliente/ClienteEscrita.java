package cliente;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClienteEscrita extends Socket {
    private static final String host = "localhost";
    private static final int port = 1234;

    public ClienteEscrita(String host, int port) throws IOException{
        super(host, port);
    }

    public static void main(String[] args){
        try {
            ClienteEscrita cliente = new ClienteEscrita(host, port);
            Scanner input = new Scanner(System.in);
            PrintWriter pw = new PrintWriter(cliente.getOutputStream());
            String request = null;
            int flag = 0;

            StringBuilder sb = new StringBuilder("Para cada opção escreva exatamente igual e os respetivos valores:\n");
            sb.append("-> autenticar_email_password\n");
            sb.append("-> reservarLeilao_nomeServidor_valorProposta\n");
            sb.append("-> reservarPedido_nomeServidor\n");
            sb.append("-> consultarSaldo\n");
            sb.append("-> libertarServidor_idServidor\n");
            sb.append("-> servidoresSistema\n");
            sb.append("-> minhasReservas\n");
            sb.append("-> menu\n");
            sb.append("-> sair\n");

            System.out.println(sb.toString());  //  APRESENTAÇÃO DO MENU

            new ClienteThreadLeitura(cliente).start();  //  THREAD de Leitura

            while(true){
                if(!input.hasNextLine())break;  //  verificar se o cliente escreveu
                String[] tmp1 = new String[5];
                request=input.nextLine();
                if(request.equals("menu_") || request.equals("sair_")|| request.equals("consultarSaldo_") ||
                        request.equals("servidoresSistema_") || request.equals("minhasReservas_"))
                    tmp1[0] = request;  //  este if é só pq se o request fosse menu_ ... iria funcionar e não deveria, deve-se ao facto de fazermos o split pelo '_'
                else
                    tmp1 = request.split("_");

                switch (tmp1[0]){
                    case "autenticar":
                        if(tmp1.length == 3)request = "a_"+tmp1[1]+"_"+tmp1[2];
                        else flag = 1;
                        break;
                    case "reservarLeilao":
                        if(tmp1.length == 3)request = "b_"+tmp1[1]+"_"+tmp1[2];
                        else flag =  1;
                        break;
                    case "reservarPedido":
                        if(tmp1.length == 2)request = "c_"+tmp1[1];
                        else flag = 1;
                        break;
                    case "consultarSaldo":
                        if(tmp1.length == 1)request = "d";
                        else flag = 1;
                        break;
                    case "libertarServidor":
                        if(tmp1.length == 2)request = "e_"+tmp1[1];
                        else flag = 1;
                        break;
                    case "servidoresSistema":
                        if(tmp1.length == 1)request = "k";
                        else flag = 1;
                        break;
                    case "minhasReservas":
                        if(tmp1.length == 1)request = "y";
                        else flag = 1;
                        break;
                    case "menu":    //  apresentar menu
                        flag = 2;
                        break;
                    case "sair":    //  sair da aplicação
                        if(tmp1.length == 1){
                        pw.close();
                        cliente.close();
                        System.out.println("Até breve!");
                        System.exit(1);
                        }else flag = 1;

                        default:
                            flag = 1;
                            break;
                }
                if(flag == 0) {
                    pw.println(request);
                    pw.flush();
                }else{
                    if(flag == 1)System.out.println("Erro ao escolher opção! Tente novamente");
                    if(flag == 2)System.out.println(sb);
                    flag = 0;
                }
            }
            pw.close();
            cliente.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
