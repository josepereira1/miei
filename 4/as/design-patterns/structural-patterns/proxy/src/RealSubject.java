public class RealSubject implements Subject {
    @Override
    public void doOperation() {
        System.out.println(this.getClass().toString());
    }
}
