package com.techelevator;

import java.util.*;

public class Lecture {

	public static void main(String[] args) {

		int[] intArray = new int[10];
		String[] stringArray = new String[10];

		List<Integer> intList = new ArrayList<>();
		List<String> stringList = new ArrayList<String>();

		stringList.add("Christopher");
		stringList.add("Anthony");
		stringList.add("Evan");
		stringList.add(0, "Ugur");

		for(int index = 0; index < stringList.size(); index++){
			System.out.println(stringList.get(index));
		}

		if(stringList.contains("Greg")) {
			System.out.println("We found Greg");
		} else {
			System.out.println("We need to add Greg");
		}

		int indexOfChristopher = stringList.indexOf("Christopher");
		stringList.remove(indexOfChristopher);
		// stringList.remove("Christopher");

		for(int index = 0; index < stringList.size(); index++){
			System.out.println(stringList.get(index));
		}

		String className = "orange";
		int indexOfAn = className.indexOf("an");
		System.out.println(className.substring(0,indexOfAn));
		System.out.println(className.substring(indexOfAn+2));

		List<String> stringList2 = new ArrayList<>();
		stringList2.add("Dane");
		stringList2.add("Abigail");
		stringList2.add("Brooke");
		stringList2.add("Zaki");

		System.out.println("*************************");

		// Hint 1: For below how to check that the list is long enough (size) that we can actually retrieve a value from it
		// Hint 2: How many times will we need to run through the for loop if stringList2 is larger? What if stringList is larger?

		/*
		for(int i = 0; i < stringList2.size(); i++){
			if(stringList.get(i) != null) {
				System.out.println(stringList.get(i));
			}
			if(stringList2.get(i) != null) {
				System.out.println(stringList2.get(i));
			}
		}
		*/


		System.out.println("####################");
		System.out.println("        MAPS");
		System.out.println("####################");
		System.out.println();

		// Map<Datatype of key, Datatype of value>
		Map<String, String> orangeDictionary = new HashMap<>();

		/*
			Maps do not keep track of order. But if you absolutely need to, instead of using HashMap, use TreeMap. It is less efficient tho
		 */


		orangeDictionary.put("Squiggly", "Curly Braces / Curly Brackets. As used for code blocks.");
		orangeDictionary.put("Squarie", "Square brackets, as used with arrays");
		orangeDictionary.put("Pointy", "Carrot braces / greater than or less than sign, as used for specifying data type on lists and maps");

		System.out.println("####################");
		System.out.println("To retrieve, use .get");
		System.out.println("####################");
		System.out.println(orangeDictionary.get("Squiggly"));

		System.out.println("####################");
		System.out.println("if we try to retrieve a value that doesn't exist...");
		System.out.println("####################");
		System.out.println(orangeDictionary.get("Squigglie"));

		System.out.println("####################");
		System.out.println("If we only want the keys");
		System.out.println("####################");
		for(String key : orangeDictionary.keySet()) {
			System.out.println(key);
		}

		System.out.println("####################");
		System.out.println("Check if a key exists");
		System.out.println("####################");

		if(orangeDictionary.containsKey("Pointy")) {
			System.out.println("Pointy: " + orangeDictionary.get("Pointy"));
		} else {
			System.out.println("We don't have a key pointy");
		}

		System.out.println("####################");
		System.out.println("If we want to update a value");
		System.out.println("####################");

		System.out.println(orangeDictionary.get("Squiggly"));

		// if already exists, it already updates
		orangeDictionary.put("Squiggly", "Curly Braces / Curly Brackets. As used for code blocks after method declarations, ifs, and for loops.");

		System.out.println(orangeDictionary.get("Squiggly"));

		System.out.println("####################");
		System.out.println("Careful, because keys are case sensitive");
		System.out.println("####################");

		System.out.println(orangeDictionary.get("Squiggly"));

		// if already exists, it already updates
		orangeDictionary.put("squiggly", "New definition");

		System.out.println(orangeDictionary.get("Squiggly"));

		// see how it adds a new key
		// ALSO: NOTE THE ORDER. THERE IS NO ORDER WITH MAPS
		for(String key : orangeDictionary.keySet()) {
			System.out.println(key);
		}

		System.out.println("####################");
		System.out.println("We can also iterate through each entry");
		System.out.println("####################");

		for(Map.Entry<String, String> individualEntry : orangeDictionary.entrySet()) {
			System.out.println("Key: " + individualEntry.getKey() + "  Value:" + individualEntry.getValue());
		}

		System.out.println("####################");
		System.out.println("We can also iterate through each value");
		System.out.println("####################");

		for(String value : orangeDictionary.values()) {
			System.out.println(value);
		}

		System.out.println("####################");
		System.out.println("We can also remove from the map");
		System.out.println("####################");

		orangeDictionary.remove("squiggly");
		System.out.println(orangeDictionary.containsKey("squiggly"));
		for(String key : orangeDictionary.keySet()) {
			System.out.println(key);
		}


		String animal = "Cat";
		orangeDictionary.put(animal.toLowerCase(), "meow");


		System.out.println("####################");
		System.out.println("Sets: like list, but unique values");
		System.out.println("####################");
		Set<String> characters = new HashSet<String>();

		characters.add("Luke");
		characters.add("Rey");
		characters.add("Ben");
		characters.add("Luke");



		for(String character : characters) {
			System.out.println(character);
		}

		// Remember you can convert among types
		// Arrays.asList(characters.toArray());

	}

}
