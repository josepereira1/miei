package business;

import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Cliente {

    public String email;
    public String password;
    public float saldo;
    public Lock l;
    public PrintWriter pw;
    public Set<String> reservas;

    /**
     * Construtor parametrizado para o business.Cliente.
     * @param email email/ ID do cliente.
     * @param password password do cliente.
     */
    public Cliente(String email, String password) {
        this.email = email;
        this.password = password;
        this.saldo = 0f;
        this.l = new ReentrantLock();
        this.pw = null;
        this.reservas = new HashSet<>();
    }

    /**
     * Devolve o Cliente em formato String.
     * @return retorna o Cliente em formato String.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Cliente{");
        sb.append("email=").append(this.email).append(", ");
        sb.append("password=").append(this.password).append(", ");
        sb.append("saldo=").append(this.saldo);
        sb.append("l=").append(this.l).append(", ");
        sb.append("pw=").append(this.pw).append(", ");
        sb.append("reservas=").append(this.reservas);
        sb.append("}");
        return sb.toString();
    }
}