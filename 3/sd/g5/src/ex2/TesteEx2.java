package ex2;

public class TesteEx2 {

    final static int N_THREADS = 10;

    public static void main(String[] args){
        /*ThreadWarehouse[] tw = new ThreadWarehouse[N_THREADS];
        Warehouse w = new Warehouse();

        for(int i = 0; i < N_THREADS;i++){
            tw[i] = new ThreadWarehouse(w,i);
            tw[i].start();
        }

        for(int i = 0; i < N_THREADS; i++){
            try{
                tw[i].join();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }*/

        Warehouse wareHouse = new Warehouse();
        wareHouse.supply("1", 10);
        wareHouse.supply("2",0);
        wareHouse.supply("3",1);

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("t1: Vou tentar inserir tem 1");
                wareHouse.supply("1",1);
                System.out.println("t1: Consegui adicionar item!");
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try{
                    wareHouse.consume(new String[]{"1"});
                }catch (ItemNaoExisteException e){
                    e.printStackTrace();
                }
                System.out.println("t2: consumi...");
            }
        });

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Vou consumir de 2!");
                try{
                    wareHouse.consume(new String[]{"2"});
                }catch (ItemNaoExisteException e){
                    e.printStackTrace();
                }
                System.out.println("Consegui consumir!");
            }
        });

        Thread t4 = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    Thread.sleep(10000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println("Adicionei 3 unidadesde 2!");
                wareHouse.supply("2",3);
            }
        });

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        System.out.println(wareHouse);

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
