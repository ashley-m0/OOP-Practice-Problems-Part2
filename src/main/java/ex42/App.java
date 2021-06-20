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
        File inText = new File("src/main/java/ex42/exercise42_input.txt");
        ArrayList<Person> database = myApp.readInput(inText);
        String message = myApp.formatInformation(database);
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

    public Person createPerson(String data){
        String[] dataList = data.split(",");
        int salary = Integer.parseInt(dataList[2]);
        Person myPerson = new Person(dataList[1], dataList[0], salary);
        return myPerson;
    }

    public String formatInformation(ArrayList<Person> database){
        String message = "Last      First    Salary\n" + "--------------------------\n";
        for(int i = 0; i < database.size(); i++){
            String first = database.get(i).getFirstName();
            String last = database.get(i).getLastName();
            int salary = database.get(i).getSalary();
            message += last;
            if (last.length() < 10){
                for (int j = last.length(); j < 11; j++)
                    message += " ";
            }
            message += first;
            if (first.length() < 9){
                for (int j = first.length(); j < 10; j++)
                    message += " ";
            }
            message += salary + "\n";

        }
        return message;
    }
}
