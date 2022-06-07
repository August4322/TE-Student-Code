package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FindAndReplace {

    public static void main(String[] args) {

        //Create a scanner and make sure it has the input functionality (system.in)
        Scanner userInput = new Scanner(System.in);

        //Prompt the user for input (asking for search word)
        System.out.println("Please enter the search word:");
        String searchWord = userInput.nextLine();

        //Prompt the user for input (asking for replacement word)
        System.out.println("Please enter the replacement word:");
        String replacementWord = userInput.nextLine();

        //Prompt the user for input (asking for the source file)
        System.out.println("Please enter the directory path that you want to search:");
        String sourceFilePath = userInput.nextLine();

        //Verify the file exists
        File sourceFile = new File(sourceFilePath);
        if(!sourceFile.isFile()) {
            System.out.println("File does not exist");
           return;
        }

        //Prompt the user for input (asking for a destination file)
        System.out.println("Please enter the directory path that you want to create a new folder at:");
        String destinationFolder = userInput.nextLine();
        File destinationFile = new File(destinationFolder);

        //Initialize scanner to open file (try/catch) && Initialize PrintWriter to print to new file
        try(Scanner fileScanner = new Scanner(sourceFile);
            PrintWriter fileWriter = new PrintWriter(destinationFile)) {

            //Verify the file doesn't already exist
            if(!destinationFile.exists()) {
                destinationFile.createNewFile();
            } else {
                System.out.println("File already exists");
            }

            //Loop through file to see if the lines contain the search word (not case-insensitive)
            while(fileScanner.hasNextLine()) {
                String currentLine = fileScanner.nextLine();
                //Replace existing instances of search word with replacement word && Create a new file/directory
                fileWriter.println(currentLine.replaceAll(searchWord, replacementWord));
            }

        } catch(FileNotFoundException ex) {
            System.out.println("File does not exist");
        } catch (IOException ex) {
            System.out.println("Could not create file");
        } catch (Exception ex) {
            System.out.println("Something went wrong");
        }

    }

}
