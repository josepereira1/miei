public class Colleague {
    protected Mediator mediator;

    String lastMsg = "";

    public Colleague(Mediator mediator){
        this.mediator = mediator;
    }

    public void receive(String msg){
        this.lastMsg = msg;
    }

    public void send(String destination, String msg){
        mediator.send(destination,msg);
    }
}
