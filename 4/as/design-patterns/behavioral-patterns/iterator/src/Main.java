import java.util.Iterator;

public class Main {
    /*
        Design Pattern Iterator
        Provides a way of accessing to a container (aggregate) without exposing
        the internal representation of the container elements
        The aggregate provides a method to create an iterator, object that tracks
        the current element of the aggregate. It has methods to get the current
        element and to verify if there are more elements in the aggregate.
     */
    public static void main(String[] args){
        Person[] people = new Person[10];
        people[0] = new Person("Rita", "Monteiro", 21);
        people[1] = new Person("Joana", "Norton", 23);

        Agregate agregateOfPeople = new ConcreteAgregate(people, 2);

        Iterator it1 = agregateOfPeople.iterator();

        while (it1.hasNext()){
            System.out.println(it1.next());
        }

        Car[] cars = new Car[10];
        cars[0] = new Car(4,5,100);
        cars[1] = new Car(6,5,150);

        Agregate agregateOfCars = new ConcreteAgregate(cars, 2);

        Iterator it2 = agregateOfCars.iterator();

        while (it2.hasNext()){
            System.out.println(it2.next());
        }

    }
}
