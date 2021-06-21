package ex46Test;

import ex46.App;
import ex46.WordDetector;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

public class AppTest {

    @Test
    public void fixesOrderCorrectly(){
        App myApp = new App();
        ArrayList<WordDetector> expectedDetector = new ArrayList<WordDetector>();
        expectedDetector.add(new WordDetector("mushroom", 7));
        expectedDetector.add(new WordDetector("snake", 7));
        expectedDetector.add(new WordDetector("badger", 7));

        ArrayList<WordDetector> actualDetector = new ArrayList<WordDetector>();
        actualDetector.add(new WordDetector("badger", 5));
        actualDetector.add(new WordDetector("mushroom", 7));
        actualDetector.add(new WordDetector("snake", 6));

        actualDetector = myApp.fixOrder(actualDetector);

        assertEquals(expectedDetector.get(0).getWord(), actualDetector.get(0).getWord());
        assertEquals(expectedDetector.get(1).getWord(), actualDetector.get(1).getWord());
        assertEquals(expectedDetector.get(2).getWord(), actualDetector.get(2).getWord());
    }

    @Test
    public void formatsInformationCorrectlyIntoFrequencyChart(){
        App myApp = new App();
        ArrayList<WordDetector> myDetector = new ArrayList<WordDetector>();
        myDetector.add(new WordDetector("badger", 7));
        myDetector.add(new WordDetector("mushroom", 2));
        myDetector.add(new WordDetector("snake", 1));

        String actualMessage = myApp.formatMessage(myDetector);
        String expectedMessage = "badger: *******\n" + "mushroom: **\n" +
                "snake: *\n";

        assertEquals(expectedMessage, actualMessage);
    }
}
