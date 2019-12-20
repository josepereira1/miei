import java.util.Iterator;

public class ConcreteIterator<E> implements Iterator {
    private E[] data;
    private int currentPosition = 0;
    private int size = 0;

    public ConcreteIterator(E[] data, int size){
        this.data = data;
        this.size = size;
    }

    @Override
    public boolean hasNext() {
        if(currentPosition < size)return true;
        return false;
    }

    @Override
    public E next() {
        return this.data[this.currentPosition++];
    }

    @Override
    public void remove() {
    }
}
