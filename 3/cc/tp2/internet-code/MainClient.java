public class MainClient{


    public static void main(String[] args){
        try{
            EchoClient client = new EchoClient();

            client.sendEcho("Olá tudo bem!");

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}