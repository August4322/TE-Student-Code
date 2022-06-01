package com.techelevator.nintendo;

public class PrincessPeach extends VideoGameCharacter implements Hoverable {

    public PrincessPeach() {
        super("Princess Peach");
    }

    @Override
    public void hover() {
        // this code block is the implementation that the interface requires
        System.out.println("I am Princess Peach and I'm hovering");
    }
}
