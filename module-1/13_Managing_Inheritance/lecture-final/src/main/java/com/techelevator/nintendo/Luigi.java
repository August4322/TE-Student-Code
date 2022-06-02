package com.techelevator.nintendo;

// You can only extend one class but you can implement many interfaces
public class Luigi extends VideoGameCharacter implements Hoverable, SuperJumpable{

    public Luigi() {
        super("Luigi");
    }

    @Override
    public void run() {
        System.out.println("It's a me a Luigi and I'm a running!");
    }

    public void hover() {
        System.out.println("I'm Luigi and I'm hovering");
    }

    public void superJump() {
        System.out.println("Super Jump!");
    }
}
