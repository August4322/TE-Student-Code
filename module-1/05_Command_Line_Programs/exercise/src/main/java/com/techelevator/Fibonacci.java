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
		int fibSeq1 = 0;
		int fibSeq2 = 1;

		System.out.println("Fibonacci sequence up to " + number + ":");

		if (number <= 0) {
			System.out.println("0, 1");
		} else if (number == 1) {
			System.out.println("0, 1, 1"); }

		//Print Fibonacci Sequence up (and/or including) to number
		for (int i = 0; i <= number; i++) {
			if (fibSeq1 <= number) {
				System.out.print(fibSeq1 + ", ");

				int fibSeqCont = fibSeq1 + fibSeq2;
				fibSeq1 = fibSeq2;
				fibSeq2 = fibSeqCont;

			}
		}
	}
}

