package com.techelevator;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class HelloWorld {

    public static void main(String[] args) {

        /* This is a multiline
        comment
        as a
        test to se how
        this stuff works
        */

        // datatype variableName = value;
        int x = 5;
        System.out.println(x);

        boolean y = true;
        System.out.println(y);

        double z = 2.3;
        System.out.println(z);

        String name = "August";
        System.out.println(name);

        System.out.println("Hello! My name is August.");
        System.out.println("Today is " + LocalDate.now());
        System.out.println("The current time is " + LocalTime.now());

    }

}
