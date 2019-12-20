package guiao01.ex1;


public class Ex1 implements Runnable{
    //  Exercício 1:
    private int id;
    private int n;

    public Ex1(int n, int id){
        this.n = n;
        this.id = id;
    }

    public void run(){

        for(int i = 0; i < n; i++)
            System.out.println("id="+this.id+" | "+(i+1));
    }
}
