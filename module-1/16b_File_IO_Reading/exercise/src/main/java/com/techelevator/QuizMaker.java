package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class QuizMaker {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		System.out.println("Please input a viable file path for the quiz:");
		String fileInput = input.nextLine();
		File quiz = new File(fileInput);

		int quizQuestionLine = 1;

		try (Scanner quizReader = new Scanner(quiz)) {
			while (quizReader.hasNextLine()) {
				String currentLine = quizReader.nextLine();


				System.out.println(currentLine.substring(0, currentLine.indexOf("|")));
				System.out.println(currentLine.substring(currentLine.indexOf("|")));

			}
		} catch (FileNotFoundException ex) {
			System.out.println("File was not found, check the path");
		} catch(Exception ex) {
			System.out.println("Something went wrong");
		}

	}

}
