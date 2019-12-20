public class Proxy implements Subject {
    private RealSubject realSubject;

    public Proxy(RealSubject realSubject){
        this.realSubject = realSubject;
    }

    @Override
    public void doOperation() {
        System.out.println("Before class!");
        realSubject.doOperation();
        System.out.println("After class!");
    }
}
