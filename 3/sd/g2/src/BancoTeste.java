public class BancoTeste {

    public static void main(String[] args){
        int N_AGENCIAS = 100;
        Banco banco = new Banco();
        MinhaThread[] mt = new MinhaThread[N_AGENCIAS];

        for(int i = 0; i < N_AGENCIAS; i++){
            mt[i] = new MinhaThread(banco);
            mt[i].start();
        }

        for(int i = 0; i < N_AGENCIAS; i++){
            try{
                mt[i].join();
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println("Banco:"+banco.toString());
    }
}
