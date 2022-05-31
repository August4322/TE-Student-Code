package com.techelevator.superhero;

public class Thor extends Avenger{

    private boolean hasHammer;
    private String motto;

    public Thor(String name, boolean hasHammer, String motto) {
        super(name);
        this.motto = motto;
        this.hasHammer = hasHammer;
    }

    @Override
    public String declareMotto() {

        String original = super.declareMotto();

        return original + motto;
    }
}
