import java.util.Random;

public class Client extends Thread {
    private ActiveObject activeObject;

    public Client(ActiveObject activeObject){
        this.activeObject = activeObject;
    }

    @Override
    public void run(){
        try {
            this.activeObject.decrement();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
