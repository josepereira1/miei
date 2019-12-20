package ex1;

import java.util.Arrays;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class BoundedBuffer {                //FIFO 
     private int ocupados;  //ocupados
     private int tamanho;     //tamanho
     private int[] buffer;
     private int inicio;
     Lock l = new ReentrantLock();
     Condition isFull = l.newCondition();   //  fornecedor
     Condition isEmpty = l.newCondition();  //  consumidor
     
     public BoundedBuffer(){
         this.ocupados = 0;
         this.tamanho = 0;
         this.buffer = new int[10];
         this.inicio = 0;
     }
     

     public BoundedBuffer(int ocupados, int tamanho, int[] buffer, int inicio){
         this.ocupados = ocupados;
         this.tamanho = tamanho;
         this.buffer = new int[tamanho];
         for(int i = 0; i < this.buffer.length; i++)
            this.buffer[i] = buffer[i];
         this.inicio = inicio;
     }
     
     // sincronizar para cada um conseguir acader. Exclusão mútua

     public void put(int v){
        l.lock();
        while(this.ocupados == this.tamanho && (this.tamanho != 0 && this.ocupados != 0)){  //Não pode avançar enquanto isto for verdade. N libertar RL, "adormecer", obter RL VARIAVEIS DE CONDICAO, WAIT()
            System.out.println("Estou à espera no put()!");
            try{
                 isFull.await();
             }catch(InterruptedException e){
                 e.printStackTrace();
             }
        }
        System.out.println("CONSEGUI FAZER O PUT()!");
        int i = (inicio + this.ocupados) % (this.tamanho);
        this.buffer[i] = v;
        this.ocupados++;
        isEmpty.signalAll();

        //  Acorda as threads que estão a dormir. Não conseguimos saber que thread que ganha o lock, "random" para já.
         //  NotifyAll pode acordar alguém que está bloqueado tanto no put como no get
        //  isEmpty.signalAll() serve para avisar ao isEmpty do get que foi inserido um elemento, e que ele pode fazer get
        //  e o mesmo acontece no get, ele faz isFull.signalAll para avisar o put que ele tirou um elemento e então que ele pode adicionar um.

         //  IMPORTANTE: neste caso estamos a acordar apenas algumas THREADS APENAS AQUELAS que tem o isEmpty.await(), e assim o isEmpty.signallAll().
         l.unlock();
     }


     public int get(){
        l.lock();
        while(this.ocupados == 0) {
            System.out.println("Estou à espera no get()!");
            try{
                isEmpty.await();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println("CONSEGUI FAZER O PUT()!");
        int y = this.buffer[inicio];
        inicio = (inicio + 1) % tamanho;
        this.ocupados--;
        isFull.signalAll();
        l.unlock();
        return y;
      }

    @Override
    public String toString() {
        return "BoundedBuffer{" +
                "ocupados=" + ocupados +
                ", tamanho=" + tamanho +
                ", buffer=" + Arrays.toString(buffer) +
                ", inicio=" + inicio +
                ", l=" + l +
                ", isFull=" + isFull +
                ", isEmpty=" + isEmpty +
                '}';
    }
}
