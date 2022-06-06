package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;

public class WordSearch {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		System.out.println("Please input a viable file path:");
		String fileInput = input.nextLine();
		File aliceInWonderLand = new File(fileInput);

		System.out.println("Please input a search term:");
		String wordInput = input.nextLine();

		System.out.println("Should the search term by case sensitive? (Y/N)");
		String caseSensitivityCheck = input.nextLine();

		int lineWordAppearsOn = 1;

		try (Scanner wonderLandReader = new Scanner(aliceInWonderLand)) {
			while (wonderLandReader.hasNextLine()) {
				String currentLine = wonderLandReader.nextLine();

				if (caseSensitivityCheck.equals("N") && currentLine.toLowerCase().contains(wordInput.toLowerCase())) {
					System.out.println(lineWordAppearsOn + " - " + currentLine);

				} else if (caseSensitivityCheck.equals("Y") && currentLine.contains(wordInput)) {
					System.out.println(lineWordAppearsOn + " - " + currentLine);
				} lineWordAppearsOn ++;
			}
		} catch (FileNotFoundException ex) {
			System.out.println("File was not found, check the path");
		} catch(Exception ex) {
			System.out.println("Something went wrong");
		}
	}
}
