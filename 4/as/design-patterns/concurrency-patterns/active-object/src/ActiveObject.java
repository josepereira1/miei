import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ActiveObject {
    public int value = 0;

    //  BlockingQueue tem controlo de concorrência, ou seja, put de diferentes threads é controlado
    private BlockingQueue<Runnable> tasks = new LinkedBlockingQueue<>();

    public ActiveObject(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        tasks.take().run();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    public void increment() throws InterruptedException {
        tasks.put(new Runnable() {
            @Override
            public void run() {
                value++;
            }
        });
    }

    public void decrement() throws InterruptedException {
        tasks.put(new Runnable() {
            @Override
            public void run() {
                value--;
            }
        });
    }
}
