public class Main {
    public static void main(String[] args){
        /**
         * O design pattern proxy permite executar código antes e/ou depois de um método, neste caso, o doOperation().
         */
        Subject subject = new Proxy(new RealSubject());

        subject.doOperation();
    }
}
