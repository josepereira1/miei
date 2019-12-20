package Ex4;

import java.util.Random;

public class MinhaThread extends Thread {

    Banco banco;

    public MinhaThread(){
        this.banco = new Banco();
    }

    public MinhaThread(Banco banco){
        this.banco = banco;
    }

    public void run(){
        Random r = new Random();
        this.banco.credito(r.nextInt(10000), r.nextInt(10));
    }
}
