package com.techelevator;

import com.techelevator.superhero.*;

public class Scratch {

    public static void main(String[] args) {


        Thor thor = new Thor("Thor", false, " I am the mighty Thor!");
        System.out.println(thor.declareMotto());

       // System.out.println("IS Thor an avenger? " + (thor instanceof Avenger));

       // System.out.println("My String" instanceof String);

       // System.out.println("IS Thor an Object? " + (thor instanceof Object));



      //  System.out.println(Avenger.TAGLINE);

        Avenger ironMan = new Avenger();
        ironMan.setName("Iron Man");

/*
        Power power = new Power("Super Technology", "A billion dollars buys a lot");
        ironMan.setPower(power);

        System.out.println(ironMan.getName() + ":" + ironMan.getPower().getName().toUpperCase());


        Avenger blackWidow = new Avenger();
        blackWidow.setName("Black Widow");
       // System.out.println(blackWidow.getName());

       // Math.PI
*/
    }
}
