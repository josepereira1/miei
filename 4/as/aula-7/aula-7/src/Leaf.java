public class Leaf implements Component {
    private int valor = 0;

    public Leaf(int valor){
        this.valor = valor;
    }

    @Override
    public void operation() {
        this.valor++;
    }

    @Override
    public void add(Component c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void remove(Component c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Component getChild(int id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Leaf={");
        sb.append("valor=").append(valor).append("};");
        return sb.toString();
    }
}
