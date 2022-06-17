package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Boolean.parseBoolean;

public class Module1CodingAssessment {

	public static void main(String[] args) {

		//Object for testing
		Car car = new Car(2018, "Honda Civic", false);

		System.out.println("The year is: " + car.getYear());
		System.out.println("The make of the car is: " + car.getMake());
		System.out.println("Is the car a classic: " + car.isClassicCar());

		System.out.println(car);

		//Get cars from provided list via input
		List<Car> carList = new ArrayList<>();
		File carFile = new File("C:\\Users\\Student\\workspace\\abigail-newman-student-code\\module-1-assessment\\exercise\\data-files\\CarInput.csv");

		try(Scanner fileScan = new Scanner(carFile)) {

			while (fileScan.hasNextLine()) {
				String currentLine = fileScan.nextLine();
				String[] carVariables = currentLine.split(",");
				int year = (int) Double.parseDouble(carVariables[0]);
				String make = carVariables[1];
				boolean isClassicCar = Boolean.parseBoolean(carVariables[2]);

				carList.add(new Car(year, make, isClassicCar));
			}
		} catch (FileNotFoundException ex) {
			System.out.println("File not found.");
		} catch (Exception ex) {
			System.out.println("Something went wrong.");
		}

		int totalCarAge = 0;
		for(Car carConglomerate : carList) {
			totalCarAge += carConglomerate.getAge();
		}

		System.out.println("Total car age: " + totalCarAge);



		/* How to retrieve the current year
		int currentYear = LocalDateTime.now().getYear();
		System.out.println(currentYear);
		*/
	}

}
