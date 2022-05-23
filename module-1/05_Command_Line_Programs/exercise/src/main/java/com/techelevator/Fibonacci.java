package com.techelevator;

import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {

		//Receive user input
		Scanner scanner = new Scanner(System.in);

		//Prompt the user to input a number
		System.out.println("Please enter a number: ");
		String numberInput = scanner.nextLine();
		int number = Integer.parseInt(numberInput);

		//Establish 0 and 1
		int prevNum = 0;
		int currentNum = 1;
		int nextNum = prevNum + currentNum;

		System.out.println("Fibonacci sequence up to " + number + ":");

		//Print Fibonacci Sequence if number is 0, 1, or negative
		System.out.print(prevNum);

		//Print Fibonacci Sequence up to (or including) number
		while (nextNum <= number) {
			System.out.print(", " + currentNum);

			nextNum = prevNum + currentNum;
			prevNum = currentNum;
			currentNum = nextNum;

		}
	}
}


