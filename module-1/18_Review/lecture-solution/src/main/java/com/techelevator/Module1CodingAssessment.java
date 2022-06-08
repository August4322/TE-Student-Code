package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Module1CodingAssessment {

	public static void main(String[] args) {

		/*
		System.out.println("Please select which format (enter number):");
		System.out.println("1. VHS");
		System.out.println("2. DVD");
		System.out.println("3. Blu Ray");

		if(input.equals("1")) {
			format = MovieRental.VHS
		} */


		MovieRental movie = new MovieRental("Morbius", MovieRental.BLURAY, true);
		System.out.println(movie.getTitle());
		System.out.println(movie.getFormat());
		System.out.println(movie.isPremium());
		System.out.println(movie.getRentalPrice());

		System.out.println(movie);

		List<MovieRental> movies = new ArrayList<>();
		try(Scanner fileReader = new Scanner(new File("C:\\Users\\Student\\instructor_repos\\instructor-code\\module-1\\18_Review\\lecture-solution\\data-files\\MovieInput.csv"))){
			while(fileReader.hasNextLine()) {
				String currentLine = fileReader.nextLine();
				String[] movieDetails = currentLine.split(",");
				String title = movieDetails[0];
				String format = movieDetails[1];
				boolean premium = Boolean.parseBoolean(movieDetails[2]);
				movies.add(new MovieRental(title, format, premium));
			}
		} catch (FileNotFoundException e) {
			System.out.println("Unable to find file");
		}

		BigDecimal sum = new BigDecimal("0");
		for(MovieRental newMovie : movies) {
			sum = sum.add(newMovie.getRentalPrice());
		}

		System.out.println("Total sum of rentals:" + sum);
	}

}
