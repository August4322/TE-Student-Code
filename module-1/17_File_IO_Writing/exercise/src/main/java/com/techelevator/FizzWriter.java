package com.techelevator;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FizzWriter {

	public static void main(String[] args) {

		//Create a scanner and make sure it has the input functionality (system.in)
		Scanner userInput = new Scanner(System.in);

		//Prompt the user for input (asking for a destination file)
		System.out.println("Please enter the directory path that you want to create a new folder at:");
		String destinationFolder = userInput.nextLine();
		File destinationFile = new File(destinationFolder);

		//Initialize scanner to open file (try/catch) && Initialize PrintWriter to print to new file
		try(PrintWriter fileWriter = new PrintWriter(destinationFile)) {

			//Verify the file doesn't already exist
			if(!destinationFile.exists()) {
				destinationFile.createNewFile();
			}

			//Loop through file to see if the numbers are divisible by 3, 5, or 3 & 5
			int number = 1;

			while(number >= 1 && number <= 300) {
				if (!(number % 3 ==0 || number % 5 == 0)) {
					fileWriter.println(number);
				} else if (number % 3 == 0 && !(number % 5 == 0)) {
					fileWriter.println("Fizz");
				} else if (number % 5 == 0 && !(number % 3 == 0)) {
					fileWriter.println("Buzz");
				} else if (number % 5 == 0 && (number % 3 == 0)) {
					fileWriter.println("FizzBuzz");
				} number ++;
			}
		} catch (IOException ex) {
			System.out.println("Could not create file");
		} catch (Exception ex) {
			System.out.println("Something went wrong");
		}


	}

}
