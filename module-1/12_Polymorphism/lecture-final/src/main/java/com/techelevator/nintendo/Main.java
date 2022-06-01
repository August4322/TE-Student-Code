package com.techelevator.nintendo;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        VideoGameCharacter mario = new Mario();
        Luigi luigi = new Luigi();
        PrincessPeach peach = new PrincessPeach();

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

        boolean pressRight = true;
        boolean pressA = true;

/*
        if(pressRight && pressA) {
            for(VideoGameCharacter character : characters) {

                //we can only call methods that exist in the VideoGameCharacter class
                character.run();

                //Mario and Luigi only inherit Jump, they don't implement it themselves. But we can still use it.
                character.jump();

                //if we want to do something specific per child class
                //we can use instanceof and then cast to that class
                if(character instanceof Mario) {
                    Mario m = (Mario)character;
                    m.setFlower(true);
                }
            }
        }
        */
        boolean pressB = true;

        /*
        // jumping
        if(pressB) {
            for(VideoGameCharacter character : characters) {
                character.jump();
                if(character instanceof Hoverable) {
                    Hoverable h = (Hoverable) character;
                    h.hover();
                }
            }
        }

         */

        System.out.println(luigi.toString());
        System.out.println(mario.toString());

        List<Object> list = new ArrayList<>();
        list.add("String");
        list.add(2.0);
        list.add(1);
        list.add(true);




    }
}
