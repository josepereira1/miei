public class ConcreteComponent implements Component {
    @Override
    public Object execute(Object obj) {
        System.out.println("Notificação por Email: " + obj);
        return null;
    }
}
