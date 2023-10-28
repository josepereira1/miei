public class ConcreteDecoratorSMS extends BaseDecorator {
    public ConcreteDecoratorSMS(Component c) {
        super(c);
    }

    @Override
    public Object execute(Object obj){
        super.execute(obj);
        extra(obj);
        return null;
    }

    public Object extra(Object obj){
        System.out.println("Notificação por SMS: " + obj);
        return null;
    }
}
