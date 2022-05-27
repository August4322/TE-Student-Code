package com.techelevator.startrek;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        WarpDrive drive = new WarpDrive(250, 10 );

        Starship enterprise = new Starship(drive, "Battle", 3500, "C");

        List<CrewMember> crew = new ArrayList<>();
        crew.add(new CrewMember("Jean Luc Picard", "Captain"));
        crew.add(new CrewMember("Worf", "Head of Security"));
        crew.add(new CrewMember("Beverly Crusher", "Chief Medical Officer"));

        enterprise.setCrew(crew);

        enterprise.fly();
    }
}
