package com.techelevator;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Lecture {

	public static void main(String[] args) {

		System.out.println("####################");
		System.out.println("        MAPS");
		System.out.println("####################");
		System.out.println();

		//Map<Datatype of key, Datatype of values>
		Map<String, String> orangeDictionary = new HashMap<>();
		orangeDictionary.put("Squiggly", "Curly Braces | As used for code blocks.");
		orangeDictionary.put("Squarie", "Square Brackets | As used with arrays.");
		orangeDictionary.put("Pointy", "Greater than & Less than | As used for specifying data types on lists and maps");

		//To retrieve a value: use .get
		System.out.println(orangeDictionary.get("Squarie"));

		//If we call for a value that doesn't exist:
		System.out.println(orangeDictionary.get("Squary"));	//returns null

		//If we want only the keys
		for (String key : orangeDictionary.keySet()) {
			System.out.println(key);
		}
			/*	Maps do not have order;
			therefore, the order you put entries in is not necessarily the order it will print out.
			If order is necessary, can use TreeMap (less efficient) instead of HashMap.
		 	*/

		//If we want only the values
		for (String values : orangeDictionary.values()) {
			System.out.println(values);
		}
			/* Not really used because a list would be a less messy way of having only values */

		//Check if a key exists
		if (orangeDictionary.containsKey("Pointy")) {
			System.out.println("Pointy: " + orangeDictionary.get("Pointy"));
		} else {
			System.out.println("We don't have a key for Pointy");
		}

		//If we want to change a value
		System.out.println(orangeDictionary.get("Squiggly"));

		orangeDictionary.put("Squiggly", "Curly Braces/Brackets | As used for code blocks, if statements, and for loops.");
		System.out.println(orangeDictionary.get("Squiggly"));

		//Maps are case-sensitive
		System.out.println(orangeDictionary.get("squiggly"));

		orangeDictionary.put("squiggly", "A wiggly line.");	//Adds a new entry instead of replacing
		System.out.println(orangeDictionary.get("squiggly"));
		System.out.println(orangeDictionary.get("Squiggly"));

		for (String key : orangeDictionary.keySet()) {
			System.out.println(key);
		}

		//Can iterate through each Map entry
		for(Map.Entry<String, String> individualEntry : orangeDictionary.entrySet()) {
			System.out.println("Key: " + individualEntry.getKey() + " Value: " + individualEntry.getValue());
		}

		//Can remove from the Map
		orangeDictionary.remove("squiggly");
		System.out.println(orangeDictionary.containsKey("squiggly")); //returns false since "squiggly" is no longer in the String

		for(String key : orangeDictionary.keySet()) {
			System.out.println(key);
		}
	}
}
