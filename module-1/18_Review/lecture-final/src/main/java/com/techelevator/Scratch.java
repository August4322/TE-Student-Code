package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Scratch {
    public static void main(String[] args) {

        /*Scanner userInput = new Scanner(System.in);

        System.out.println("Please enter a directory where you want your files:");
        String directory = userInput.nextLine();

        System.out.println("PLease space separated file names");
        String fileNames = userInput.nextLine();

        String[] files = fileNames.split(" ");
        for(String fileName : files) {

            // check if the directory exists and create it if not
            File folder = new File(directory);
            if(!folder.exists()) {
                folder.mkdir();
            }

            File file = new File(directory + "\\" + fileName);
            if(!file.exists()) {
                try(PrintWriter writer = new PrintWriter(file)) {
                    file.createNewFile();
                    writer.println("Hello World!");

                }
                catch(IOException ex) {
                    System.out.println("Error trying to create file");
                }
            }
        }
*/
        File batmanFile = new File("C:\\Users\\Student\\instructor_repos\\instructor-code\\module-1\\18_Review\\lecture-final\\scratch\\batman.txt");
        try(Scanner fileScanner = new Scanner(batmanFile)){

            List<String> fileLines = new ArrayList<String>();
            while(fileScanner.hasNextLine()) {
                fileLines.add( fileScanner.nextLine() );

            }

            System.out.println(fileLines.size());

        }catch(FileNotFoundException ex) {

        }

    }
}
