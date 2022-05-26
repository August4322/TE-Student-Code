package com.techelevator;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

public class Exercises {

	/*
	 * Given the name of an animal, return the name of a group of that animal
	 * (e.g. "Elephant" -> "Herd", "Rhino" - "Crash").
	 *
	 * The animal name should be case-insensitive so "elephant", "Elephant", and
	 * "ELEPHANT" should all return "Herd".
	 *
	 * If the name of the animal is not found, null, or empty, return "unknown".
	 *
	 * Rhino -> Crash
	 * Giraffe -> Tower
	 * Elephant -> Herd
	 * Lion -> Pride
	 * Crow -> Murder
	 * Pigeon -> Kit
	 * Flamingo -> Pat
	 * Deer -> Herd
	 * Dog -> Pack
	 * Crocodile -> Float
	 *
	 * animalGroupName("giraffe") → "Tower"
	 * animalGroupName("") -> "unknown"
	 * animalGroupName("walrus") -> "unknown"
	 * animalGroupName("Rhino") -> "Crash"
	 * animalGroupName("rhino") -> "Crash"
	 * animalGroupName("elephants") -> "unknown"
	 *
	 */
	public String animalGroupName(String animalName) {
		//Initialize Map
		Map<String, String> animalCongregation = new HashMap<String, String>();

		//Populate the Map
		animalCongregation.put("rhino", "Crash");
		animalCongregation.put("giraffe", "Tower");
		animalCongregation.put("elephant", "Herd");
		animalCongregation.put("lion", "Pride");
		animalCongregation.put("crow", "Murder");
		animalCongregation.put("pigeon", "Kit");
		animalCongregation.put("flamingo", "Pat");
		animalCongregation.put("deer", "Herd");
		animalCongregation.put("dog", "Pack");
		animalCongregation.put("crocodile", "Float");

		//CHECK FOR NULL
		if (animalName == null) {
			return "unknown";
			//Check for strings not in "animalName"
		} else if (!(animalCongregation.containsKey(animalName.toLowerCase()))) {
			return "unknown";
			//Check for key in "animalName" and return value
		}
		return animalCongregation.get(animalName.toLowerCase());
	}

	/*
	 * Given a String item number (a.k.a. SKU), return the discount percentage if the item is on sale.
	 * If the item is not on sale, return 0.00.
	 *
	 * If the item number is empty or null, return 0.00.
	 *
	 * "KITCHEN4001" -> 0.20
	 * "GARAGE1070" -> 0.15
	 * "LIVINGROOM"	-> 0.10
	 * "KITCHEN6073" -> 0.40
	 * "BEDROOM3434" -> 0.60
	 * "BATH0073" -> 0.15
	 *
	 * The item number should be case-insensitive so "kitchen4001", "Kitchen4001", and "KITCHEN4001"
	 * should all return 0.20.
	 *
	 * isItOnSale("kitchen4001") → 0.20
	 * isItOnSale("") → 0.00
	 * isItOnSale("GARAGE1070") → 0.15
	 * isItOnSale("dungeon9999") → 0.00
	 *
	 */
	public double isItOnSale(String itemNumber) {
		//Initialize Map
		Map<String, Double> isItemOnSale = new HashMap<>();

		//Populate the Map
		isItemOnSale.put("KITCHEN4001", 0.20);
		isItemOnSale.put("GARAGE1070", 0.15);
		isItemOnSale.put("LIVINGROOM", 0.10);
		isItemOnSale.put("KITCHEN6073", 0.40);
		isItemOnSale.put("BEDROOM3434", 0.60);
		isItemOnSale.put("BATH0073", 0.15);


		//CHECK FOR NULL
		if (itemNumber == null) {
			return 0.00;
			//Check for strings not in "itemNumber"
		} else if (!(isItemOnSale.containsKey(itemNumber.toUpperCase()))) {
			return 0.00;
			//Check for key in "itemNumber" and return value
		}
		return isItemOnSale.get(itemNumber.toUpperCase());
	}

	/*
	 * Modify and return the given Map as follows: if "Peter" has more than 0 money, transfer half of it to "Paul",
	 * but only if Paul has less than $10s.
	 *
	 * Note, monetary amounts are specified in cents: penny=1, nickel=5, ... $1=100, ... $10=1000, ...
	 *
	 * robPeterToPayPaul({"Peter": 2000, "Paul": 99}) → {"Peter": 1000, "Paul": 1099}
	 * robPeterToPayPaul({"Peter": 2000, "Paul": 30000}) → {"Peter": 2000, "Paul": 30000}
	 *
	 */
	public Map<String, Integer> robPeterToPayPaul(Map<String, Integer> peterPaul) {

		//Check if Paul has < 1000 && Check if Peter has > 0
		int paul = peterPaul.get("Paul");
		int peter = peterPaul.get("Peter");

		if (paul < 1000 && peter > 0) {
			//If both are true, then half of Peter's money will be added to Paul's money
			paul += peter / 2;

			//Remove half of Peter's amount
			peter -= peter / 2;

			//Update Map with new values
			peterPaul.put("Paul", paul);
			peterPaul.put("Peter", peter);

		}
		//Return Map
		return peterPaul;
	}

	/*
	 * Modify and return the given Map as follows: if "Peter" has $50 or more, AND "Paul" has $100 or more,
	 * then create a new "PeterPaulPartnership" worth a combined contribution of a quarter of each partner's
	 * current worth.
	 *
	 * peterPaulPartnership({"Peter": 50000, "Paul": 100000}) → {"Peter": 37500, "Paul": 75000, "PeterPaulPartnership": 37500}
	 * peterPaulPartnership({"Peter": 3333, "Paul": 1234567890}) → {"Peter": 3333, "Paul": 1234567890}
	 *
	 */
	public Map<String, Integer> peterPaulPartnership(Map<String, Integer> peterPaul) {

		//Check if Paul has > 10000 && Check if Peter has > 5000
		int paul = peterPaul.get("Paul");
		int peter = peterPaul.get("Peter");

		if (paul >= 10000 && peter >= 5000) {
			//If both are true, then get the sum of Peter and Paul's money
			int paulPeterPartnership = (peter / 4) + (paul / 4);
			paul -= paul / 4;
			peter -= peter / 4;

			//Update Map with new values
			peterPaul.put("Peter", peter);
			peterPaul.put("Paul", paul);
			peterPaul.put("PeterPaulPartnership", paulPeterPartnership);
		}
		//Return Map
		return peterPaul;
	}

	/*
	 * Given an array of non-empty Strings, return a Map<String, String> where for every different String in the array,
	 * there is a key of its first character with the value of its last character.
	 *
	 * beginningAndEnding(["code", "bug"]) → {"b": "g", "c": "e"}
	 * beginningAndEnding(["man", "moon", "main"]) → {"m": "n"}
	 * beginningAndEnding(["muddy", "good", "moat", "good", "night"]) → {"g": "d", "m": "t", "n": "t"}
	 */
	public Map<String, String> beginningAndEnding(String[] words) {
		//Initialize Map
		Map<String, String> firstAndLast = new HashMap<>();

		//Iterate through string and select the first and last chars
		for (String stringChar : words) {
			firstAndLast.put(stringChar.substring(0, 1), stringChar.substring(stringChar.length() - 1));
			//Return Map
		}
		return firstAndLast;
	}

	/*
	 * Given an array of Strings, return a Map<String, Integer> with a key for each different String, with the value the
	 * number of times that String appears in the array.
	 *
	 * ** A CLASSIC **
	 *
	 * wordCount(["ba", "ba", "black", "sheep"]) → {"ba" : 2, "black": 1, "sheep": 1 }
	 * wordCount(["a", "b", "a", "c", "b"]) → {"b": 2, "c": 1, "a": 2}
	 * wordCount([]) → {}
	 * wordCount(["c", "b", "a"]) → {"b": 1, "c": 1, "a": 1}
	 *
	 */
	public Map<String, Integer> wordCount(String[] words) {
		//Initialize Map
		Map<String, Integer> wordCountKey = new HashMap<>();

		//Iterate through string
		for (String keyCount : words) {
			//See if the value is in the map
			if (wordCountKey.containsKey(keyCount)) {
				//If the prevalence > 1
				int prevalenceAmount = wordCountKey.get(keyCount);
				prevalenceAmount++;
				wordCountKey.put(keyCount, prevalenceAmount);
				//If the prevalence <= 1
			} else {
				wordCountKey.put(keyCount, 1);
			}
		}
		//Return Map
		return wordCountKey;
	}

	/*
	 * Given an array of int values, return a Map<Integer, Integer> with a key for each int, with the value the
	 * number of times that int appears in the array.
	 *
	 * ** The lesser known cousin of the classic wordCount **
	 *
	 * intCount([1, 99, 63, 1, 55, 77, 63, 99, 63, 44]) → {1: 2, 44: 1, 55: 1, 63: 3, 77: 1, 99:2}
	 * intCount([107, 33, 107, 33, 33, 33, 106, 107]) → {33: 4, 106: 1, 107: 3}
	 * intCount([]) → {}
	 *
	 */
	public Map<Integer, Integer> integerCount(int[] ints) {
		//Initialize Map
		Map<Integer, Integer> countOfIntegers = new HashMap<>();

		//Iterate through integer values
		for (Integer integers : ints) {
			//See if the value is in the map
			if (countOfIntegers.containsKey(integers)) {
				//If the prevalence > 1
				int prevalenceAmount = countOfIntegers.get(integers);
				prevalenceAmount++;
				countOfIntegers.put(integers, prevalenceAmount);
				//If the prevalence <= 1
			} else {
				countOfIntegers.put(integers, 1);
			}
		}
		//Return Map
		return countOfIntegers;

	}

	/*
	 * Given an array of Strings, return a Map<String, Boolean> where each different String is a key and value
	 * is true only if that String appears 2 or more times in the array.
	 *
	 * wordMultiple(["a", "b", "a", "c", "b"]) → {"b": true, "c": false, "a": true}
	 * wordMultiple(["c", "b", "a"]) → {"b": false, "c": false, "a": false}
	 * wordMultiple(["c", "c", "c", "c"]) → {"c": true}
	 *
	 */
	public Map<String, Boolean> wordMultiple(String[] words) {
		//Initialize Maps
		Map<String, Boolean> wordsAppearMoreThanOnce = new HashMap<>(); //Last Map if true or false
		Map<String, Integer> twoOrMore = new HashMap<>(); //Map to run prevalence of words in string

		//Iterate through string
		for (String strings : words) {
			//See if the value is in the map
			if (twoOrMore.containsKey(strings)) {
				//If the prevalence > 1
				int prevalence = twoOrMore.get(strings);
				prevalence++;
				if (prevalence > 1) {
					wordsAppearMoreThanOnce.put(strings, true);
					//If the prevalence <= 1
				} else {
					wordsAppearMoreThanOnce.put(strings, false);
				}
				//If the value is not in the map
			} else {
				twoOrMore.put(strings, 1);
				wordsAppearMoreThanOnce.put(strings, false);
			}
		}
		//Return Map
		return wordsAppearMoreThanOnce;
	}

	/*
	 * Given two Maps, Map<String, Integer>, merge the two into a new Map, Map<String, Integer> where keys in Map2,
	 * and their int values, are added to the int values of matching keys in Map1. Return the new Map.
	 *
	 * Unmatched keys and their int values in Map2 are simply added to Map1.
	 *
	 * consolidateInventory({"SKU1": 100, "SKU2": 53, "SKU3": 44} {"SKU2":11, "SKU4": 5})
	 * 	 → {"SKU1": 100, "SKU2": 64, "SKU3": 44, "SKU4": 5}
	 *
	 */
	public Map<String, Integer> consolidateInventory(Map<String, Integer> mainWarehouse, Map<String, Integer> remoteWarehouse) {
		//Initialize Map
		Map<String, Integer> combinedMap = new HashMap<>();

		//Iterate through the main warehouse to see if there is any overlap
		for (String overlappingInventory : mainWarehouse.keySet()) {
			//If warehouses do have overlapping inventory
			if (remoteWarehouse.containsKey(overlappingInventory)) {
				combinedMap.put(overlappingInventory, (mainWarehouse.get(overlappingInventory) + remoteWarehouse.get(overlappingInventory)));
				///If warehouses do not have overlapping inventory
			} else {
				combinedMap.put(overlappingInventory, mainWarehouse.get(overlappingInventory));
			}
		}
		//Iterate through the remote warehouse to see if there is any inventory leftover
		for (String leftoverInventory : remoteWarehouse.keySet()) {
			if (!(mainWarehouse.containsKey(leftoverInventory))) {
				combinedMap.put(leftoverInventory, remoteWarehouse.get(leftoverInventory));
			}
		}
		//Return Map
		return combinedMap;
	}

	/*
	 * Just when you thought it was safe to get back in the water --- last2Revisited!!!!
	 *
	 * Given an array of Strings, for each String, the count of the number of times that a subString length 2 appears
	 * in the String and also as the last 2 chars of the String, so "hixxxhi" yields 1.
	 *
	 * We don't count the end subString, but the subString may overlap a prior position by one.  For instance, "xxxx"
	 * has a count of 2, one pair at position 0, and the second at position 1. The third pair at position 2 is the
	 * end subString, which we don't count.
	 *
	 * Return Map<String, Integer>, where the key is String from the array, and its last2 count.
	 *
	 * last2Revisited(["hixxhi", "xaxxaxaxx", "axxxaaxx"]) → {"hixxhi": 1, "xaxxaxaxx": 1, "axxxaaxx": 2}
	 *
	 */
	public Map<String, Integer> last2Revisited(String[] words) {
		//Initialize Map
		Map<String, Integer> last2ElectricBoogaloo = new HashMap<>();

		//Iterate through the string
		for (int i = 0; i < words.length; i++) {
			//Check if the word length is too small
			if (words[i].length() <= 2) {
				//Add to Map
				last2ElectricBoogaloo.put(words[i], 0);
			//If length is fine look for iterations of the last two characters
			} else {
				//Initialize integers
				int instancesOfLast2 = 0;
				//Initialize a string with the last two characters in a string
				String keyOfLast2 = words[i].substring(words[i].length() - 2);
				for (int j = 0; j < words[i].length() -2; j ++) {
					String lookThroughString = words[i].substring(j, j + 2);
					if (lookThroughString.equals(keyOfLast2)) {
						//if you find iterations of the last two characters add to the count
						instancesOfLast2 ++;
					}
				}
				//Add to Map
				last2ElectricBoogaloo.put(words[i], instancesOfLast2);
			}
		}
		//Return Map
		return last2ElectricBoogaloo;
	}

	/*
	***The Original***

	public int last2(String str) {

		if (str.length() < 2) return 0;
		String endOfStr = str.substring(str.length() -2);
		int instancesOfLast2 = 0;

		for (int i = 0; i < str.length() -2; i ++) {
			String lookThroughString = str.substring(i, i + 2);
			if (lookThroughString.equals(endOfStr)) {
				instancesOfLast2 ++;
			}
		}
		return instancesOfLast2;
	}
	*/


}
