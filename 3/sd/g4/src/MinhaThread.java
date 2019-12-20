import java.util.Random;

public class MinhaThread extends Thread {

    BoundedBuffer bf;
    int id;

    public MinhaThread(BoundedBuffer bf, int id){
        this.bf = bf;
        this.id = id;
    }

    public void run(){
        Random random = new Random();
        if(random.nextBoolean()) {
            System.out.println("retirado o valor: "+this.bf.get());
        }else{
            int randomNumber = random.nextInt(10);
            System.out.println("inserido o valor: "+randomNumber);
            bf.put(randomNumber);
        }
        System.out.println("Thread "+this.id+": "+bf.toString());
    }
}
