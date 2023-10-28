public class ConcreteDecoratorSlack extends BaseDecorator {
    public ConcreteDecoratorSlack(Component c) {
        super(c);
    }

    @Override
    public Object execute(Object obj){
        super.execute(obj);
        extra(obj);
        return null;
    }

    public Object extra(Object obj){
        System.out.println("Notificação por Slack: " + obj);
        return null;
    }
}
