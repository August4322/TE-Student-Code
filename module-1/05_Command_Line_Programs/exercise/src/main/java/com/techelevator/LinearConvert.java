package com.techelevator;

import java.util.Scanner;

public class LinearConvert {

	public static void main(String[] args) {

		//Receive user input
		Scanner scanner = new Scanner(System.in);

		//Prompt the user to input a length
		System.out.println("Please enter the length: ");
		String lengthInput = scanner.nextLine();
		double length = Double.parseDouble(lengthInput);

		//Prompt the user to indicate meters or feet
		System.out.println("Is the length in meters (m) or feet (f)?");
		String lengthType = scanner.nextLine();

		//Determine which type, then apply appropriate formula
		if (lengthType.equalsIgnoreCase("f")) {
			int feetToMeter = (int)(length * 0.3048);
			System.out.println(lengthInput + lengthType + " is " + feetToMeter + "m.");
		} else if (lengthType.equalsIgnoreCase("m")) {
			int meterToFeet = (int)(length * 3.2808399);
			System.out.println(lengthInput + lengthType + " is " + meterToFeet + "f.");
		} else {
			System.out.println("Please enter a valid degree type.");
		}

	}

}
