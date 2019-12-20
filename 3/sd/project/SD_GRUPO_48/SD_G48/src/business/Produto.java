package business;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Produto {
    /**
     * NUMERO_MAX_PRODUTOS corresponde ao limite máximo de Produtos(servidores) deste tipo.
     */
    static final int NUMERO_MAX_PRODUTOS = 50;

    String nome;
    float preco;    //  preco fixo
    int ocupados;

    Lock l;
    Condition isFull;

    /**
     * Construtor parametrizado.
     * @param nome nome do produto (servidor).
     */
    public Produto(String nome, float preco){
        this.nome = nome;
        this.preco = preco;
        this.ocupados = 0;
        l = new ReentrantLock();
        isFull = l.newCondition();
    }

    /**
     * business.Reserva um produto (servidor).
     */
    public void reservar(){
        while(ocupados == NUMERO_MAX_PRODUTOS){
            try {
                System.err.println("business.Servidor cheio! Impossivel reservar, à espera...");
                isFull.await();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        ocupados++;
    }

    /**
     * Liberta um produto (servidor).
     */
    public void libertar(){
        ocupados--;
        isFull.signal();
    }

    /**
     * Coloca toda a informação do objeto numa String.
     * @return retorna uma String com toda a informação do objeto.
     */
    public String toString(){
        StringBuilder sb = new StringBuilder("business.Produto={");
        sb.append(";nome=").append(nome);
        sb.append(";preco").append(preco);
        sb.append(";ocupados=").append(ocupados);
        sb.append(";l=").append(l);
        sb.append(";isFull").append(isFull).append("};");

        return sb.toString();
    }
}
