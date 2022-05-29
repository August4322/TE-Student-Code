package com.techelevator;

import java.lang.reflect.Constructor;

public class Elevator {

    //Instance Variables
    private int currentFloor = 1;
    private int numberOfFloors;
    private boolean doorOpen;

    //Constructor
    public Elevator(int numberOfLevels) {
        this.numberOfFloors = numberOfLevels;
    }

    //Getters
    public int getCurrentFloor() {
        return currentFloor;
    }
    public int getNumberOfFloors() {
        return numberOfFloors;
    }
    public boolean isDoorOpen() {
        return doorOpen;
    }

    //Methods
    public void openDoor() {
        doorOpen = true;
    }

    public void closeDoor() {
        doorOpen = false;
    }

    public void goUp(int desiredFloor) {
        if (!doorOpen && desiredFloor <= numberOfFloors && desiredFloor > currentFloor) {
            currentFloor = desiredFloor;
        }
    }

    public void goDown(int desiredFloor) {
        if (!doorOpen && desiredFloor >= 1 && desiredFloor < currentFloor) {
            currentFloor = desiredFloor;
        }
    }
}
