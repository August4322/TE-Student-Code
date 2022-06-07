package com.techelevator;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Lecture {

	public static void main(String[] args) throws IOException {

		Scanner userInput = new Scanner(System.in);

		/*
		 * The java.io.File class is a representation of file and directory path names.  It provides methods to inspect and
		 * modify file system objects.
		 *
		 * One benefit is that it compensates for differences in Windows and Unix use of '/' and '\' as directory delimiters.
		 *
		 * A new instance of File can be created from a String that contains a file system path
		 */


		// To create a new directory: give it the path that you want it to exist at
		System.out.println("Please enter the directory path that you want to create a new folder at");
		String directoryPath = userInput.nextLine();
		File newDirectory = new File(directoryPath);

		//File comes with built in methods that are really useful, for instance exists()
		if(!newDirectory.exists()) {
			newDirectory.mkdir();
		} else {
			System.out.println("Directory already exists");
		}


		// To create a new file, give it the path with the filename included at the end, and then .createNewFile()
		String filePath = directoryPath + "\\orange.txt";
		File orangeFile = new File(filePath);
		if(!orangeFile.exists()) {
			orangeFile.createNewFile();
		} else {
			System.out.println("File already exists");
		}

		// If we want to write to a file, overwriting everything that's already there
		try(PrintWriter writer = new PrintWriter(orangeFile)) {

			writer.println("Christopher");
			writer.println("Anthony");
			writer.println("Ashley");

		} catch(Exception ex) {
			System.out.println("Unable to write to file");
		}

		// If we want to write to a file to append to it without overwriting
		try(PrintWriter writer = new PrintWriter(new FileOutputStream(orangeFile, true))) {

			writer.println("Caitlin");
			writer.println("Dane");
			writer.println("Abigail");
			writer.print("Beginning of line"); // .print does not create a new line but keeps it on the same line
			writer.print(" | End of line");

		} catch(Exception ex) {
			System.out.println("Unable to write to file");
		}

	}

}
