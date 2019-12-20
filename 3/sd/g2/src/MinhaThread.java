import java.util.Random;

public class MinhaThread extends Thread{

    private Banco banco;
    int saldo = 0;

    public MinhaThread(){
        this.saldo = 0;this.banco = new Banco();
    }

    public MinhaThread(Banco banco){
        this.saldo = saldo;this.banco = banco;
    }

    public void run(){
        Random rd = new Random();
        for(int i = 0; i < 1000; i++){
            this.banco.credito(rd.nextInt(10000), rd.nextInt(10));
        }
    }
}
