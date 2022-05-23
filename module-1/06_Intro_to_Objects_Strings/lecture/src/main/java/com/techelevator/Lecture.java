package com.techelevator;

import java.util.Locale;

public class Lecture {

	public static void main(String[] args) {

		System.out.println("************************************");
		System.out.println("****** MAKING A STRING OBJECT ******");
		System.out.println("************************************");

		/* The String class gets special treatment in the Java language.  One
		 * example of this is that there is a literal representation of a
		 * String (i.e. characters appearing between two double quotes.)  This
		 * is not the case for most classes */

		String name = "August";
		//String name = new String("August");

		/* create a new instance of String using a literal */

		
		System.out.println();
		System.out.println("******************************");
		System.out.println("****** MEMBER METHODS ******");
		System.out.println("******************************");
		System.out.println();


		/* Other commonly used methods:*/

		String cat = "Angus";

		//endsWith
		System.out.println("Ends with s: " + cat.endsWith("s")); //true
		System.out.println("Ends with c: " + cat.endsWith("c")); //false

		//startsWith
		System.out.println("Starts with A: " + cat.startsWith("A")); //true
		System.out.println("Starts with a: " + cat.startsWith("a")); //false (Case Sensitive)
				//If you don't care about case you can force the string to lower or upper case and search only on respective letter
				//cat.LowerCase().indexOF("a");

		//indexOf
		System.out.println("Index of A: " + cat.indexOf("A")); //returns the first instance of "A"
		System.out.println("Index of g: " + cat.indexOf("g"));
		System.out.println("Index of e: " + cat.indexOf("e")); //returns -1 if not present

		//lastIndexOf
		System.out.println("Last index of g: " + cat.lastIndexOf("g"));

		//length
		System.out.println("Length of String: " + cat.length());

		//substring
		System.out.println("First three letters of string: " + cat.substring(0, 3));

		//toLowerCase
		System.out.println("All lower case: " + cat.toLowerCase());

		//toUpperCase
		System.out.println("All upper case: " + cat.toUpperCase());

		//trim
		String userInput = "     August      ";
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
