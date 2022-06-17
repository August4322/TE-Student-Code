package com.techelevator;

import java.time.LocalDateTime;

public class Car {

    //Instance Variables
    int currentYear = LocalDateTime.now().getYear();
    private int year;
    private String make;
    private boolean isClassicCar;
    private int age = (currentYear - year);

    //Constructor
    public Car(int year, String make, boolean isClassicCar) {
        this.year = year;
        this.make = make;
        this.isClassicCar = isClassicCar;
    }

    //Getters
    public int getCurrentYear() {
        return currentYear;
    }

    public int getYear() {
        return year;
    }

    public String getMake() {
        return make;
    }

    public int getAge() {
        return (currentYear-year);
    }

    public boolean isClassicCar() {
        return isClassicCar;
    }

    //Setters
    public void setYear(int year) {
        this.year = year;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setClassicCar(boolean classicCar) {
        isClassicCar = classicCar;
    }

    public void setAge(int age) {
        this.age = age;
    }

    //Methods
    public boolean isYearToCheck(int yearToCheck) {
        if (isClassicCar) {
            return false;
        } else if (age < 4 || age > 25) {
            return false;
        } else if (currentYear %2 == 0) {
            if (year %2 == 0) {
                return true;
            } else if (year %2 == 1) {
                return false;
            }
        } else if (currentYear %2 == 1) {
            if (year %2 == 1) {
                return true;
            } else if (year %2 == 0) {
                return false;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "CAR - " + year + " - " + make;
    }
}


