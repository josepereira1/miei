public class Client {
    public static void main(String[] args){
        Strategy strategy1 = new ImplementationOne();
        Strategy strategy2 = new ImplementationTwo();
        strategy1.doSomething();
        strategy2.doSomething();
    }
}
