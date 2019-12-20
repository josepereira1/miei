package ex1;

import java.io.IOException;

public class TesteEx1 {

    public static final int N_MAX_THREADS = 3;

    public static void main(String[] args){
        ThreadBanco[] tb = new ThreadBanco[N_MAX_THREADS ];
        Banco banco = new Banco();

        banco.createAccount(500);
        banco.createAccount(500);
        banco.createAccount(500);
        banco.createAccount(500);
        banco.createAccount(500);
        /*banco.createAccount(500);
        banco.createAccount(500);
        banco.createAccount(500);
        banco.createAccount(500);
        banco.createAccount(500);
        banco.createAccount(500);*/
        //System.out.println("Estado inicial do banco: "+banco);

        for(int i = 0; i < N_MAX_THREADS; i++) {
            tb[i] = new ThreadBanco(banco,i);
            tb[i].start();
            //System.out.println("Estado do banco no MAIN="+banco);
        }

        for(int i = 0; i < N_MAX_THREADS; i++)
            try{
                tb[i].join();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
    }
}
