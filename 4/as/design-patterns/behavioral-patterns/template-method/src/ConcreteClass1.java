public class ConcreteClass1 extends AbstractClass {
    public int value = 0;

    @Override
    public void primite1() {
        value += 1;
        System.out.println(value);
    }

    @Override
    public void primite2() {
        value += 2;
        System.out.println(value);
    }
}
