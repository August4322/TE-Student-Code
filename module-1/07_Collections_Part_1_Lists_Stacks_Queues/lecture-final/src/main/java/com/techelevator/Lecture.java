package com.techelevator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Lecture {

	public static void main(String[] args) {
		System.out.println("####################");
		System.out.println("       LISTS");
		System.out.println("####################");

		List<String> avengers = new ArrayList<>();
		avengers.add("Thor");
		avengers.add("Black Widow");
		avengers.add("Scarlet Witch");
		avengers.add("Black Widow");
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

		avengers.add(0, "Iron Man");
		avengers.add(2, "Captain America");
		for(String avenger : avengers) {
			System.out.println(avenger);
		}


		System.out.println("####################");
		System.out.println("Lists allow elements to be removed by index");
		System.out.println("####################");

		avengers.remove(avengers.size() - 1);
		for(String avenger : avengers) {
			System.out.println(avenger);
		}


		System.out.println("####################");
		System.out.println("Find out if something is already in the List");
		System.out.println("####################");

		if( avengers.contains("Hawkeye")) {
			System.out.println("We found Hawkeye!");
		} else {
			System.out.println("Hawkeye is not here");
		}



		System.out.println("####################");
		System.out.println("Find index of item in List");
		System.out.println("####################");

		System.out.println("Black Widow is at index: " + avengers.indexOf("Black Widow"));
		System.out.println("Black Widow is at last index: " + avengers.lastIndexOf("Black Widow"));

		System.out.println("####################");
		System.out.println("Lists can be turned into an array");
		System.out.println("####################");

		// long way
		String[] avengersArray = new String[avengers.size()];
		for(int index =0; index < avengers.size(); index++) {
			avengersArray[index] = avengers.get(index);
		}

		// short way
		String[] avengersArray2 = new String[avengers.size()];
		avengersArray2 = avengers.toArray(avengersArray2);

		System.out.println("####################");
		System.out.println("Arrays can be turned into a list");
		System.out.println("####################");

		List<String> avengers2 = Arrays.asList(avengersArray);

		System.out.println("####################");
		System.out.println("Lists can be sorted");
		System.out.println("####################");

		Collections.sort(avengers);
		for(String avenger : avengers) {
			System.out.println(avenger);
		}

		System.out.println("####################");
		System.out.println("Lists can be reversed too");
		System.out.println("####################");

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
