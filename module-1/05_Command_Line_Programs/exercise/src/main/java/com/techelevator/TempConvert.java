package com.techelevator;

import java.util.Scanner;

public class TempConvert {

	public static void main(String[] args) {

		//Receive user input
		Scanner scanner = new Scanner(System.in);

		//Prompt the user to input a temperature
		System.out.println("Please enter the temperature: ");
		String tempInput = scanner.nextLine();
		double temp = Double.parseDouble(tempInput);

		//Prompt the user to indicate Celsius or Fahrenheit
		System.out.println("Is the temperature in Celsius (C) or Fahrenheit (F)?");
		String degreeType = scanner.nextLine();

		//Determine which type, then apply appropriate formula
		if (degreeType.equalsIgnoreCase("C")) {
			double fahrenheit = (temp * 1.8) + 32;
			System.out.println(tempInput + degreeType + " is " + fahrenheit + "F.");
		} else if (degreeType.equalsIgnoreCase("F")) {
			double celsius = (temp - 32) / 1.8;
			System.out.println(tempInput + degreeType + " is " + celsius + "C.");
		} else {
			System.out.println("Please enter a valid degree type.");
		}
	}
}
