public class MainServer {
        public static void main(String[] args){
            try{
                EchoServer server = new EchoServer();
                server.run();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
}
