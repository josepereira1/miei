public class Client {
    public static void main(String[] args){
        IProduct productA = Creator.factoryMethodA();
        IProduct productB = Creator.factoryMethodB();
    }
}
