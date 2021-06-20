package ex42;

/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Ashley Mojica
 */

/*
Exercise 42 - Parsing a Data File
Sometimes data comes in as a structured format that you have to break down and turn into records
so you can process them. CSV, or comma-separated values, is a common standard for doing this.

Construct a program that reads in the following data file (you will need to create this data file
yourself; name it `exercise42_input.txt`):
Ling,Mai,55900
Johnson,Jim,56500
Jones,Aaron,46000
Jones,Chris,34500
Swift,Geoffrey,14200
Xiong,Fong,65000
Zarnecki,Sabrina,51500

Process the records and display the results formatted as a table, evenly spaced, as shown in the
example output.

Example Output:
Last      First     Salary
--------------------------
Ling      Mai       55900
Johnson   Jim       56500
Jones     Aaron     46000
Jones     Chris     34500
Swift     Geoffrey  14200
Xiong     Fong      65000
Zarnecki  Sabrina   51500

Constraints:
Write your own code to parse the data. Don't use a CSV parser.

Challenges:
Make each column one space longer than the longest value in the column.
Format the salary as currency with dollar signs and commas.
Sort the results by salary from highest to lowest.
Rework your program to use a CSV parsing library and compare the results.
 */


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        App myApp = new App();
        //initialize file that will be scanned
        File inText = new File("src/main/java/ex42/exercise42_input.txt");
        //initalize array list and call method to fill the list
        ArrayList<Person> database = myApp.readInput(inText);
        //initialize string variable and call method to format info into string
        String message = myApp.formatInformation(database);
        //print string
        System.out.print(message);
    }

    //static method that returns an array of people that reads text for a given file
    public ArrayList<Person> readInput(File inText){
        ArrayList<Person> database = new ArrayList<Person>();

        try {
            Scanner input = new Scanner(inText);
            while (input.hasNextLine()) {
                //read info and store in String variable
                String data = input.next();
                //insert Person object with data into array
                database.add(createPerson(data));
            }
            input.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return database;
    }

    //method that returns a Person object that is filled with information from a given string
    public Person createPerson(String data){
        //split info in string into an array where each of the commas are
        String[] dataList = data.split(",");
        //convert salary string into an int variable
        int salary = Integer.parseInt(dataList[2]);
        //create object with information and return the object
        Person myPerson = new Person(dataList[1], dataList[0], salary);
        return myPerson;
    }

    //method that formats the information given from a Person ArrayList into a String that will be printed
    public String formatInformation(ArrayList<Person> database){
        //initialize String message with the headers
        String message = "Last      First    Salary\n" + "--------------------------\n";
        //for loop that iterates for each element of the arraylist (0 to array list size)
        for(int i = 0; i < database.size(); i++){
            //get all elements of each object
            String first = database.get(i).getFirstName();
            String last = database.get(i).getLastName();
            int salary = database.get(i).getSalary();
            //add last name to message
            message += last;
            //if the name is less than the space in the table add the appropriate amount of spaces
            if (last.length() < 10){
                for (int j = last.length(); j < 11; j++)
                    message += " ";
            }
            //add first name to message
            message += first;
            //if the name is less than the space in the table add the appropriate amount of spaces
            if (first.length() < 9){
                for (int j = first.length(); j < 10; j++)
                    message += " ";
            }
            //add salary to message
            message += salary + "\n";

        }
        //once loop completes return message
        return message;
    }
}
