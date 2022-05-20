package com.techelevator;

import java.util.Scanner;

class DiscountCalculator {

    /**
     * The main method is the start and end of our program
     */
    public static void main(String[] args) {

        // Subscribe to your streaming service, System.in. This is going to pull in user input from the console when we call nextLine()
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Discount Calculator");

        // Prompt the user for a discount amount
        // The answer needs to be saved as a double
        System.out.print("Enter the discount amount (w/out percentage): ");

        // this will read from the console
        String input = scanner.nextLine();

        //How to cast a string to a number
        /*
        int:  Integer.parseInt(input)
        double: Double.parseDouble(input)
        long: Long.parseLong(input)
        boolean: Boolean.parseBoolean(input)


         */

        double discount = Double.parseDouble(input);

        System.out.println("Our discount is: " + input);



        // Prompt the user for a series of prices
        System.out.print("Please provide a series of prices (space separated): ");

        String pricesInput = scanner.nextLine();
        String[] prices = pricesInput.split(" ");
        
        for(int i = 0; i < prices.length; i++) {
            double priceConverted = Double.parseDouble(prices[i]);

            double newPrice = priceConverted * (1.0 - (discount/100));

            System.out.println("Original price is $" + prices[i] + " but discounted to "+ newPrice);
        }






    }

}