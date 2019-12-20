package intro;

public class BoundedBuffer {
    /*
    ISTO É UMA EXPLICAÇÃO!
     */
    int tamanho;
    int ocupado = 0;

    /*
    *   produtores(puts) ----> [BoundedBuffer(FIFO)] <---  clientes(gets)
    */

    /*  todos os objetos quando criados criam automaticamente uma variável ReentratLock
     */

    public BoundedBuffer(int tamanho) {
        this.tamanho = tamanho;
    }

    synchronized public void put(){ //  não podemos ter 2 puts simultâneos
        /*
        * 1-libertar o lock
        * 2-esperar que algo mude
        * 3-guardar lock
        * */
        while(ocupado == tamanho) {
            try{
                wait();     //  o wait() tem que estar SEMPRE num ciclo
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        ocupado++;
        notifyAll();    //  acorda todas as Threads
    }

    synchronized public int get() { //  não podemos ter 2 gets simultâneos

        while (ocupado == 0){
            try{
                wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        ocupado--;
        notifyAll();    //  acorda todas as Threads, as que estão bloqueadas no put()
        return ocupado;
    }
}
