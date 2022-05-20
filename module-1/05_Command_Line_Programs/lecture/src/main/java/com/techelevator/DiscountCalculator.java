package com.techelevator;

import java.util.Scanner;

class DiscountCalculator {

    /**
     * The main method is the start and end of our program
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Discount Calculator");

        // Prompt the user for a discount amount
        // The answer needs to be saved as a double
        System.out.print("Enter the discount amount (w/out percentage): ");

        //This will read from the console (user input)
        String input = scanner.nextLine();

        //How to cast a string to a number:
        /*
        int: Integer.parseInt(input)
        Double: Double.parseDouble(input)
        long: Long.parseLong(input)
        boolean: Boolean.parseBoolean(input)
         */

        int discount = Integer.parseInt(input);

        // Prompt the user for a series of prices
        System.out.print("Please provide a series of prices (space separated): ");

        String pricesInput = scanner.nextLine();
        String[] prices = pricesInput.split(" ");

        for(int i = 0; i < prices.length; i++) {
            double priceConverted = Double.parseDouble(prices[i]);

            double newPrice = priceConverted * (1.0 - (discount/100));

            System.out.println("Original price is $" + prices[i] + " but discounted to $"+ newPrice);
        }





        //String Equality
        String s1 = new String("August");
        String s2 = new String("August");
        boolean isStringEqual = ("August" == "August");
        System.out.println("Are the strings equal: " + isStringEqual); //Should give false because *shrug* will learn more on monday
        isStringEqual = (s1.equals(s2));
        System.out.println("Are the strings equal: " + isStringEqual); //Gives true and is the right way to compare strings



        //Creates an array splitting on ","
        String commaSeperatedList = "Christopher,Anthony,Sasi";
        String[] instructors = commaSeperatedList.split(",");
        for (int i = 0; i < instructors.length; i++) {
            System.out.println(instructors[i]);
        }

    }

}