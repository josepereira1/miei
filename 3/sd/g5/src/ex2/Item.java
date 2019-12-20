package ex2;

import java.util.Set;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Item implements Comparable<Item>{
final static int SIZE = 10; //  consegue guardar 10 elementos deste item

    private String nome;
    private int quantidade;
    ReentrantLock rl = new ReentrantLock();
    Condition isFull = rl.newCondition();
    Condition isEmpty = rl.newCondition();

    public Item(){
        this.nome = "";
        this.quantidade = 0;
    }

    public int getSize(){
        return SIZE;
    }

    public Item(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void add(){

        this.quantidade++;
    }

    public void add(int quantity){
        for(int k = 0; k <quantity;k++) {
            while ((this.getQuantidade()) >= this.getSize()) {
                try {
                    this.isFull.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            this.setQuantidade(this.getQuantidade() + 1);
            this.isEmpty.signal();
        }
    }

    public void remove(){
            while (this.getQuantidade() == 0) {
                try {
                    this.isEmpty.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            this.setQuantidade(this.getQuantidade() - 1);
            this.isFull.signal();
    }

    @Override
    public String toString() {
        return "Item{" +
                "nome='" + nome + '\'' +
                ", quantidade=" + quantidade +
                ", rl=" + rl +
                '}';
    }

    public int compareTo(Item o){
        return this.getNome().compareTo(o.getNome());
    }
}
