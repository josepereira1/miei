public class Invoker extends Thread {
    private Command command;

    public Invoker(Command command){
        this.command = command;
    }

    @Override
    public void run(){

        while(true){
            this.command.execute();
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
