package com.techelevator;

import java.util.Scanner;

public class Scratch {


    public static void main (String[] args) {

        // this is creating an object when the application is running
        Calculator calc = new Calculator();

        int sum = calc.add(1,2);
        int difference = calc.subtract(5,4);
        int product = calc.multiply(2,2);

        Person christopher = new Person(37, "Christopher", "christopher@techelevator.com");
        Person anthony = new Person(25, "Anthony", "anthony@techelevator.com");

        System.out.println(christopher.getName() + ": " + christopher.getEmail());
        System.out.println(anthony.getName());

        /*
        // declaring a variable:
        // datatype variablename = value
        int age = 37;

        String name = "Christopher";

        double priceOfCoffee = 2.25;

        boolean isOlderThan18 = age > 18;

        if (isOlderThan18) {
            System.out.println("Enjoy watching the R-rated movies!");
        } else {
            System.out.println("You're just not ready");
        }

        int[] ages = {15, 18, 21, 37};
        // int[] ages = new int[4];

        int averageAge = 0;
        int sum = 0;
        // init index; condition of when to run; how to increment
        for(int index = 0; index < ages.length; index += 3 ){
            sum += ages[index++];

            // airplaneRow[index] // represents you in the first seat
            // airplaneRow[index +1] //represents your neighbor
            // airplaneRow[index+2] //represents your neighbor's neighbor
            // and then if all of those are true, then you know the row is full
        }


        averageAge = sum / ages.length;
        System.out.println("Average age is: " + averageAge);


        int var = 2;

        System.out.println("var is : " + (++var));
        System.out.println("var is now: " + var);


        Scanner scan = new Scanner(System.in);

        System.out.println("PLease enter your name:");
        String inputtedName = scan.nextLine();
        System.out.println("Your name is " + inputtedName);

        System.out.println("Please enter the name of your cats (space separated)");
        String inputCats = scan.nextLine();

        String[] cats = inputCats.split(" ");
        for(int i = 0; i < cats.length; i++) {
            System.out.println(cats[i]);
        }

        String txtNum = "5";
        double num = Double.parseDouble(txtNum);

        while(true) {
            if(true) {
                break;
            }
        }
*/
    }
}

