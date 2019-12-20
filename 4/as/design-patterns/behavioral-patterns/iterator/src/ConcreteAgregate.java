import java.util.Iterator;

public class ConcreteAgregate<T> implements Agregate{
    private T[] data;
    private ConcreteIterator concreteIterator;
    private int size;

    public ConcreteAgregate(T[] data, int size){
        this.data = data;
        this.size = size;
    }

    @Override
    public Iterator<T> iterator() {
        this.concreteIterator = new ConcreteIterator(this.data, size);
        return concreteIterator;
    }
}
