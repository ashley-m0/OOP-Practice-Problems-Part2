package ex41Test;

import ex41.Person;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import static ex41.App.formatInformation;
import static ex41.App.sortNames;
import static org.junit.jupiter.api.Assertions.*;

public class AppTest
{
    @Test
    void sortsEmployeeCorrectly() {
        ArrayList<Person> testDatabase = new ArrayList<Person>();
        testDatabase.add(new Person("Mai", "Ling,"));
        testDatabase.add(new Person("Jim", "Johnson,"));
        testDatabase.add(new Person( "Sabrina", "Zarnecki,"));
        testDatabase.add(new Person("Chris","Jones,"));
        testDatabase.add(new Person("Aaron","Jones,"));
        testDatabase.add(new Person( "Geoffrey","Swift,"));
        testDatabase.add(new Person("Fong", "Xiong,"));

        testDatabase = sortNames(testDatabase);
        String actualMessage = formatInformation(testDatabase);
        String expectedMessage = "Total of 7 names\n" + "-----------------\n" + "Johnson, Jim\n" + "Jones, Aaron\n" +
                "Jones, Chris\n" + "Ling, Mai\n" + "Swift, Geoffrey\n" + "Xiong, Fong\n" + "Zarnecki, Sabrina";

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void checkIfInfoIsFormatedCorrectly() {
        ArrayList<Person> testDatabase = new ArrayList<Person>();
        testDatabase.add(new Person("Mai", "Ling,"));
        testDatabase.add(new Person("Jim", "Johnson,"));
        testDatabase.add(new Person( "Sabrina", "Zarnecki,"));
        testDatabase.add(new Person("Chris","Jones,"));
        testDatabase.add(new Person("Aaron","Jones,"));
        testDatabase.add(new Person( "Geoffrey","Swift,"));
        testDatabase.add(new Person("Fong", "Xiong,"));

        String actualMessage = formatInformation(testDatabase);
        String expectedMessage = "Total of 7 names\n" + "-----------------\n" + "Ling, Mai\n" + "Johnson, Jim\n" + "Zarnecki, Sabrina\n" + "Jones, Chris\n" + "Jones, Aaron\n" + "Swift, Geoffrey\n" + "Xiong, Fong";

        assertEquals(expectedMessage, actualMessage);
    }
}