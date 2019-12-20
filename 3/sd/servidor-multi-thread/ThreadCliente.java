import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Arrays;

public class ThreadCliente extends Thread {
    public Socket cliente;

    public ThreadCliente(Socket cliente){
        this.cliente = cliente;
    }

    @Override
    public void run() {
        try{
            PrintWriter pw = new PrintWriter(cliente.getOutputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
            String msg;
            String[] splitMsg = new String[3];
            while(true){
                msg = br.readLine();
                splitMsg = msg.split(" ");

                System.out.println("mensagem enviada pelo cliente:"+Arrays.toString(splitMsg));
                if(msg == null)break;
                int n1 =  Integer.parseInt(splitMsg[0]);
                int n2 = Integer.parseInt(splitMsg[2]);
                int res = 0;
                switch(splitMsg[1]){
                    case "+":
                        res = n1+n2;
                        break;
                    case "-":
                        res = n1-n2;
                        break;
                    case "*":
                        res = n1*n2;
                        break;
                    case "/":
                        res = n1/n2;
                        break;
                    default:
                        break;
                    }
                pw.println("resultado= "+res);
                pw.flush();
            }
            cliente.close();
            pw.close();
            br.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
