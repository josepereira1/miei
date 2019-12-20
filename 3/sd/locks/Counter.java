import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/*
esta class é apenas para entender como se deve manipular
objetos com lock e verificar que temos que ter precaução 
a usar os mesmos, pois o compilador não "bloqueia" o objeto em si,
nós é que temos que testar no inicio de cada utilização do mesmo 
se o objeto está bloqueado, caso esse teste não seja feito vamos 
ter acesso ao mesmo, e vai tudo por água abaixo.
*/

public class Counter {
    int num;

    Lock l;

    /**
     * O lock apenas controla, não garante que o objeto
     * fica bloqueado, o programador é que tem que testar
     * sempre em cada método se o lock está bloqueado.
     */

    public Counter(){
        num = 0;
        l = new ReentrantLock();
    }

    public int get(){
        /**
         * Aqui se não se fizer Lock ele vai permitir
         * "aceder" ao objeto, mesmo que eu tenha feito
         * lock no método inc(), pq o Lock é de controlo,
         * ou seja, tenho que ser eu a verificar se o lock
         * está bloqueado ou não.
         */
        return num;
    }

    public void inc(){
        l.lock();
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        num++;
        l.unlock();
    }

    public static void main(String[] args){
        Counter c = new Counter();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("THREAD 1");
                c.inc();
                System.out.println("INCREMENTO DONE!");
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("THREAD 2");
                System.out.println("num="+c.get());
                System.out.println("GET DONE!");
                //  este método só deveria conseguir fazer o get no momento em que o inc() liberta-se o lock
                //  no entanto se executarmos este código verificamos que ele consegue aceder ao Counter,
                //  mesmo ele estando "bloqueado" pelo método inc(), para corrigir deviamos colocar l.lock()
                //  no get, para ele verificar se o lock está bloqueado por outro
            }
        });

        t1.start();
        /**
         * isto é para garantir que a thread 2 começa sempre depois da thread 1.
         */
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();
    }
}
