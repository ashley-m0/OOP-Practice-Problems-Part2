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
import java.util.ArrayList;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        File inText = new File("src/main/java/ex41/exercise41_input.txt");
        File outText = new File("src/main/java/ex41/exercise41_output.txt");

        //initalize and fill new ArrayList with info from inText
        ArrayList<Person> database = new ArrayList<Person>();
        database = readInput(inText);
        //sort list
        database = sortNames(database);
        //print info to outText
        String message = formatInformation(database);
        printInformation(outText, message);
    }


    //static method that returns an array of people that reads text for a given file
    public static ArrayList<Person> readInput(File inText){
        ArrayList<Person> database = new ArrayList<Person>();

        try {
            Scanner input = new Scanner(inText);
            while (input.hasNextLine()) {
                //read last name and store in String variable
                String last = input.next();
                //read the first name and store in String variable
                String first = input.next();
                //create a Person object and store first and last name
                Person myPerson = new Person(first, last);
                //insert Person object into array at the index of the size of the database array
                database.add(database.size(), myPerson);
            }
            input.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return database;
    }

    //static ArrayList<Person> method that takes in an unsorted list and returns a sorted list based on the last names
    public static ArrayList<Person> sortNames(ArrayList<Person> database) {
        //initialize temporary ArrayList<Person> variable that will hole the new sorted list
        ArrayList<Person> newList = new ArrayList<Person>();
        //initialize a variable that will keep track of the current person with the next highest lastname
        int alphaIndex;
        //initialize a variable that keeps track of how long the original list was
        int length = database.size();
        //for loop from 0 to the length of the original list
        for (int i = 0; i < length; i++) {
            //reset the index of the person with the highest lastname back to 0 each time loop iterates
            alphaIndex = 0;
            //nested for loop from 1 to the current size of the original ArrayList
            for (int j = 1; j < database.size(); j++) {
                //if an element of the list has a higher last name than the current element at the alphaindex, update alphaindex
                if (database.get(j).getLastName().compareTo(database.get(alphaIndex).getLastName()) < 0) {
                    alphaIndex = j;
                } else if(database.get(j).getLastName().compareTo(database.get(alphaIndex).getLastName()) == 0){
                    if(database.get(j).getFirstName().compareTo(database.get(alphaIndex).getFirstName()) < 0){
                        alphaIndex = j;
                    }
                }
            }
            //once element with highest last name is found add the element to the new list and delete the element from the old list
            newList.add(i, database.get(alphaIndex));
            database.remove(alphaIndex);
        }
        //return newList of alphabetized elements
        return newList;
    }

    //static String method that formats the information from the ArrayList to be read to be printed to the outfile
    public static String formatInformation (ArrayList<Person> database){

        //initialize message string that will be returned
        String message;
        //print total number of names from file into outText
        message = "Total of " + database.size() + " names";
        //add separation line
        message +="\n-----------------";
        //for loop that runs from 0 to the number of the counter
        for (int i = 0; i < database.size(); i++) {
            //get first and last name
            String first = database.get(i).getFirstName();
            String last = database.get(i).getLastName();
            //print lastname and first name to outText
            message += "\n" + last + " " + first;
        }
        //return message
        return message;
    }

    //static void method that prints all information given from the inText file to the outText file
    public static void printInformation(File outText, String message){
        try {
            FileWriter myWriter = new FileWriter(outText);
            myWriter.write(message);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
