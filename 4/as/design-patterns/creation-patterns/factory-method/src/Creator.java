public class Creator {
    public static IProduct factoryMethodA(){
        return new ProductA();
    }

    public static IProduct factoryMethodB(){
        return new ProductB();
    }
}
