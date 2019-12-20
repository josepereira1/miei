package guiao01.ex2;

public class MinhaThread extends Thread{

    public int id;
    public Counter c;

    public MinhaThread(int id, Counter c){
        this.id = id;
        this.c = c;
    }

    public void run(){
        for(int i = 0; i < 10000; i++){
            //System.out.println("%d:%d\n", id, c.get());
            c.increment();

            /**
            *   //   Se não quiser sincronizar os métodos diretamente na class,
            *   //   posso aplicar aqui, quando uso o próprio objeto
            * syncronized(c) = { c.increment() }
            **/
        }
    }
}
