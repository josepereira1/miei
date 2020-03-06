public class ConcreteObserver implements Observer {
    public int id;
    private Subject subject;
    private int state;

    public ConcreteObserver(ConcreteSubject subject){
        this.subject = subject;
        this.subject.registerObserver(this);//  o próprio ConcreteObserver se regista como observador
    }

    @Override
    public void update(Object[] args) {
        if(args[0] instanceof  Integer)this.state = (Integer) args[0];
        System.out.println("id = "+ this.id + " | estado = " + this.state);
    }

    // outros métodos

    // ...

    public int getState(){
        return this.state;
    }
}
