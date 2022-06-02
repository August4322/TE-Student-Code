package com.techelevator.nintendo;

public final class SlimMario extends VideoGameCharacter{

    public SlimMario() {
        super("Slim Mario");
    }

    @Override
    public String toString() {
        return "No matter how many other super plumbers are in the sea it would feel so empty without me";
    }

    @Override
    public void doSpecialMove() {
        System.out.println("Mario special move");
    }
}
