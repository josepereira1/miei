package guiao01.ex1;

public class Ex1v2Teste {

    public static final int N = 5;

    public static void main(String[] args){
        Ex1v2[] ex = new Ex1v2[N];

        for(int i = 0; i < N; i++){
            ex[i] = new Ex1v2(N);
            ex[i].start();
        }

        for(int i = 0; i < N; i++) {
            try {
                ex[i].join();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
