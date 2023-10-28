public class Client {
    public static void main(String[] args){
        //  criamos um componente, que apenas notifica por email, 1 layer
        Component c = new ConcreteComponent();
        c.execute("Hello world!");

        System.out.println("--------------------------------------------");

        //  vou adicionar comportamento extra ao componente c, que é enviar notificação também ao slack, 2 layers
        Component d1 = new ConcreteDecoratorSlack(c);
        d1.execute("Hello world!");

        System.out.println("--------------------------------------------");

        //  por fim, vou adicionar ainda mais comportamento, isto é, mais um layer, para enviar por SMS, 3 layers
        Component d2 = new ConcreteDecoratorSMS(d1);
        d2.execute("Hello world!");
    }
}
