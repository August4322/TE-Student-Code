package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CigarPartyTests {

    //Instance Variable
    private CigarParty cigarParty;

    @Before
    public void setup() {
        cigarParty = new CigarParty();
        }

    @Test
    public void party_has_enough_cigars_min_weekend () {
        //Arrange
        int cigarNumber = 40;
        //Act
        boolean result = cigarParty.haveParty(cigarNumber, true);
        //Assert
        Assert.assertEquals(true, result);
    }

    @Test
    public void party_has_enough_cigars_min_weekday () {
        //Arrange
        int cigarNumber = 40;
        //Act
        boolean result = cigarParty.haveParty(cigarNumber, false);
        //Assert
        Assert.assertEquals(true, result);
    }

    @Test
    public void party_has_enough_cigars_low_weekend() {
        //Arrange
        int cigarNumber = 20;
        //Act
        boolean result = cigarParty.haveParty(cigarNumber, true);
        //Assert
        Assert.assertEquals(false, result);
    }

    @Test
    public void party_has_enough_cigars_low_weekday() {
        //Arrange
        int cigarNumber = 20;
        //Act
        boolean result = cigarParty.haveParty(cigarNumber, false);
        //Assert
        Assert.assertEquals(false, result);
    }

    @Test
    public void party_has_enough_cigars_max_weekend() {
        //Arrange
        int cigarNumber = 60;
        //Act
        boolean result = cigarParty.haveParty(cigarNumber, true);
        //Assert
        Assert.assertEquals(true, result);
    }

    @Test
    public void party_has_enough_cigars_max_weekday() {
        //Arrange
        int cigarNumber = 60;
        //Act
        boolean result = cigarParty.haveParty(cigarNumber, false);
        //Assert
        Assert.assertEquals(true, result);
    }

    @Test
    public void party_has_enough_cigars_high_weekend() {
        //Arrange
        int cigarNumber = 80;
        //Act
        boolean result = cigarParty.haveParty(cigarNumber, true);
        //Assert
        Assert.assertEquals(true, result);
    }

    @Test
    public void party_has_enough_cigars_high_weekday() {
        //Arrange
        int cigarNumber = 80;
        //Act
        boolean result = cigarParty.haveParty(cigarNumber, false);
        //Assert
        Assert.assertEquals(false, result);
    }
}
