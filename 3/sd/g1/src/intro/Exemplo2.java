package intro;

public class Exemplo2 implements Runnable{
    private int x;

    public Exemplo2(int x){
        this.x = x;
    }
    public void run(){
        for(int i = 0; i < this.x; i++){
            System.out.println(i);
        }
    }
}
