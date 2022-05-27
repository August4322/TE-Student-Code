package com.techelevator.startrek;

import java.util.ArrayList;
import java.util.List;

public class Starship {

    // properties
    private WarpDrive warpDrive;
    private String typeOfBridge;
    private DeflectorShield shield;

    private int accomodation;
    private String classification;

    private List<Utility> utilities;

    //default values
    private List<CrewMember> crew = new ArrayList<CrewMember>();

    // constructors - public, no return type, match the name of the class
    public Starship(WarpDrive warpDrive, String typeOfBridge, int accomodation, String classification ) {

        this.warpDrive = warpDrive;
        this.typeOfBridge = typeOfBridge;
        this.accomodation = accomodation;
        this.classification = classification;

        // default values
        shield = new DeflectorShield();
        utilities = new ArrayList<Utility>();

    }

    public List<CrewMember> getCrew() {
        return crew;
    }

    public void setCrew(List<CrewMember> crew){
        this.crew = crew;
    }

    public void fly() {
        System.out.println("We're flying through space!");
    }
}
