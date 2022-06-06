package com.techelevator.exceptions;

public class OrangeException extends Exception{

    int numStudents;

    public OrangeException(String message , int numStudents) {
        super(message);
        this.numStudents = numStudents;
    }

    public int getNumStudents() {
        return numStudents;
    }
}
