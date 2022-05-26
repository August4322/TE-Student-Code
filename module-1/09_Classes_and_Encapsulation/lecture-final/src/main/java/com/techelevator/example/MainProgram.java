package com.techelevator.example;

import java.util.*;

public class MainProgram {

	public static void main(String[] args) {

		Book myBook = new Book("The Shinning", "FIC123", "Stephen King", true, "Horror", 666, 2, 1983);
		Book myBook2 = new Book("The Book Thief", "FIC456", "Stephen King", true, "Horror", 666, 2, 1983);

		myBook.setTitle("The Shining");
		myBook.setAuthor("Joe Hill");

		myBook.setPaperback(true);


		System.out.println(myBook.getTitle());
		System.out.println(myBook.getCallNumber());
		System.out.println(myBook.getAuthor());

		double finalCost = myBook.calculateSalePrice(10);
		System.out.println(finalCost);


		// Substring is overloaded, it's named the same thing but accepts a different number of parameters
		String name = "Christopher";
		String firstLetter = name.substring(0, 1);
		String restOfName = name.substring(1);


		BankAccount acc = new BankAccount();



		/*
		Map<String, Book> collectionOfBooks = new HashMap<String, Book>();
		collectionOfBooks.put("FIC123", new Book("The Moon and Sixpence"));
		collectionOfBooks.put("FIC456", new Book("The Book Thief"));
		collectionOfBooks.put("FIC879", new Book("Locke & Key"));

		collectionOfBooks.put("FIC123", new Book("Razor's Edge"));

		System.out.println("Finished Adding Books");

		// If I want an individual value
		System.out.println(collectionOfBooks.get("FIC456").getTitle());

		// Iterate only through the keys
		for(String key : collectionOfBooks.keySet()) {
			System.out.println(key);
		}

		//Iterate only through the values
		for(Book value : collectionOfBooks.values()) {
			System.out.println(value.getTitle());
		}

		//Iterate through the entries
		Map<String, Book> donatedBooks = new HashMap<String, Book>();
		donatedBooks.put("fic879", new Book("Locke & Key"));
		donatedBooks.put("fic012", new Book("The Shining"));

		String keyToLookFor = "fIc012";
		for(Map.Entry<String, Book> entry : donatedBooks.entrySet()) {

			if(entry.getKey().equalsIgnoreCase(keyToLookFor)) {
				System.out.println(donatedBooks.get(entry.getKey()));
			}

		}


		for(Map.Entry<String, Book> entry : donatedBooks.entrySet()) {

			System.out.println("Key: " + entry.getKey() + " Value:" + entry.getValue());
			String donatedKey = entry.getKey();
			if(!collectionOfBooks.containsKey(donatedKey.toUpperCase())) {
				collectionOfBooks.put(entry.getKey(), entry.getValue());
			}
		}

		List<String> myList = new ArrayList<>();
		myList.add("Christopher");
		myList.add("Nick");
		myList.add("Anthony");

		Map<String, String> letterMap = new HashMap<>();

		//key
		String firstLetter = myList.get(0).substring(0,1).toUpperCase();
		String lowerCaseRestOfWord = myList.get(0).substring(1).toLowerCase();
		String formattedKey = firstLetter + lowerCaseRestOfWord;

		//value
		String lastLetter = Character.toString(myList.get(0).charAt(myList.size()-1));

		letterMap.put(firstLetter, lastLetter);
		*/

	}


	public String getValue(String key) {


		Map<String, Book> donatedBooks = new HashMap<String, Book>();
		donatedBooks.put("fic879", new Book("Locke & Key"));
		donatedBooks.put("fic012", new Book("The Shining"));

		if(key == null) {
			return "Not Found";
		}

		//    null.toLowerCase();
		key = key.toLowerCase();

		return "";

	}

}
