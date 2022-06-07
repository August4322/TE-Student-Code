package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Scratch {

    private Scanner consoleInput = new Scanner(System.in);

    public static void main(String[] args) {


        Scratch s = new Scratch();
        s.run();


    }

    public void run()  {


        // prompt the user for the file path

        // we need to create a file object from the path they give us
        // and open it to read

        // search through each line for the search term

        // print out the line and its line number when we find the search term



        System.out.println("Enter the path of the file you want to search:");
        String fileName = consoleInput.nextLine();

        File fileToSearch = new File(fileName);

        try(Scanner fileScanner = new Scanner(fileToSearch)) {

            int lineNumber = 1;
            while(fileScanner.hasNextLine()){
                String currentLine = fileScanner.nextLine();

                System.out.println(lineNumber + ": " + currentLine);

                //currentLine.toLowerCase().contains("cat");

                lineNumber++;
            }

        } catch(FileNotFoundException ex) {
            // log the exception here
            System.out.println("File provided does not exist");
        } catch(Exception ex) {
            System.out.println("Something went wrong");
        }

    }

}
