package com.techelevator.superhero;

public class Power {

    private String name;
    private String desc;

    // access modifier and then the name of the class and any parameters
    // there is no return type
    public Power(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public Power(String name) {
        this.name = name;
        this.desc = "";
    }

    public String getName() {
        return name;
    }
}
