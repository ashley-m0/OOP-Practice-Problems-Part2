package ex42Test;

import ex42.App;
import ex42.Person;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class AppTest
{
    @Test
    void createPersonCorrectly() {
        App myApp = new App();
        String information = "Mojica,Ashley,123456";
        Person actualPerson = myApp.createPerson(information);
        Person expectedPerson = new Person("Ashley", "Mojica", 123456);

        assertEquals(expectedPerson.getFirstName(), actualPerson.getFirstName());
        assertEquals(expectedPerson.getLastName(), actualPerson.getLastName());
        assertEquals(expectedPerson.getSalary(), actualPerson.getSalary());
    }

    @Test
    void formatsInformationCorrectly(){
        App myApp = new App();
        ArrayList<Person> database = new ArrayList<Person>();
        database.add(new Person("Mai", "Ling",55900));
        database.add(new Person("Jim", "Johnson", 56500));
        database.add(new Person("Sabrina", "Zarnecki", 51500));

        String actualMessage = myApp.formatInformation(database);
        String expectedMessage = "Last      First    Salary\n" + "--------------------------\n" + "Ling       Mai       55900\n" +
                "Johnson    Jim       56500\n" + "Zarnecki   Sabrina   51500\n";

        assertEquals(expectedMessage, actualMessage);
    }
}