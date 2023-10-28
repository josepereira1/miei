public class BaseDecorator implements Component{
    private Component wrappee;

    public BaseDecorator(Component c){
        this.wrappee = c;
    }

    @Override
    public Object execute(Object obj) {
        this.wrappee.execute(obj);
        return null;
    }
}
