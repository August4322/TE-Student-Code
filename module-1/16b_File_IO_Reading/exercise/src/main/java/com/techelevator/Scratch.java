package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Scratch {
    public static void main(String[] args) {

        File aliceFile = new File("C:\\Users\\Student\\instructor_repos\\instructor-code\\module-1\\16b_File_IO_Reading\\exercise\\alices_adventures_in_wonderland.txt");
        try(Scanner fileScanner = new Scanner(aliceFile)){

            List<String> fileLines = new ArrayList<String>();
            while(fileScanner.hasNextLine()) {
                fileLines.add( fileScanner.nextLine() );

            }

            System.out.println(fileLines.size());

        }catch(FileNotFoundException ex) {

        }

    }
}
