public class Car {
    private int wheels = 0;
    private int doors = 0;
    private int cv = 0;

    public Car(int wheels, int doors, int cv) {
        this.wheels = wheels;
        this.doors = doors;
        this.cv = cv;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder("Car={");
        sb.append("wheels=").append(wheels);
        sb.append(";doors=").append(doors);
        sb.append(";cv=").append(cv).append("};");
        return sb.toString();
    }
}
