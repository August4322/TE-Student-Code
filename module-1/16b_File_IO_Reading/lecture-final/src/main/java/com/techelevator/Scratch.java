package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import com.techelevator.exceptions.OrangeException;

public class Scratch {


    public static void main(String[] args) {


        File myFile = new File("C:\\Users\\Student\\instructor_repos\\instructor-code\\module-1\\16b_File_IO_Reading\\lecture-final\\rtn.txt");

        // Declaring the scanner in curvies after the try will automatically open and close for you, so you don't have to worry about a finally
        try(Scanner myFileReader = new Scanner(myFile)) {

            while(myFileReader.hasNextLine()) {
                String myLine = myFileReader.nextLine();
                System.out.println(myLine);
            }

        } catch( FileNotFoundException ex) {
            System.out.println("File was not found, check the path");
        } catch(Exception ex) {
            System.out.println("Something went wrong");
        }

        /*
        Scratch s = new Scratch();
        s.method1();

        boolean validInput = false;
        while(!validInput) {
            try {
                Scanner input = new Scanner(System.in);
                System.out.println("Please enter your dog's age:");
                String ageInput = input.nextLine();

                int dogAgeInHumanYears = Integer.parseInt(ageInput) * 7;

               // String myName = null;
               // System.out.println("My name is length " + myName.length());

                System.out.println("Your dog is " + dogAgeInHumanYears + " in human years");

                //breaks us out of the while loop
                validInput = true;

            } catch (NumberFormatException ex) {
                System.out.println("Please enter a strictly numeric value");
            } catch(NullPointerException iCouldNameThisAnything) {
                System.out.println("Your name cannot be null");
            } catch (Exception ex) {
                System.out.println("Something went wrong");
            } finally {
                // this code will run regardless of if an exception was thrown
                // we can clean up any open connections - for instance to a database
                System.out.println("This is the finally");
            }


        }
*/


    }

    public void run() {
        try{
            checkClass("orange");
        } catch(OrangeException ex) {
            System.out.println("THis is a custom exception and we have a custom field I can access, numStudents:" + ex.getNumStudents());
        }
    }

    /*Example to demonstrate using custom exception */
    public String checkClass(String color) throws OrangeException {

        if(color.equals("orange")) {
            throw new OrangeException("We are the exception", 21);
        }

        return color;

    }

    public void method1() {
        try {
            method2();
        } catch(NullPointerException ex) {
            System.out.println("Null Pointer!");

        } catch(Exception ex) {
            System.out.println("There was an error");
        }
    }

    public void method2() throws Exception{
        method3();
    }

    public void method3() throws Exception{
        throw new Exception("null!");

    }

    public int[] get123() {
        int[] myArray = {1,2,3};
        return myArray;
    }

    public Map<String, String> getMap() {

        Map<String,String> myMap = new HashMap<>();
        myMap.put("giraffe", "Tower");
        myMap.put("dog", "Pack");

        return myMap;


    }
}
