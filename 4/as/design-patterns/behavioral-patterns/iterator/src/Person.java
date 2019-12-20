public class Person {
    String firstName;
    String lastName;
    int age;

    public Person(String firstName, String lastName, int age){
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder("Pessoa={");
        sb.append(";firstName=").append(firstName);
        sb.append(";lastName=").append(lastName);
        sb.append(";age=").append(age).append("};");
        return sb.toString();
    }
}
