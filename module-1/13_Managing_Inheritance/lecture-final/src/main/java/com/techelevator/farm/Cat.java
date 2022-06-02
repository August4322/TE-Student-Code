package com.techelevator.farm;

public final class Cat extends FarmAnimal implements Singable{

    public Cat() {
        super("Cat", "meow!");
    }

    public void eat() {
        System.out.println("I eat mice");
    }
}
