package ex43;

/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Ashley Mojica
 */

/*
Exercise 43 - Website Generator
Programming languages can create files and folders too.

Create a program that generates a website skeleton with the following specifications:

Prompt for the name of the site.
Prompt for the author of the site.
Ask if the user wants a folder for JavaScript files.
Ask if the user wants a folder for CSS files.
Generate an index.html file that contains the name of the site inside the <title> tag and the
author in a <meta> tag.

Example Output:
Site name: awesomeco
Author: Max Power
Do you want a folder for JavaScript? y
Do you want a folder for CSS? y
Created ./website/awesomeco
Created ./website/awesomeco/index.html
Created ./website/awesomeco/js/
Created ./website/awesomeco/css/
The user should then find these files and directories created in the working directory of your program.

Challenges:
Implement this in a scripting language on Windows, OSX, and Linux.
Implement this as a web application that provides the specified site as a zip file.
 */

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class App {

    public static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        //Initialize App object
        App myApp = new App();
        //Initialize a Site object and call getUserInput method to fill Site
        Site mySite = myApp.getUserInput();
        //Initialize a file and call the createFiles method to fill
        File myFile = myApp.createFile(mySite);
        //Initialize the output message and call the createMessage method to fill
    }

    //public method that gets user input on what files to create
    public Site getUserInput(){
        //prompt user for site name and scan
        System.out.print("Site name: ");
        String sitename = input.nextLine();
        //prompt user for author name and scan
        System.out.print("Author: ");
        String author = input.nextLine();
        //prompt user for javascript and scan
        System.out.print("Do you want a folder for JavaScript? ");
        String javaString = input.nextLine();
        //turn string into a boolean variable
        boolean javascript = Boolean.parseBoolean(javaString);
        //prompt user for css and scan
        System.out.print("Do you want a folder for CSS? ");
        String cssString = input.nextLine();
        //turn string into a boolean variable
        boolean css = Boolean.parseBoolean(cssString);

        //initalize site object with all of user input
        Site mySite = new Site(sitename, author, javascript, css);
        return mySite;
    }

    //public method that creates files according to user input
    public File createFile(Site mySite){
        String fileDirectory = "C:\\Users\\mashl\\IdeaProjects\\test\\untitled\\mojica-cop3330-ex23\\mojica-cop3330-assignment3\\src\\main\\java\\ex43\\website\\";
        String path = fileDirectory.concat(mySite.getSiteName());
        path = fileDirectory.concat("\\index.html");
        File myFile = new File(path);
        try {
            if (myFile.createNewFile()) {
                System.out.println("File created: " + myFile.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return myFile;
    }




}
