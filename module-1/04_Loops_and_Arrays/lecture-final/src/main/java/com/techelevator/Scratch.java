package com.techelevator;

public class Scratch {

    public static String turn(boolean left) {

        //ternary
        // condition ? value if true : value if false;
        return left ? "left" : "right";

        /*
        if ( left ) {
            return "left";
        }

        return "right";
        */
    }

    public static int[] createIntArray(int size) {
        int[] arr = new int[size];
        return arr;
    }


    /*

        1. Eggs
        2. Milk
        3. Bread
        4. Oranges
        5. Garlic

     */


    public static void main(String[] args) {


        /*
        These are all the same:
        i=i+1;
        i+=1;
        i++;

        These are all the same too:
        i=i-1;
        i-=1;
        i--;
         */

        int[] numbers = new int[10];
        for(int i = 0; i < numbers.length; i++) {

            numbers[i] = i+1;
        }

        //   init index                  condition
        for(int j = numbers.length - 1; j >= 0; j--) {
            // check if number is even. If we % 2, and even number will have no remainder
            if((numbers[j] % 2) == 0) {
                System.out.println(numbers[j]);
            }
        }

        /*
        String name = "Christopher";
        String name2 = "Anthony";
        String name3 = "Ugur";
        String name4 = "Abigail";

       // String[] names = {"Christopher", "Anthony", "Ugur", "Abigail", "Seth", "Caitlin"};
        String[] names = new String[25];

        //to access the first element
        names[0] = "Christopher";

        //to access any other elements use the appropriate index
        names[1] = "Anthony";
        names[2] = "Ugur";
        names[2] = "Mason";

        names[14] = "Caitlin";
        names[9] = "Evan";

        // to access the last element
        names[names.length - 1] = "Cesar";

        System.out.println("****************************");
        //   init index  ; condition to stop;       how we increment
        for(int index = 0; index < names.length; index = index + 1) {
            System.out.println(names[index]);
        }
        System.out.println("****************************");




        int[] arr = {1,2,3,4};
        double[] arr2 = {1.0, 2.0, 3.0};

        int[] myArray1 = createIntArray(3);
        int[] myArray2 = createIntArray(100);


        String result = turn(true);
        System.out.println( result );

        System.out.println( turn(false) );

        char myFirstLetter = 'C';
        if(myFirstLetter == 'C') { // these are case sensitive
            System.out.println("Christopher");
        }
    */

    }
}
