import java.util.Arrays;

public class Banco {
    private int[] contas = new int[100];

    public Banco(int saldo, int[] contas, int[] creditos) {
        this.contas = contas;
    }

    public Banco(){
        for(int i = 0; i < 10; i++)this.contas[i] = 0;
    }

    synchronized public int[] getContas(){
        return this.contas;
    }

    synchronized public void setContas(int[] contas){
        this.contas = contas;
    }

    @Override
    public String toString() {
        return "Banco{" +
                "contas=" + Arrays.toString(contas) +
                '}';
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


}
