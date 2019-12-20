package intro;

import java.util.concurrent.locks.ReentrantLock;

public class Conta {

    private int saldo;
    private Integer id;
    ReentrantLock rl = new ReentrantLock();


    public Conta(){
        this.saldo = 0;
    }

    public Conta(int saldo, Integer id){
        this.saldo = saldo;
        this.id = id;
    }

    public Conta(int saldo){
        this.saldo = saldo;
    }

    public int getSaldo() {
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

    synchronized public void credito(int valor){
        this.saldo = saldo + valor;
    }

    public void debito(int valor){
        rl.lock();
        this.saldo = saldo - valor;
        rl.unlock();    //  nunca esquecer do unlock();
    }
}
