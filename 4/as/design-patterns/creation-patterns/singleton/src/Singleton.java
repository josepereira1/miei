public class Singleton {
    private static Singleton singleton;
    public int state;

    //  we need to declare the empty constructor, to ensure no instances are created with this
    private Singleton(){

    }

    public static Singleton getInstance(){
        if(singleton == null) singleton = new Singleton();
        return singleton;
    }
}
