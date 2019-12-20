package guiao01.ex2;

public class CounterTeste{

    public static void main(String[] args){
        Counter c = new Counter();
        MinhaThread[] mt = new MinhaThread[10];

        for(int i = 0; i != 10; i++) {
            mt[i] = new MinhaThread(i,c);
            mt[i].start();
        }

        for(int i = 0; i != 10; i++){
            try{
                mt[i].join();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        System.out.println(c.get());
        /**
         * //   Se não quiser sincronizar os métodos diretamente na class,
         * //   posso aplicar aqui, quando uso o próprio objeto
         *
         * syncronized (c){System.out.println(c.get());
         */
    }

}
