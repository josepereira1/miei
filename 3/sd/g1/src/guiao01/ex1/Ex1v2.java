package guiao01.ex1;

public class Ex1v2 extends Thread{
    private int n;

    public Ex1v2(int n){
        super();
        this.n = n;
    }

    public void run(){
        for(int i = 0; i < n; i++)System.out.println("ThreadId="+this.getId()+" | "+(i+1));
    }
}
