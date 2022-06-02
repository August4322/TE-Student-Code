package com.techelevator.nintendo;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        VideoGameCharacter mario = new Mario();
        Luigi luigi = new Luigi();
        PrincessPeach peach = new PrincessPeach();

        /*
        NOTES FOR MANAGING INHERITANCE:
        1. PROTECTED - if a method or property is protected, it is accessible from any descendant that inherits from that class OR any other class that
                       is in the same package. Notice below I can call the protected doSecretMove() from my current Main class because we are in the
                       same package. If I try to do this in OldMacdonald in the com.techelevator.farm package, it is not allowed.  However, regardless
                       what package I am in, if I inherit from VideoGameCharacter, I will have access to doSecretMove in my extending class. For instance,
                       look at Yoshi in com.techelevator.farm
         */
        mario.doSecretMove();

        /*
            You can inherit from / extend classes indefinitely as long as the parent class is not final
            ArrayList is not final, so we can extend it - take a look at AdamArrayList in com.techelevator.farm
            But - for instance - the String type is final, and cannot be extended
         */



        List<Runnable> runners = new ArrayList<>();
        runners.add(mario);
        runners.add(luigi);
        runners.add(peach);

        List<Hoverable> hoverables = new ArrayList<>();
        hoverables.add(luigi);
        hoverables.add(peach);

        List<VideoGameCharacter> characters = new ArrayList<>();
        characters.add(mario);
        characters.add(luigi);
        characters.add(peach);





    }
}
