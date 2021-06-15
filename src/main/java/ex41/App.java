package ex41;

/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Ashley Mojica
 */

/*
Exercise 41 - Name Sorter
Alphabetizing the contents of a file, or sorting its contents, is a great way to get comfortable
manipulating a file in your program.

Create a program that reads in the following list of names from a file called `exercise41_input.txt`
and sorts the list alphabetically:
Ling, Mai
Johnson, Jim
Zarnecki, Sabrina
Jones, Chris
Jones, Aaron
Swift, Geoffrey
Xiong, Fong

Then print the sorted list to a file called `exercise41_output.txt` that looks like the following
example output.

Example Output:
Total of 7 names
-----------------
Johnson, Jim
Jones, Aaron
Jones, Chris
Ling, Mai
Swift, Geoffrey
Xiong, Fong
Zarnecki, Sabrina

Constraint:
Don't hard-code the number of names.

Challenges:
Implement this program by reading in the names from the user, one at a time, and printing out the
sorted results to a file.
Use the program to sort data from a large data set (e.g. census data) and use a profiler to analyze
its performance.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class App {


    public static int counter;
    public static void main(String[] args) {

        //open input file
        File inFile = new File("C:\\Users\\mashl\\IdeaProjects\\test\\untitled\\mojica-cop3330-ex23\\mojica-cop3330-assignment3\\src\\main\\java\\ex41\\exercise41_input.txt");
        //open output file
        File outFile = new File("exercise41_output.txt");

        //create an array of People for names to be stored in
        ArrayList<Person> database = new ArrayList<Person>();

        //call readInput method to populate arraylist
        database = readInput(inFile);
        //print the information in arraylist by calling printInformation method
        String message = printInformation(database);
        try {
            FileWriter myWriter = new FileWriter(outFile);
            myWriter.write(message);
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    //static method that returns an array of people that reads text for a given file
    public static ArrayList<Person> readInput(File inFile){
        Scanner input = null;
        //create an array of People for names to be stored in
        ArrayList<Person> database= new ArrayList<Person>();
        //counter set to 0 to track how many people are added
        counter = 0;

        try {
            input = new Scanner(Paths.get(inFile));
            //loop while there is still text in the txt file
            while (input.hasNextLine()) {

                //read the first name and store in String variable
                String first = input.nextLine();
                //read last name and store in String variable
                String last = input.nextLine();
                //create a Person object and store first and last name
                Person myPerson = new Person(first, last);
                //insert Person object into array at the index of the counter
                database.add(counter, myPerson);
                //increment counter
                counter++;
            }
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //return arraylist created
        return database;
    }

    //static String method that returns a String of all the information that needs to be printed to the outfile
    public static String printInformation (ArrayList<Person> database){
        //initalize string with  total number of names (counter + 1 because counter was initialized to 0)
        String message = "Total of " + (counter+1) + " names";
        //add separation line
        message += "\n-----------------";

        //for loop that runs from 0 to the number of the counter
        for (int i = 0; i < counter; i++){
            //get first and last name
            String first = database.get(i).getFirstName();
            String last = database.get(i).getLastName();
            //add names to message
            message += "\n" + first + ", " + last;

        }

        return message;
    }
}
