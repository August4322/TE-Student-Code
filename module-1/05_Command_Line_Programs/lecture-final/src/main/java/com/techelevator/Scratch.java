package com.techelevator;

public class Scratch {

    public boolean[] assignSeat(int numberOfSeats) {

        boolean[] seats = new boolean[numberOfSeats];

        // init index; condition for when to keep looping; how to increment
        for(int index = 0; index < seats.length; index++){

            if(index == 2) {
                break; // breaks completely out of the for loop and executes code afterward
            }
            if(index == 3) {
                continue; //stops executing the current code block, jumps back to top of for loop
            }

            seats[index] = true;
        }

        return seats;
    }

    public String[] removeFromDeck(String[] originalDeck) {

        //if the deck is empty or nothing return an empty array
        if(originalDeck.length <= 1 || originalDeck == null) {
            String[] newDeck = new String[0];
            return newDeck;
        }

        String[] newDeck = new String[originalDeck.length-1];
        for(int index = 1; index < originalDeck.length; index++){
            newDeck[index-1] = originalDeck[index];
        }

        return newDeck;
    }

    public static void main(String[] args) {

        // Two ways to initialize an array
        int[] myIntArray = new int[5];
        int[] myIntArray2 = {1,2,3,4,5};

        String[] myStringArray = {"Christopher", "Anthony", "Sasi", "Nick"};
        String[] myStringArray2 = new String[2];

        double[] myDoubleArray = {1.0, 2.0, 3.0};

        //to get the first element
        String firstElement = myStringArray[0];

        //to find the size of an array
        int arraySize = myStringArray.length;

        //to get the last element of the array remember that the last index will be one less than the length
        String lastElement = myStringArray[myStringArray.length - 1];



        // String Equality
        String s1 = new String("Christopher");
        String s2 = new String("Christopher");
        boolean isStringEqual = (s1 == s2);
        System.out.println("Are the strings equal: " + isStringEqual);
        isStringEqual = (s1.equals(s2));
        System.out.println("Are the strings equal: " + isStringEqual);

        // How to split strings
        String commaSeparatedList = "Christopher,Anthony,Sasi";
        String[] instructors = commaSeparatedList.split(",");

        for(int index = 0; index < instructors.length; index++) {
            System.out.println(instructors[index]);
        }

    }

}
