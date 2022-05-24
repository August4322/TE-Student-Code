package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class Scratch {

    public static void main(String[] args){

/*
        String name = "Christopher";

        System.out.println("Length of name:" + name.length());

        String part = name.substring(0,3);
        System.out.println("Result is:" + part);
        System.out.println("Length of part:" + name.substring(0,3).toUpperCase().trim().length());
        */
        int age1 = 37;
        int age2 = 22;
        int age3 = 45;

        int[] ages = {37,22,45};
        int[] ages2 = new int[3];

        // first element
        ages[0] = 30;

        // last element
        ages[ages.length - 1] = 50;

       /* for(int index = 0; index < ages.length; index++) {
            System.out.println(ages[index]);
        }
        */

        for(int age : ages) {
            System.out.println(age);
        }

        List<String> names = new ArrayList<String>();
        names.add("Christopher");
        names.add("Anthony");
        names.add("Nick");
        names.add("Sasi");
        names.add("Greg");
        names.add("Greg");

        for(int index = 0; index < names.size(); index++) {
            System.out.println(names.get(index));
        }



        System.out.println("Size before remove:" + names.size());

        // names.remove("Greg");

        while(names.contains("Greg") || names.contains("greg") || names.contains("GREG")) {
            names.remove("Greg");
            names.remove("greg");
            names.remove("GREG");
        }

        for(int index = names.size() -1; index >= 0; index -- ) {
            if(names.get(index).equalsIgnoreCase("Greg")) {
                names.remove(index);
            }
        }

        System.out.println("Size after remove:" + names.size());

        /*
            Advantage: Easier to write, less details to manage
            Limitations: Always have to increment through each value, cannot specify to skip anything, cannot update anything because it is essentially read only
         */
        for(String name : names) {
            System.out.println(name);
        }

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Christopher", 37, ""));
        employees.add(new Employee("Anthony", 25, "anthony@techelevator.com"));

        System.out.println("Employees:");
        for(Employee e : employees) {
            System.out.println(e.getName());
        }
        /* Employee e : employees is doing the below functionality:

         */
        for(int index = 0; index < employees.size(); index++) {
            Employee e = employees.get(index);
        }

        //autoboxing and unboxing
        List<Integer> myNumbers = new ArrayList<>();
        myNumbers.add(5);
        myNumbers.add(99);

        int myNum = myNumbers.get(0);


        // how to filter based on condition
        int[] numbers = {99, 90, 80, 70, 10, 2, 92, 66};
        List<Integer> numbersOver90 = new ArrayList<>();

        for(int num : numbers) {
            if(num >= 90) {
                numbersOver90.add(num);
                System.out.println("Found num " + num);
            } else {
                System.out.println("Ignoring num " + num);
            }
        }

        // or use it to exclude
        List<String> newNames = new ArrayList<String>();
        for(String name : names) {
            if (!name.equalsIgnoreCase("greg")) {
                newNames.add(name);
            }
        }

    }
}
