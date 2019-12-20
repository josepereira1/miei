import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Composite implements Component {
    Collection<Component> components;

    public Composite(){
        this.components = new ArrayList<>();
    }


    @Override
    public void operation() {
        for(Component c : components)c.operation();
    }

    @Override
    public void add(Component c) {
        this.components.add(c);
    }

    @Override
    public void remove(Component c) {
        this.components.remove(c);
    }

    @Override
    public Component getChild(int id) {
        Component res = null;
        Iterator<Component> it = this.components.iterator();

        while(id >= 0 && it.hasNext()){
            res = it.next();
            id--;
        }
        return res;
    }

    @Override
    public String toString() {
        return this.components.toString();
    }
}
