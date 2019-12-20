public class Main {
    public static void main(String[] args){
        AbstractClass framework1 = new ConcreteClass1();

        framework1.templateMethod();

        AbstractClass framework2 = new AbstractClass() {
            @Override
            public void primite1() {
                System.out.println("primitive1");
            }

            @Override
            public void primite2() {
                System.out.println("primitive2");
            }
        };

        framework2.templateMethod();
    }
}
