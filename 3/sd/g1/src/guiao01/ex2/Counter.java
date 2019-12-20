package guiao01.ex2;

public class Counter{
    public int cont;

    public Counter(){
        this.cont = 0;
    }

    public Counter(int cont){
        this.cont = cont;
    }

    synchronized public void increment(){
        this.cont++;
    }

    /*
    syncronized -> execução serializada de métodos syncronized
    invocados concorrentemente num mesmo objeto.
    */

    synchronized public int get(){
        return this.cont;
    }
}
