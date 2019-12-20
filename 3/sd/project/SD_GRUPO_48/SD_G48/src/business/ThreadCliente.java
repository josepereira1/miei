package business;
import java.net.*;
import java.io.*;
import java.lang.*;

public class ThreadCliente extends Thread{

	private Socket cs;
	private GS gs;

	private PrintWriter pw;
	private BufferedReader br;

    private String id;

	public ThreadCliente(Socket cs, GS GS){
	    super();
		this.cs = cs;
		this.gs = GS;
        try {
            this.pw = new PrintWriter(this.cs.getOutputStream(), true);
            this.br = new BufferedReader( new InputStreamReader(this.cs.getInputStream()) );
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.id = "";
	}

	private void autenticar(String[] arr) {
        if (arr.length == 3) { // autenticar_email_password
            try {
                boolean logedInd = this.gs.autenticar(arr[1], arr[2], this.pw);
                if (logedInd) {
                    this.id = arr[1]; // atribuido o ID do cliente
                    this.pw.println("1"); // sucesso
                    this.pw.flush();
                }
                else {
                    this.pw.println("2"); // password incorreta
                    this.pw.flush();
                }
            } catch (ClienteNaoExisteException e) {
                this.pw.println("3"); // email não existe
                this.pw.flush();
                e.printStackTrace();
            }
        } else {
            this.pw.println("0"); // erro de input
            this.pw.flush();
        }
    }

    private void reservarPedido(String[] arr) {
        if (arr.length == 2) {
            try {
                String id = this.gs.reservarPedido(arr[1], this.id);
                this.pw.println("q_"+id);
                this.pw.flush();
            } catch (ProdutoNaoExisteException e) {
                pw.println("6");
                pw.flush();
                e.printStackTrace();
            } catch (ReservaExisteException e) {
                pw.println("14");
                pw.flush();
                e.printStackTrace();
            }catch (ClienteNaoExisteException e){
                pw.println("10");
                pw.flush();
                e.printStackTrace();
            }catch (ReservaNaoExisteException e){
                pw.println("9");
                pw.flush();
                e.printStackTrace();
            }
        } else {
            this.pw.println("0"); // erro de input
            this.pw.flush();
        }
    }

    private void reservarLeilao(String[] arr) {
        if(arr.length == 3){    //b_idProduto_valor
            try {
                String reply;
                boolean res = this.gs.PropostaLeilao(this.id,arr[1],Float.parseFloat(arr[2]));
                if(res)reply = "4"; else reply="5";
                pw.println(reply);
                pw.flush();
            } catch (ProdutoNaoExisteException e) {
                pw.println("6");
                pw.flush();
                e.printStackTrace();
            } catch (LeilaoTerminouException e) {
                pw.println("7");
                pw.flush();
                e.printStackTrace();
            } catch (NumberFormatException e) {
                pw.println("0");
                pw.flush();
                e.printStackTrace();
            }
        }
    }

    private void libertar(String[] arr) {
        if (arr.length == 2) {
            try {
                this.gs.libertarReserva(arr[1], this.id);
                pw.println("11");
                pw.flush();
            } catch (ReservaNaoExisteException e) {
                pw.println("9");
                pw.flush();
                e.printStackTrace();
            } catch (ProdutoNaoExisteException e) {
                pw.println("8");
                pw.flush();
                e.printStackTrace();
            } catch (ClienteNaoExisteException e) {
                e.printStackTrace();
                pw.println("10");
                pw.flush();
            } catch (ReservaNaoCorrespondente e) {
                pw.println("12");
                pw.flush();
                e.printStackTrace();
            }catch (UltimoLeilaoNaoSincronizadoException e){
                pw.println("13");
                pw.flush();
                e.printStackTrace();
            }
        } else {
            this.pw.println("0");
            this.pw.flush();
        }
    }

    private void consulta(String[] arr) {
        if (arr.length == 1) {
            try {
                float valor = this.gs.consulta(this.id);
                this.pw.println("w_"+valor);
                this.pw.flush();
            } catch (ClienteNaoExisteException e) {
                this.pw.println("10");
                this.pw.flush();
                e.printStackTrace();
            }catch (ReservaNaoExisteException e){
                this.pw.println("9");
                this.pw.flush();
                e.printStackTrace();
            }
        } else {
            this.pw.println("0"); // erro de input
            this.pw.flush();
        }
    }

    public void getTodosProdutos(String[] arr){
	    if(arr.length == 1){
	        pw.println("e_"+this.gs.getTodosProdutos());
	        pw.flush();
        }else{
	        pw.println("0");    //  erro!
	        pw.flush();
        }
    }

    public void getReservasCliente(String[] arr){
        if(arr.length == 1){
            try {
                pw.println("r_"+this.gs.getReservasCliente(this.id));
            } catch (ClienteNaoExisteException e) {
                pw.println("10");
                this.pw.flush();
                e.printStackTrace();
            } catch (ReservaNaoExisteException e) {
                pw.println("12");
                pw.flush();
                e.printStackTrace();
            }
            pw.flush();
        }else{
            pw.println("0");    //  erro!
            pw.flush();
        }
    }

	public void parser(String msg) {

	    String[] arr = msg.split("_");
	    String op = arr[0];

        if (this.id.equals("")) { // não está autenticado
            switch (op) {
                case "a":
                    this.autenticar(arr);
                    break;
                default:
                    this.pw.println("15"); // não esta logado
                    this.pw.flush();
            }
        } else {
            switch (op) {
                case "b":
                    this.reservarLeilao(arr);
                    break;

                case "c":
                    this.reservarPedido(arr);
                    break;

                case "d":
                    this.consulta(arr);
                    break;

                case "e":
                    this.libertar(arr);
                    break;

                case "k":
                    this.getTodosProdutos(arr);
                    break;

                case "y":
                    this.getReservasCliente(arr);
                    break;

                default:
                    this.pw.println("0"); // erro de input
                    this.pw.flush();
            }
        }
    }


    @Override
    public void run() {

        String msg;

        System.out.println("ClienteInterface " + this.cs + " conectou-se!");

        try {

            while (true) {
                msg = this.br.readLine();
                if (msg == null) { // EOF
                    break;
                }

                System.out.println("cliente " + this.cs + ": " + msg);

                this.parser(msg);
            }

            /** fechar todos os objetos usados */
            this.br.close();
            this.pw.close();
            this.cs.close();

        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            System.out.println("ClienteInterface " + this.cs + " desconectou-se!");
        }
    }
	
}