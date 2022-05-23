package com.techelevator;

public class Lecture {

	public static void main(String[] args) {

		System.out.println("************************************");
		System.out.println("****** MAKING A STRING OBJECT ******");
		System.out.println("************************************");

		/* The String class gets special treatment in the Java language.  One
		 * example of this is that there is a literal representation of a
		 * String (i.e. characters appearing between two double quotes.  This
		 * is not the case for most classes */

		String name = "Christopher";
		//String name = new String("Christopher");

		/* create an new instance of String using a literal */

		
		System.out.println();
		System.out.println("******************************");
		System.out.println("****** MEMBER METHODS ******");
		System.out.println("******************************");
		System.out.println();


		/* Other commonly used methods: */

		String cat = "Salem";

		 // endsWith
		System.out.println("Ends with m:" + cat.endsWith("m"));
		System.out.println("Ends with c:" + cat.endsWith("c"));

		 // startsWith
		System.out.println("Starts with S: " + cat.startsWith("S"));
		System.out.println("Starts with s: " + cat.startsWith("s"));

		 // indexOf - return index of first instance it finds
		System.out.println("Index of S: " + cat.indexOf("S"));
		System.out.println("Index of l: " + cat.indexOf("l"));
		System.out.println("Index of t: " + cat.indexOf("t"));

		//if you don't care about case, you can force the string to lower or upper case and search only on respective letter
		cat.toLowerCase().indexOf("s");

		String fruit = "banana";
		//  lastIndexOf
		System.out.println("Last index of a : " + fruit.lastIndexOf("a"));

		//  length
		System.out.println("Length of string: " + fruit.length());

		//  substring
		System.out.println("First three letters of string: " + fruit.substring(0, 3));

		 // toLowerCase
		System.out.println("All lower case:" + cat.toLowerCase());
		 // toUpperCase
		System.out.println("All upper case:" + cat.toUpperCase());

		//  trim
		String userInput = "     Christopher       ";
		System.out.println("*" + userInput + "*");
		System.out.println("*" + userInput.trim() + "*");

		System.out.println();
		System.out.println("**********************");
		System.out.println("****** EQUALITY ******");
		System.out.println("**********************");
		System.out.println();

        char[] helloArray = new char[] { 'H', 'e', 'l', 'l', 'o' };
        String hello1 = new String(helloArray);
        String hello2 = new String(helloArray);

		/* Double equals will compare to see if the two variables, hello1 and
		 * hello2 point to the same object in memory. Are they the same object? */
		if (hello1 == hello2) {
			System.out.println("They are equal!");
		} else {
			System.out.println(hello1 + " is not equal to " + hello2);
		}

		String hello3 = hello1;
		if (hello1 == hello3) {
			System.out.println("hello1 is the same reference as hello3");
		}

		/* So, to compare the values of two objects, we need to use the equals method.
		 * Every object type has an equals method */
		if (hello1.equals(hello2)) {
			System.out.println("They are equal!");
		} else {
			System.out.println(hello1 + " is not equal to " + hello2);
		}

	}
}
