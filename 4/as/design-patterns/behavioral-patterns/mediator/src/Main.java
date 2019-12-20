public class Main {
    /*
        Desing Pattern Mediator:
        Implements a set of dependencies among objects in order to decouple object implementations
        Create a mediator object in charge of managing the dependencies among objects

     */
    public static void main(String[] args){
        ConcreteMediator mediator = new ConcreteMediator();
        Colleague c1 = new Colleague1(mediator);
        Colleague c2 = new Colleague2(mediator);
        mediator.colleagues.add(c1);
        mediator.colleagues.add(c2);

        System.out.println("Last message of Colleague 2: " + c2.lastMsg);

        System.out.println("Colleague 1 send message to Colleague 2!");

        c1.send("Colleague2", "Olá Colleague 2!");

        System.out.println("Last message of Colleague 2: " + c2.lastMsg);
    }
}
