public class Main {
    public static void main(String[] args){
        /*
        *  O design pattern singleton é usado para garantir que apenas
        * é criada uma instância da classe Singleton. Com o exemplo a
        * seguir, consegue-se perceber que o singleton1 e singleton2
        * são o mesmo objeto, pois quando se declara o singleton2 e
        * é feito o print da variável state, ela tem o mesmo valor
        * que a do singleton1, pois na realidade são o mesmo objeto.
        * Isto consegue-se, pois o método de classe getInstance,
        * verifica se a variável instance está a null.
        * */

        Singleton singleton1 = Singleton.getInstance();
        singleton1.state = 2;
        Singleton singleton2 = Singleton.getInstance();
        System.out.println(singleton2.state);
    }
}
