package ex1;

import java.util.concurrent.locks.ReentrantLock;

public class Conta implements Comparable<Conta> {

    private float saldo;
    private Integer id;
    public ReentrantLock rl = new ReentrantLock();

    /**
     * A variável rl, serve para fazer lock a este objeto, a razão de ser public, é para que se consiga fazer lock do exterior,
     * tb se podia ter feito métodos para o fazer, e nesse caso não seria necessário que fosse public,
     * mas isso não é o mais importante, pois a razão de não fazermos locks dentro da class Conta, é pq assim
     * conseguimos fazer two fase locking, ou seja, primeiro fazer lock ao Banco, e depois consoante o método
     * faz-se lock às contas que acharmos necessário, e após fazermos lock às contas, podemos fazer logo unlock do Banco
     * pq não fizemos os locks dentro desta class, caso contrário, teriamos que esperar, que os métodos desta class
     * terminem para fazer unlock do Banco, isto é muito mau a nível de eficiência, pois estamos a aumentar o tempo
     * critíco, ou seja, o tempo em que o banco está bloqueado desnecessáriamente;
     */


    public Conta(){
        this.saldo = 0;
    }

    public Conta(float saldo, Integer id){
        this.saldo = saldo;
        this.id = id;
    }

    public Conta(float saldo){
        this.saldo = saldo;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Conta conta = (Conta) o;
        return saldo == conta.saldo;
    }

    @Override
    public String toString() {
        return "Conta{" +
                "saldo=" + saldo +
                '}';
    }

    public void credito(float valor){
        this.saldo = saldo + valor;
    }

    public void debito(float valor){
        this.saldo = saldo - valor;
    }

    @Override
    public int compareTo(Conta o) {
        int id = o.getId();
        if(this.id == id)return 0;
        else{
            if(this.id > id)return 1;
            else return -1;
        }
    }
}
