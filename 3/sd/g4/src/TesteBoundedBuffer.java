public class TesteBoundedBuffer {

    static final int N_THREADS = 5;

    public static void main(String[] args){
        MinhaThread[] mt = new MinhaThread[N_THREADS];
        BoundedBuffer bf = new BoundedBuffer(5);

        for(int i = 0; i < N_THREADS; i++){
            mt[i] = new MinhaThread(bf,i);
            mt[i].start();
            //System.out.println(bf.toString());
        }

        for(int i = 0; i < N_THREADS; i++){
            try{
                mt[i].join();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
