public class Main {
    static final int CLIENTS = 8;

    public static void main(String[] args){
        /**
         * O design pattern ActiveObject controla a concorrência
         * de acesso ao objecto ActiveObject, equivalente ao synchronized
         */

        ActiveObject activeObject = new ActiveObject();

        Client[] clients = new Client[CLIENTS];

        for(int i = 0; i < CLIENTS; i++){
            clients[i] = new Client(activeObject);
            clients[i].start();
        }

        for(Client c : clients) {
            try {
                c.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //  fazendo increment(), no final o value = CLIENTS
        //  fazendo decrement(), no final o value = -CLIENTS

        //  isto apenas se consegue porque há controlo de
        //  concorrência, caso contrário o acesso não
        //  era controlado, e o value era diferente

        System.out.println(activeObject.value);
    }
}
