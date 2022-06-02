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

        /********************** PREVENTING INHERITANCE *****************************
        2. FINAL - You can inherit from / extend classes indefinitely as long as the parent class is not final
                    ArrayList is not final, so we can extend it - take a look at AdamArrayList in com.techelevator.farm
                    But - for instance - the String type is final, and cannot be extended.
                    Example: SlimMario is final, and MGMario cannot extend the class

                    We can also make individual methods final. See public final void doExclusiveMarioMove() in Mario vs LittleMario.
                    But we can still use it
         */
        LittleMario lm = new LittleMario();
        lm.doExclusiveMarioMove();

        /*************************** REQUIRE INHERITANCE ****************************
         *  3. ABSTRACT - similar to interfaces, we expect a concrete class to provide an implementation.
         *                If we make a class abstract we cannot instantiate it. It can only be inherited

                        We can also apply it to methods. every class that inherits from VideoGameCharacter
                        has to provide an implementation for doSpecialMove();

                        If any class has an abstract method the class itself has to be declared as abstract
         */

        // this doesn't work because VideoGameCharacter is abstract
       // VideoGameCharacter myCharacter = new VideoGameCharacter("");

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

        for(VideoGameCharacter character : characters) {
            character.doSpecialMove();
        }




    }
}
