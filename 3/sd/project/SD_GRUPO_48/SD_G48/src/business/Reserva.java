package business;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Reserva implements Comparable{

    public String id;
    public boolean tipo;    //  tipo = true -> reserva a pedido ou false -> reserva a leilão
    public LocalDateTime inicio;
    public LocalDateTime last;
    public String clienteId;
    public String servidorId;
    private final float preco;

    public Lock l;

    public Reserva(String id,boolean tipo, String clienteId, String servidorId, float preco) {
        this.id = id;
        this.tipo = tipo;
        this.inicio = LocalDateTime.now();
        this.last = LocalDateTime.now();
        this.clienteId = clienteId;
        this.servidorId = servidorId;
        this.preco = preco;

        this.l = new ReentrantLock();
    }

    public float total() {
        long dist = this.last.until(LocalDateTime.now(), ChronoUnit.SECONDS); // total de horas
        this.last = LocalDateTime.now();

        return (dist) * this.preco;
    }

    @Override
    public int compareTo(Object o) {
        Reserva reserva = (Reserva) o;
        return this.id.compareTo(reserva.id);
    }
}
