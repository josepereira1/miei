

public class Client {
    public static void main(String[] args){
        Composite composite = new Composite();

        Component c1 = new Leaf(1);
        Component c2 = new Leaf(2);
        Component c3 = new Leaf(3);

        composite.add(c1);
        composite.add(c2);
        composite.add(c3);

        composite.operation();

        System.out.println(composite.toString());

        System.out.println(composite.getChild(2));
    }
}
