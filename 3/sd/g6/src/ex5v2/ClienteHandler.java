package ex5v2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClienteHandler extends Thread {

    private Socket cs;
    private String name;

    public ClienteHandler(Socket cs, String name) {
        super();
        this.cs = cs;
        this.name = name;
    }

    @Override
    public void run() {
        String msg;
        PrintWriter pw;
        BufferedReader br;

        System.out.println("Cliente " + this.name + " conectou-se!");

        try {
            pw = new PrintWriter(this.cs.getOutputStream());
            br = new BufferedReader( new InputStreamReader(this.cs.getInputStream()) );

            while (true) {
                msg = br.readLine();
                if (msg == null) {
                    System.out.println("Cliente " + this.name + " desconectou-se!");
                    break; // EOF
                }
                System.out.println("cliente " + this.name + ": " + msg);
            }

            /** fechar todos os obejtos usados */
            br.close();
            pw.close();
            this.cs.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    } // end method
}
