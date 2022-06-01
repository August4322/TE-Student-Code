package com.techelevator.farm;

//DO NOT EXTEND FARM ANIMAL - TRACTORS ARE NOT FARM ANIMALS
public class Tractor implements Audible {

    public String getName() {
        return "Tractor";
    }

    public String getSound() {
        return "Vroom";
    }

}
