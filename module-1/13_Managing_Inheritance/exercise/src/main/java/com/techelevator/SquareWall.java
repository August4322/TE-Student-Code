package com.techelevator;

public class SquareWall extends RectangleWall{

    //Instance Variables
    private int sideLength;

    //Constructors
    public SquareWall(String name, String color, int sideLength) {
        super(name, color, sideLength, sideLength);
        this.sideLength = sideLength;
    }

    //Getter
    public int getSideLength() {
        return sideLength;
    }

    //Methods
    @Override
    public String toString() {
        return getName() + " (" + sideLength + "x" + sideLength + ") square";
    }
}
