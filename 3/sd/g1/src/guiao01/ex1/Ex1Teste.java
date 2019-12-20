package guiao01.ex1;

public class Ex1Teste {

    private static final int N_THREADS = 5;

    public static void main(String[] args){

        Thread[] ths = new Thread[N_THREADS];

        //  obviamente isto é uma má implementação de Threads, pois não à sincronização do valor
        for(int i = 0; i < N_THREADS; i++) {
            ths[i] = new Thread(new Ex1(N_THREADS,i));
            ths[i].start();
        }

        //  o join() tem que ser feito fora do primeiro for, senão o programa era sequêncial;
        for(int i = 0; i < N_THREADS; i++) {
            try {
                ths[i].join();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
