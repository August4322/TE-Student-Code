package com.techelevator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Lecture {

	public static void main(String[] args) {

		//Autoboxing and Unboxing
		List<Integer> myNumbers = new ArrayList<>(); //Automatically converts from primitive --> object
		myNumbers.add(5);
		myNumbers.add(99);

		int myNum = myNumbers.get(0); //and vice versa

		//Filter based on condition
		int[] numbers = {99, 90, 80, 70, 10, 2, 92, 66};
		List<Integer> numbersOver90 = new ArrayList<>();

		for(int num : numbers) {
			if (num >= 90) {
				numbersOver90.add(num);
				System.out.println("Found number " + num);
			} else {
				System.out.println("Ignoring number " + num);
			}
		}

		//Use it to exclude "Greg" from list
		String[] names = {"Christopher", "Andy", "Greg", "August", "Adam"};

		List<String> newNames = new ArrayList<String>();

		for(String name : names) {
			if (!name.equalsIgnoreCase("greg")) {
				newNames.add(name);
			}
		} System.out.println("List of names: " + newNames);


		System.out.println("####################");
		System.out.println("       LISTS");
		System.out.println("####################");

		List<String> avengers = new ArrayList<>();
		avengers.add("Iron Man");
		avengers.add("Black Widow");
		avengers.add("Captain America");
		avengers.add("Hawkeye");
		avengers.add("Hulk");

		System.out.println("####################");
		System.out.println("Lists are ordered");
		System.out.println("####################");

		for(String avenger : avengers) {
			System.out.println(avenger);
		}

		System.out.println("####################");
		System.out.println("Lists allow duplicates");
		System.out.println("####################");

		avengers.add("Hulk");

		for(String avenger : avengers) {
			System.out.println(avenger);
		}

		System.out.println("####################");
		System.out.println("Lists allow elements to be inserted in the middle");
		System.out.println("####################");

		avengers.add(0, "Spider-man");
		avengers.add(2, "Scarlet Witch");

		for(String avenger : avengers) {
			System.out.println(avenger);
		}

		System.out.println("####################");
		System.out.println("Lists allow elements to be removed by index");
		System.out.println("####################");

		avengers.remove(avengers.size() -1);

		for(String avenger : avengers) {
			System.out.println(avenger);
		}

		System.out.println("####################");
		System.out.println("Find out if something is already in the List");
		System.out.println("####################");

		if(avengers.contains("Quicksilver")) {
			System.out.println("We found Quicksilver!");
		} else {
			System.out.println("Quicksilver is no longer with us");
		}

		System.out.println("####################");
		System.out.println("Find index of item in List");
		System.out.println("####################");

		System.out.println("Black Widow is at index: " + avengers.indexOf("Black Widow"));

		System.out.println("####################");
		System.out.println("Lists can be turned into an array");
		System.out.println("####################");

		String[] avengersArray = new String[avengers.size()];

		//Long way
		for(int index = 0; index < avengers.size(); index ++) {
			avengersArray[index] = avengers.get(index);
		}

		//Short way
		String[] avengersArray2 = new String[avengers.size()];
		avengersArray2 = avengers.toArray(avengersArray2);

		System.out.println("####################");
		System.out.println("Arrays can be turned into lists");
		System.out.println("####################");

		List<String> avengers2 = Arrays.asList(avengersArray);

		System.out.println("####################");
		System.out.println("Lists can be sorted");
		System.out.println("####################");

		//Alphabetical
		Collections.sort(avengers);
		for(String avenger : avengers) {
			System.out.println(avenger);
		}

		System.out.println("####################");
		System.out.println("Lists can be reversed too");
		System.out.println("####################");

		//Reverse alphabetical
		Collections.reverse(avengers);
		for(String avenger : avengers) {
			System.out.println(avenger);
		}

		System.out.println("####################");
		System.out.println("       FOREACH");
		System.out.println("####################");
		System.out.println();

		for(String avenger : avengers) {
			System.out.println(avenger);
		}
	}
}
