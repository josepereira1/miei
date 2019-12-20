package ex2;

import java.util.Random;

public class ThreadWarehouse extends Thread{
    Warehouse w;
    int id;

    public ThreadWarehouse(Warehouse w, int id){
        this.w = w;
        this.id = id;
    }

    @Override
    public void run() {
        Random r = new Random();
        boolean escolha = r.nextBoolean();

        if(escolha){
            int item = r.nextInt(100)+1;
            int quantidade = r.nextInt(10)+1;
            this.w.supply(String.valueOf(item), quantidade);
        }else {
            int item = r.nextInt(100)+1;
            String[] items = new String[1];
            items[0] = String.valueOf(item);
            try{
                this.w.consume(items);
            }catch (ItemNaoExisteException e){
                e.printStackTrace();
            }
        }
    }
}
