package ex46;

/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Ashley Mojica
 */

/*
Exercise 46 - Word Frequency Finder
Knowing how often a word appears in a sentence or block of text is helpful for creating word
clouds and other types of word analysis. And it’s more useful when running it against lots of text.

Create a program that reads in a file named `exercise46_input.txt` and counts the frequency of words
in the file. Then construct a histogram displaying the words and the frequency, and display the
histogram to the screen.

Example Output:
Given the text file `exercise46_input.txt` with this content
badger badger badger
badger mushroom
mushroom snake badger badger
badger
the program would produce the following output:
badger:   *******
mushroom: **
snake:    *

Constraint:
Ensure that the most used word is at the top of the report and the least used words are at the bottom.

Challenges:
Use a graphical program and generate bar graphs.
Test the performance of your calculation by providing a very large input file, such as Shakespeare's
Macbeth. Tweak your algorithm so that it performs the word counting as fast as possible.
Write the program in another language and compare the processing times of the two implementations.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        //Initialize App object
        App myApp = new App();
        //Initialize input file
        File inText = new File("src/main/java/ex46/exercise46_input.txt");
        //Initialize ArrayList of WordDetectors
        ArrayList<WordDetector> myDetector = new ArrayList<WordDetector>();
        //Initialize each WordDetector object and add them to the ArrayList
        myDetector.add(new WordDetector("badger", 0));
        myDetector.add(new WordDetector("mushroom", 0));
        myDetector.add(new WordDetector("snake", 0));
        //Call the readFile method to read information from input file and put it in the ArrayList
        myDetector = myApp.readFile(inText, myDetector);
        //Call the formatMessage method to format the information into a frequency bar chart
        String message = myApp.formatMessage(myDetector);
        //Print message
        System.out.print(message);
    }

    //Public method that reads information from a file and updates the arraylist if one of the WordDetectors is found
    public ArrayList<WordDetector> readFile(File inText, ArrayList<WordDetector> myDetector){
        //Try and catch statement to see if file can be read
        try {
            //Declare a scanner for the file
            Scanner input = new Scanner(inText);
            //While loop statement that keeps iterating while there is still information in the file
            while (input.hasNext()) {
                //Declare string variable to put scanned in content into
                String scannedWord = input.next();
                //For loop to go through all of the WordDetectors (0 to ArrayList size)
                for(int i = 0; i < myDetector.size(); i++) {
                    //If scanned String equals a word in the ArrayList
                    if(scannedWord.equals(myDetector.get(i).getWord())) {
                        //Add to that word's count
                        myDetector.get(i).addToCount();
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //Return ArrayList
        return myDetector;
    }

    //Public method that formats the information from an ArrayList of WordDetectors and makes a frequency table
    public String formatMessage(ArrayList<WordDetector> myDetector){
        //Call the fixOrder method to put ArrayList in order from highest to lowest count
        myDetector = fixOrder(myDetector);
        //Initialize message String to ""
        String message = "";
        //For loop that iterates from 0 to the size of the ArrayList
        for(int i = 0; i < myDetector.size(); i++) {
            //Get the WordDetector's word and add it to the message
            message += myDetector.get(i).getWord() + ": ";
            //For loop from 0 to the WordDetector's count
            for(int j = 0; j < myDetector.get(i).getCount(); j++) {
                //Add a "*" to the message
                message += "*";
            }
            message += "\n";
        }
        //Return message
        return message;
    }

    //Public method that puts the WordDectors in an ArrayList in order from highest to lowest count
    public ArrayList<WordDetector> fixOrder(ArrayList<WordDetector> myDetector){
        //Initialize a new ArrayList of WordDetectors
        ArrayList<WordDetector> newWordDetector = new ArrayList<WordDetector>();
        //Initialize an int variable that keeps track of the original size of the ArrayList
        int length = myDetector.size();
        //For loop from 0 to the original size of the ArrayList
        for(int i = 0; i < length; i++) {
            //Initalize the maxIndex to 0
            int maxIndex = 0;
            //Nested for loop from 0 to the current size of the ArrayList
            for(int j = 0; j < myDetector.size(); j++) {
                //If the count of an element of the ArrayList has a higher count than the element at the maxIndex
                if(myDetector.get(j).getCount() > myDetector.get(maxIndex).getCount()) {
                    //Update maxIndex
                    maxIndex = j;
                }
            }
            //Add the element at the maxIndex to the new ArrayList
            newWordDetector.add(myDetector.get(maxIndex));
            //Remove the element from the original ArrayList
            myDetector.remove(myDetector.get(maxIndex));
        }
        //Return new ArrayList
        return newWordDetector;
    }
}
