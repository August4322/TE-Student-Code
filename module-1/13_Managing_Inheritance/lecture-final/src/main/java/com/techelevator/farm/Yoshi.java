package com.techelevator.farm;

import com.techelevator.nintendo.VideoGameCharacter;

import java.util.ArrayList;
import java.util.List;

public class Yoshi extends VideoGameCharacter {

    public Yoshi() {
        super("Yoshi");

        String name = "Christopher";
        List<String> list = new ArrayList<>();

        // Even tho Yoshi is not part of the nintendo package, because he is a direct descendant of
        // VideoGameCharacter he inherits all protected methods and properties
        this.doSecretMove();
    }
}
