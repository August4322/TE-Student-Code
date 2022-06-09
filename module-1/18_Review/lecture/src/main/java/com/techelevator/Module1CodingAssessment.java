package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Module1CodingAssessment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Instant Variables
		MovieRental jaws = new MovieRental("Jaws", MovieRental.VHS, false);
		MovieRental spidermanIntoTheSpiderVerse = new MovieRental("Spider-Man: Into the Spider-Verse", MovieRental.BLURAY, true);

		//Print out the movies
		System.out.println(jaws);
		System.out.println(spidermanIntoTheSpiderVerse);

		//Initialize scanner to open file (try/catch)
		List<MovieRental> movies = new ArrayList<>();

		try(Scanner fileScanner = new Scanner(new File("C:\\Users\\Student\\workspace\\abigail-newman-student-code\\module-1\\18_Review\\lecture\\data-files\\MovieInput.csv"))) {

			//Loop through file
			while(fileScanner.hasNextLine()) {
				String currentLine = fileScanner.nextLine();
				String[] movieDetails = currentLine.split(",");
				String title = movieDetails[0];
				String format = movieDetails[1];
				boolean premium = Boolean.parseBoolean(movieDetails[2]);
				movies.add(new MovieRental(title, format, premium));
			}

		} catch(FileNotFoundException ex) {
			System.out.println("File does not exist");
		} catch (Exception ex) {
			System.out.println("Something went wrong");
		}

	}

}
