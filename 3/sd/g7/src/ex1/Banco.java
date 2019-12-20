package ex1;
import java.util.Arrays;

public class Banco {
    public static final int N_CONTAS = 10;
    private int[] contas = new int[N_CONTAS];

    public Banco(int saldo, int[] contas, int[] creditos) {
        this.contas = contas;
    }

    public Banco(){
        for(int i = 0; i < N_CONTAS; i++)this.contas[i] = 0;
    }

    synchronized public int[] getContas(){
        return this.contas;
    }

    synchronized public void setContas(int[] contas){
        this.contas = contas;
    }

    synchronized public void credito(int valor, int i){
        this.contas[i] = this.contas[i] + valor;
    }

    synchronized public void debito(int valor, int i){
        this.contas[i] = this.contas[i] - valor;
    }

    synchronized public int consulta(int i){
        return this.contas[i];
    }

    synchronized public void transferir(int valor, int src, int dest){
        this.debito(valor,src);
        this.credito(valor,dest);
    }

    @Override
    public String toString() {
        return "Banco{" +
                "contas=" + Arrays.toString(contas) +
                '}';
    }
}
