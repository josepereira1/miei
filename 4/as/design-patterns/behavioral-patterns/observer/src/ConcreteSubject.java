import java.util.*;

public class ConcreteSubject implements Subject {
    private int state;
    private Map<Integer,Observer> observers;
    private int lastId;

    public ConcreteSubject(){
        this.state = 0;
        this.observers = new HashMap<>();
        this.lastId = 0;
    }

    @Override
    public void registerObserver(ConcreteObserver concreteSubject) {
        lastId++;
        concreteSubject.id = lastId;
        System.out.println("registar observador com id " + lastId);
        observers.put(lastId , concreteSubject);
    }

    @Override
    public void removeObserver(int id) {
        System.out.println("remover observador com id " + id);
        observers.remove(id);
    }

    @Override
    public void notifyObservers() {
        System.out.println("notificar observadores");
        Object[] info = new  Object[1];
        info[0] = this.state;   //  generic (array of objects) info passed to observers
        for(Observer ob : observers.values())ob.update(info);
    }

    public int getState(){
        return this.state;
    }

    public void setState(int state){
        this.state = state;
    }
}
