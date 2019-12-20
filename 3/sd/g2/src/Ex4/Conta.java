package Ex4;

public class Conta {

    private int saldo;
    private Integer id;

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

    synchronized public int getSaldo() {
        return saldo;
    }

    synchronized public void setSaldo(int saldo) {
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

    synchronized public void debito(int valor){
        this.saldo = saldo - valor;
    }
}
