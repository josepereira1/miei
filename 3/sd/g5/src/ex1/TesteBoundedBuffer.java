package ex1;

public class TesteBoundedBuffer {

    public static void main(String[] args){
        int MAX_TH = 20;
        MinhaThread[] mt = new MinhaThread[MAX_TH];
        BoundedBuffer bf = new BoundedBuffer();

        for(int i = 0; i < MAX_TH; i++){
            mt[i] = new MinhaThread(bf,i);
            mt[i].start();
        }

        for(int i = 0; i < MAX_TH; i++){
            try{
                mt[i].join();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
