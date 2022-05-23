package com.techelevator;

import java.util.Scanner;

public class DecimalToBinary {

	public static void main(String[] args) {

		//Receive user input
		Scanner scanner = new Scanner(System.in);

		//Prompt the user to input a series of decimals
		System.out.println("Please enter the decimal values separated by a space: ");
		String decimalInput = scanner.nextLine();
		String[] decimals = decimalInput.split(" ");

		//Convert to binary
		for (int i = 0; i < decimals.length; i++) {
			int decimalsToBinary = Integer.parseInt(decimals[i]);
			String binary = Integer.toBinaryString(decimalsToBinary);
			System.out.println(decimalsToBinary + " in binary is " + binary);
		}
	}
}