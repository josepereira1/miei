package testes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ClienteBot extends Socket {

    private static final String host = "188.82.64.150";
    private static final int port = 10011;

    public ClienteBot(String host, int port) throws IOException {
        super(host, port);
    }

    public static void main(String[] agrs) throws IOException {

        int N = 10000;
        List<Thread> threads = new ArrayList<>(N);

        Random r = new Random();

        for (int i=0; i<N; i++) { // N clientes

            ClienteBot cliente = new ClienteBot(host, port);
            PrintWriter pw = new PrintWriter(cliente.getOutputStream(), true);
            BufferedReader br = new BufferedReader( new InputStreamReader(cliente.getInputStream()) );

            /** Autenticar */
            pw.println("a_" + i + "_" + i);
            pw.flush();
            br.readLine(); // id

            /** Reservar a leilao */
            Thread t1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        pw.println("b_t3.micro_" + r.nextInt(1000)); // reservar
                        pw.flush();
                        br.readLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });

            /** Reservar a pedido e de seguida livertar */
            Thread t2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(r.nextInt(3000)); /** Adormece no máximo 3 segunos tempo  */
                        pw.println("c_t3.micro"); // reservar a pedido
                        pw.flush();
                        String id = br.readLine().split("_")[1]; // id da reserva
                        Thread.sleep(r.nextInt(1000)); /** Mantém a reserva durante X tempo */
                        pw.println("e_" + id); // libertam
                        pw.flush();
                        br.readLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });

            /** Faz as restantes operações de forma aleatória */
            Thread t3 = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(r.nextInt(2000)); /** Adoremce durante X tempo */

                        int v = r.nextInt(3); /** Operação aleatória */

                        if (v == 0) {
                            pw.println("y"); // consulta reservas do cliente
                            pw.flush();
                            br.readLine();

                        } else if (v == 1) {
                            pw.println("k"); // consulta servidores para alugar
                            pw.flush();
                            br.readLine();

                        } else if (v == 2) {
                            pw.println("d"); // consulta saldo do cliente
                            pw.flush();
                            br.readLine();
                        }

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });

            Thread t;

            if (i < 0.1f * N ) {  /** 10 % das Threads reservam a leilao */
                t = t1;
                t.start();
                try {
                    t.join();  /** Garantimos que as reservas a leiloe sao feitos antes das reservas a pedido */
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            else if (i < 0.7f * N) { /** 60 % das Threads reservam a pedido */
                t = t2;
                t2.start();
                threads.add(t);
            }
            else { /** 30 % das Threads fazem operações aleatórias */
                t = t3;
                t3.start();
                threads.add(t);
            }
        }

        for (Thread thread: threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
