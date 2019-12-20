import java.util.Arrays;

public class BoundedBuffer {
    int [] array;
    int tamanho;
    int ocupados;
    int inicio = 0;  //  posição incial do FIFO

    /*
        usamos o método de inserir à esquerda (array circular), que é
        mais eficiente, pois não há troca de valores e apenas de índices;
    */

    public BoundedBuffer(int tamanho){
        this.tamanho = tamanho;
        this.array = new int[this.tamanho];
        this.ocupados = 0;
    }



    synchronized int get(){
        while(ocupados == 0){
            try{
                wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        int valor = array[inicio];
        inicio = (inicio+1)%tamanho;
        //  o resto sobre o tamanho, é para
        //  a situação limite quando
        //  o inicio +1 = tamanho e dá zero
        //  e volta ao ínicio
        ocupados--;
        notifyAll();
        return valor;
    }

    synchronized void put(int v){
        while(ocupados == tamanho){
            try{
                wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        array[(inicio+ocupados)%tamanho]=v;
        ocupados++;
        notifyAll();
    }

    @Override
    public String toString() {
        return "BoundedBuffer{" +
                "array=" + Arrays.toString(array) +
                ", tamanho=" + tamanho +
                ", ocupados=" + ocupados +
                ", inicio=" + inicio +
                '}';
    }
}
