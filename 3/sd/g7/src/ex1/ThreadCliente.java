package ex1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

//  esta class é responsável por associar uma Thread a cada cliente
//  logo é preciso um banco, e um socket para um clientef

public class ThreadCliente extends Thread {
    Banco banco;
    Socket cliente;

    public ThreadCliente(Socket cliente, Banco banco){
        this.cliente = cliente;
        this.banco = banco;
    }

    /**
     * Método que vai correr em cada THREAD cliente, onde se vai converter o input do cliente para
     * que se consiga saber qual a operação que ele quer fazer (crédito, consulta, débito, tranferência)
     */
    @Override
    public void run(){
        try {
            PrintWriter pw = new PrintWriter(cliente.getOutputStream());

            BufferedReader br = new BufferedReader(
                    new InputStreamReader((cliente.getInputStream())));
            String msg;
            while(true) {
                msg = br.readLine();    //  as msgs são do tipo c v id, onde c é o crédito, v valor e id da agência
                int valor, idConta1, idConta2;
                if(msg == null)break;   //  EOF
                String[] op = msg.split(" ");
                switch (op[0]){ //  este switch é usado para fazer parser do input do cliente, para saber que operação ele deseja fazer
                    case "c":
                        valor = Integer.parseInt(op[1]);
                        idConta1 = Integer.parseInt(op[2]);
                        banco.credito(valor,idConta1);  //  o método crédito pertence à class Banco
                        pw.println("idConta="+idConta1+"| valor="+banco.consulta(idConta1)+"€");    //  aqui envio a resposta ao cliente com o valor atualizado da conta onde ele fez alterações
                        break;
                    case "d":
                        valor = Integer.parseInt(op[1]);
                        idConta1 = Integer.parseInt(op[2]);
                        banco.credito(valor,idConta1);
                        pw.println("idConta="+idConta1+"| valor="+banco.consulta(idConta1)+"€");
                        break;
                    case "t":
                        valor = Integer.parseInt(op[1]);
                        idConta1 = Integer.parseInt(op[2]);
                        idConta2 = Integer.parseInt(op[3]);
                        banco.transferir(valor,idConta1,idConta2);
                        pw.println("idConta="+idConta1+"| valor="+banco.consulta(idConta1)+"€");
                        pw.println("idConta="+idConta2+"| valor="+banco.consulta(idConta2)+"€");
                        break;
                    case "k":
                        idConta1 = Integer.parseInt(op[1]);
                        pw.println("idConta="+idConta1+"| valor="+banco.consulta(idConta1)+"€");
                        break;
                }
                pw.flush();
                System.out.println("Valores do BANCO="+banco.toString());
            }
            cliente.close();
            pw.close();
            br.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
