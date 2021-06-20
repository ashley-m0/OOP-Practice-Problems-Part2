package ex42;

public class Person{

    private String firstName;
    private String lastName;
    private int salary;

    public Person(String first, String last, int salary){
        this.firstName = first;
        this.lastName = last;
        this.salary = salary;
    }

    public String getFirstName(){
        return firstName;
    }

    public void setFirstName(String first){
        this.firstName = first;
    }

    public String getLastName(){
        return lastName;
    }

    public void setLastName(String last){
        this.lastName = last;
    }

    public int getSalary(){
        return salary;
    }

    public void setSalary(int sal){
        this.salary = sal;
    }
}
