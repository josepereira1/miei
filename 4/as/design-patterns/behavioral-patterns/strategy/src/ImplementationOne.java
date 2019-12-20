public class ImplementationOne implements Strategy {
    @Override
    public void doSomething() {
        System.out.println(this.getClass().toString());
    }
}
