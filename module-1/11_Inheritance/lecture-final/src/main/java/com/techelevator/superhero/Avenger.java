package com.techelevator.superhero;

public class Avenger {

    public static final String TAGLINE = "Earth's mightiest heroes";

    private String name;
    private Power power;

    public Avenger() {

    }

    public Avenger(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Power getPower() {
        return power;
    }

    public void setPower(Power power) {
        this.power = power;
    }

    public String declareMotto() {

        return "If we cannot save the Earth - then we will avenge it!";
    }

    // protected means that my children can see this and use it, but no one else
    protected void userPower() {

    }

}
