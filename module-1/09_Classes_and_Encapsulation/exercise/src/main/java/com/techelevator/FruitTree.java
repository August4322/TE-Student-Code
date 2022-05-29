package com.techelevator;

public class FruitTree {

    //Instance variables
    private String typeOfFruit;
    private int piecesOfFruitLeft;

    //Constructor
    public FruitTree(String typeOfFruit, int piecesOfFruitLeft) {
        this.typeOfFruit = typeOfFruit;
        this.piecesOfFruitLeft = piecesOfFruitLeft;
    }

    //Getters
    public String getTypeOfFruit() {
        return typeOfFruit;
    }
    public int getPiecesOfFruitLeft() {
        return piecesOfFruitLeft;
    }

    //Method
    public boolean pickFruit(int numberOfPiecesToRemove) {
        if (numberOfPiecesToRemove <= piecesOfFruitLeft) {
            piecesOfFruitLeft -= numberOfPiecesToRemove;
            return true;
        } else {
            return false;
        }
    }
}
