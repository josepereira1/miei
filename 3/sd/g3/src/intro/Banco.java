package intro;

import java.util.Map;
import java.util.Objects;

public class Banco {

    Map<Integer, Conta> contas;
    float saldo;

    public Banco(Map<Integer, Conta> contas, float saldo) {
        this.contas = contas;
        this.saldo = saldo;
    }

    public Map<Integer, Conta> getContas() {
        return contas;
    }

    public void setContas(Map<Integer, Conta> contas) {
        this.contas = contas;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Banco banco = (Banco) o;
        return Float.compare(banco.saldo, saldo) == 0 &&
                Objects.equals(contas, banco.contas);
    }

    @Override
    public String toString() {
        return "Banco{" +
                "contas=" + contas +
                ", saldo=" + saldo +
                '}';
    }
}
