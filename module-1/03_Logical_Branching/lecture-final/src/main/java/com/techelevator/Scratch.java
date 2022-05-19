package com.techelevator;

public class Scratch {

    //method:
    // access modifier | return type | name | parameters
    public static int addTogether(int num1, int num2) {

        return num1 + num2;
    }

    public static void sayHello() {
        System.out.println("Hello World!");
    }

    public static void main(String[] args) {

        // expressions (no matter how long) resolve to one value

        boolean result = 3 > 4; // false
        boolean result2 = 5 < 10; // true
        boolean result3 = 7 <= 10; //true
        boolean result4 = 10 >= 7; // true
        boolean result5 = 10 == 10; // true
        boolean result6 = 10 != 7; //true

        boolean myBoolean = true;
        System.out.println(myBoolean);
        System.out.println(!myBoolean);

        // AND &&
        System.out.println(true && true); // true
        System.out.println(true && false); // false

        // OR ||
        System.out.println(true || true); // true
        System.out.println(true || false); // true
        System.out.println(false || false); /// false

        /*
        sayHello();

        int sum = addTogether(2,3);
        System.out.println(sum);

        int sum2 = addTogether(3,3);
        System.out.println(sum2);

        int sum3 = addTogether(4,3);
        System.out.println(sum3);

        int sum4 = addTogether(5,3);
        System.out.println(sum4);

        {
            String spiderman = "tobey";
            System.out.println(spiderman);

            {
               // String spiderman = "andrew";

            }
        }

        {
            String spiderman = "andrew";
            System.out.println(spiderman);
        }

        {
            String spiderman = "tom";
            System.out.println(spiderman);
        }
        */

        /*
        regarding nested blocks, can an innermost nested block (a block nested within another nest) access variables from the outermost block? In other words, can an inner block always access an outer block

         */

        /*
        boolean areAllLessThan = (1 < 5) && (3 < 4);
        System.out.println(areAllLessThan);

        int x = 5 + 4 + 3 * 2 / 2;

        double result = (double)5/3;
        System.out.println(result);

        double startingMoney = 10d;
        System.out.println(startingMoney);

        double percent = 70d/80;
        System.out.println(percent);
        int wholePercent = (int)((70d/80) * 100);
        System.out.println(wholePercent);


        double division = 10d/3; // result of division
        System.out.println(division);
        double mod = 10 % 2; // remainder
        System.out.println(mod);


        */

    }
}
