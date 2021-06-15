package ex41;

public class Person {

    private String firstName;
    private String lastName;

    public Person(String first, String last){
        this.firstName = first;
        this.lastName = last;
    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }
}
