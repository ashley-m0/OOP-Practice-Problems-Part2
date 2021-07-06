package ex45;

/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Ashley Mojica
 */

/*
Exercise 45 - Word Finder
There will be times when you'll need to read in one file, modify it, and then write a modified
version of that file to a new file.

Given an input file named `exercise45_input.txt`, read the file and look for all occurrences of the
word utilize. Replace each occurrence with use. Write the modified file to a new file.

Example Output:
Given the input file of:
One should never utilize the word "utilize" in writing. Use "use" instead.
For example, "She uses an IDE to write her Java programs" instead of "She
utilizes an IDE to write her Java programs".
The program should generate:
One should never use the word "use" in writing. Use "use" instead.
For example, "She uses an IDE to write her Java programs" instead of "She
uses an IDE to write her Java programs".

Constraints:
Prompt for the name of the output file.
Write the output to a new file.

Challenges:
Modify the program to track the number of replacements and report that to the screen when the program
finishes.
Create a configuration file that maps “bad” words to “good” words and use this file instead of a hard-
coded value.
Modify the program so it can handle every file a folder of files instead of a single file.
 */

import ex41.Person;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class App {
    public static Scanner input = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        App myApp = new App();
        WordFinder myWordFinder = new WordFinder("utilize", "use");
        System.out.print("Enter name of output file: ");
        String outTextString = input.nextLine();
        File outText = new File(outTextString);
        File inText = new File("src/main/java/ex45/exercise45_input.txt");
        String message = myApp.changeFile(inText, myWordFinder);
        FileWriter myWriter = new FileWriter(outText);
        myWriter.write(message);
        myWriter.close();
    }

    public String changeFile(File inText, WordFinder myWordFinder){
        String message= "";
        try {
            Scanner inputFile = new Scanner(inText);
            while (inputFile.hasNext()) {
                String scannedWord = inputFile.next();
                String searchWord = myWordFinder.getSearchWord();
                String[] words= null;
                words = scannedWord.split(" ");  //Split the word using space
                for (String word : words)
                {
                    if (word.equals(searchWord))   //Search for the given word
                    {
                        message += myWordFinder.getChangeWord();   //If Present increase the count by one
                    }else{
                        message += scannedWord;
                    }
                }
                message += " ";
            }
            inputFile.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return message;
    }

}
