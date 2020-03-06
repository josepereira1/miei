public class Main {
    /*
        Design Pattern Observer:
        Implement one to many dependency, where dependent objects are notified when the object state changes.
     */

    public static void main(String[] args){
        int numberOfObservers = 5;
        ConcreteSubject subject = new ConcreteSubject();    //  objecto observado

        //  objeto que observa o subject(objecto observado)
        //  a criação deste ConcreteObserver é apenas para poder utilizar mais abaixo
        ConcreteObserver ob1 = new ConcreteObserver(subject);

        //  criação de vários observers
        for(int i = 0; i < numberOfObservers; i++) new ConcreteObserver(subject);

        System.out.println("estado inicial = " + subject.getState());

        try {
            System.out.println("esperar 2 segundos");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //  mudamos o estado, e de seguida notificar os observadores desta mudança
        subject.setState(50);
        System.out.println("alterar estado para " + subject.getState());
        subject.notifyObservers();

        /*
        mudamos o estado, mas não notificamos imediatamente os observadores,
        para verificar que se estes não forem notificados, têm valores de estado desatualizados
         */
        subject.setState(5000);

        System.out.println("alterar estado para " + subject.getState());
        System.out.println("estado atual do observador 1 = " + ob1.getState());

        subject.notifyObservers();

        subject.removeObserver(3);
        subject.setState(10000);
        System.out.println("alterar estado para " + subject.getState());
        subject.notifyObservers();

    }
}
