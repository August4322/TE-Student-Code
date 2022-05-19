package com.techelevator;

public class Examples {

	public static void main(String[] args) {


		System.out.println("****************");
		System.out.println("**** ARRAYS ****");
		System.out.println("****************");
		System.out.println();

		// the following line declares an array of Strings with 4 elements
		String[] fruit = new String[4];
		fruit[0] = "Apple";
		fruit[1] = "Orange";
		fruit[2] = "Banana";
		fruit[3] = "Pear";
		System.out.println("I have " + fruit.length + " fruits!");
		for (int index = 0; index < fruit.length; index++) {
			System.out.println(fruit[index]);
		}
		System.out.println();

		// the following array has length 3 even when no values have been assigned.
		String[] trees = new String[3];
		System.out.println("I have room for " + trees.length + " trees!");
		trees[1] = "Maple";
		System.out.println(trees[1]);

		int[] intArray = new int[]{1, 2, 3}; // this is how we declare an array literal
		for (int ix = 0; ix < intArray.length; ix++) {
			System.out.print(intArray[ix]);
		}
		System.out.println();
		System.out.println();

		// The same literal syntax would apply to an array of Strings
		String[] stooges = new String[]{"Larry", "Curly", "Moe"};

		/* Arrays are Objects, so they are "passed by reference".  In other words. when assigning
		 * the value of one array variable to another array variable, we are assigning a reference
		 * to the same array to both */
		char[] firstArray = new char[]{'a', 'b', 'c'};
		char[] secondArray = firstArray;

		secondArray[0] = 'z';
		System.out.println("firstArray[0]: " + firstArray[0]);
		System.out.println("secondArray[0]: " + secondArray[0]);


		System.out.println("****************");
		System.out.println("**** IN CLASS LECTURE NOTES _ ARRAYS ****");
		System.out.println("****************");
		System.out.println();

		String name = "Christopher";
		String name2 = "Anthony";
		String name3 = "Ugur";
		String name4 = "Abigail";

		//making arrays prevents having to declare separate values

		String[] listOfNames = {"Christopher", "Anthony", "Ugur", "Abigail"};

		//can also declare an array without knowing the specific values

		String[] names = new String[25];

		//can add values up until the number declared in the string, and that is the max it can hold
		//can access values in the string

		names[0] = "Christopher"; //access first element
		names[1] = "Anthony"; //access elements using the appropriate index (indexes are like addresses)

		names[names.length - 1] = "Abigail"; //to access the last element

		names[14] = "Caitlin";
		names[9] = "Evan";

		//to see which names get printed out you can use:

		System.out.println("First name is " + names[0]);
		System.out.println("Tenth name is " + names[9]);
		System.out.println("Fifteenth name is " + names[14]);
		System.out.println("Twentieth name is " + names[19]);

		//size of array cannot be changed after, but can be set to a variable

//		public static int[] createIntArray;(int size) {
//			int[] arr = new int[size];
//		}
//		int[] myArray1 = createIntArray( 3 );
//		int[] myArray2 = createIntArray(100);


		int x;
		int y;

		System.out.println("*******************************************");
		System.out.println("**** INCREMENT AND DECREMENT OPERATORS ****");
		System.out.println("*******************************************");
		System.out.println();

		/* The ++ operator increments a variable by 1 (i.e. adds one to the
		 * value of the variable and assigns the result to the variable) */
		x = 1;
		System.out.println("x == " + x);
		x++;
		System.out.println("x++ == " + x);
		System.out.println();

		/* The -- operator decrements a variable by 1 (i.e. subtracts one from the
		 * value of the variable and assigns the result to the variable) */
		x = 1;
		System.out.println("x == " + x);
		x--;
		System.out.println("x-- == " + x);
		System.out.println();

		// when the ++ is used as a postfix operator the increment is performed after evalutation
		System.out.println("x = 1");
		x = 1;
		System.out.println("y = x++");
		y = x++;
		System.out.println("x == " + x);
		System.out.println("y == " + y);
		System.out.println();

		// when the ++ is used as a prefix operator the increment is performed before evalutation
		System.out.println("x = 1");
		x = 1;
		System.out.println("y = ++x");
		y = ++x;
		System.out.println("y == " + y);
		System.out.println("x == " + x);
		System.out.println();


		System.out.println("****************************************");
		System.out.println("**** SHORTHAND ASSIGNMENT OPERATORS ****");
		System.out.println("****************************************");
		System.out.println();

		/* The "shorthand operators" are ( += -= *= ).  They have the
		 * effect of applying the arithmetic operator on the variable
		 * on the left and the expression on the right and then assigning
		 * the result to the variable on the left.
		 *
		 * So, this:
		 *
		 *     x = x + 2;
		 *
		 * Is equivalent to this:
		 *
		 *     x += 2;
		 */
		System.out.println("x = 0");
		x = 0;
		System.out.println("y = 0");
		y = 0;

		System.out.println("x += 5");
		x += 5;
		System.out.println("x == " + x);

		// the right hand side of the operator can be an expression
		System.out.println("y += x * 2 + 3");
		y += x * 2 + 3;
		System.out.println("y == " + y);
		System.out.println();


		System.out.println("*******************");
		System.out.println("**** FOR LOOPS ****");
		System.out.println("*******************");
		System.out.println();


		System.out.println("Displaying the numbers 0 - 9 using a for loop");

		// for( init index ; condition to stop; how we increment )
		for (int ix = 0; ix < 10; ix++) {
			System.out.println(ix);
		}
		System.out.println();

		//Can use a for loop to populate an array
		System.out.println("Displaying the results of using a for loop to populate an array");

		int[] numbers = new int[10];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = i + 1;
		}
		//printing out the numbers that have been populated but in reverse order
		for (int j = numbers.length - 1; j >= 0; j--) {
			System.out.println(numbers[j]);
		}

		// Print whether each number between 1 and 10 (inclusive) is even or odd
		for (int ix = 1; ix <= 10; ix++) {
			if (ix % 2 == 0) {
				System.out.println(ix + " is even");
			} else {
				System.out.println(ix + " is odd");
			}
		}
		System.out.println();

		// loops can be nested
		System.out.println("Displaying the numbers 1 - 5, five times, using nested for loops");
		for (int ix = 0; ix < 5; ix++) {
			for (int jx = 1; jx <= 5; jx++) {
				System.out.println(jx);
			}
		}
		System.out.println();


//	private static int[] createIntArray(int i) {
//	}

	}
}
