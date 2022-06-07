package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileSplitter {

	public static void main(String[] args) {

		//Create a scanner and make sure it has the input functionality (system.in)
		Scanner userInput = new Scanner(System.in);

		//Prompt the user for input (asking for the source file)
		System.out.println("Please enter the directory path that you want to search:");
		String sourceFilePath = userInput.nextLine();

		//Verify the file exists
		File sourceFile = new File(sourceFilePath);
		if(!sourceFile.isFile()) {
			System.out.println("File does not exist");
			return;
		}

		//Prompt the user for input (asking how many lines per destination file)
		System.out.println("Please enter the limit (max) of how many lines of text there should be in the split files:");
		int linesOfTextMax = Integer.parseInt(userInput.nextLine());

		//Figure out how many lines of text are in the source file
		int linesInSourceFile = 0;

		try(Scanner sourceFileScanner = new Scanner(sourceFile)) {
			while (sourceFileScanner.hasNextLine()) {
				String currentLine = sourceFileScanner.nextLine();
				linesInSourceFile ++;
			}
		} catch (FileNotFoundException ex) {
			System.out.println("File not found");
		} catch (Exception ex) {
			System.out.println("Something went wrong");
		}

		System.out.println("The source file has " + linesInSourceFile + " lines of text.");

		//Prompt the user for input (asking for a destination file)
		System.out.println("Please enter the directory path that you want to create a new folder at:");
		String destinationFolder = userInput.nextLine();
		File destinationFile = new File(destinationFolder);

		//Initialize scanner to open file (try/catch) && Initialize PrintWriter to print to new file
		try(Scanner fileScanner = new Scanner(sourceFile);
			PrintWriter fileWriter = new PrintWriter(destinationFile)) {

			int currentLineInSourceFile = 0;

			//Verify the file doesn't already exist
			if(!destinationFile.exists()) {
				destinationFile.createNewFile();
			}

			//Loop through file
			while(fileScanner.hasNextLine()) {
				String currentLine = fileScanner.nextLine();
				//Separate every "linesOfTextMax" lines of code into a new destination file
				fileWriter.println(currentLine.substring(currentLineInSourceFile, (currentLineInSourceFile + (linesOfTextMax + 1))));
				currentLineInSourceFile += linesOfTextMax;
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


