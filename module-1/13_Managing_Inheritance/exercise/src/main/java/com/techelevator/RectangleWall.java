package com.techelevator;

public class RectangleWall extends Wall {

    //Instance Variables
    private int length;
    private int height;

    //Constructor
    public RectangleWall(String name, String color, int length, int height) {
        super(name, color);
        this.length = length;
        this.height = height;
    }

    //Getters
    public int getLength() {
        return length;
    }
    public int getHeight() {
        return height;
    }

    //Methods
    @Override
    public int getArea() {
        return length * height;
    }

    @Override
    public String toString() {
        return getName() + " (" + length + "x" + height + ") rectangle";
    }
}
