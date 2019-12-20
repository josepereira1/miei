public class ConcreteClass2 extends AbstractClass {
    public int value;

    @Override
    public void primite1() {
        value += 3;
        System.out.println(value);
    }

    @Override
    public void primite2() {
        value += 4;
        System.out.println(value);
    }
}
