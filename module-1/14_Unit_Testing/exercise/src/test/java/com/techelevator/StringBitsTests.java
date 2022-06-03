package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StringBitsTests {

    //Instance Variables
    private StringBits stringBits;

    @Before
    public void setup() {
        stringBits = new StringBits();
    }

    @Test
    public void does_string_bits_create_substring_with_every_other_letter() {
        //Arrange
        String startingString = "People";
        //Act
        String result = stringBits.getBits(startingString);
        //Assert
        Assert.assertEquals("Pol", result);
    }



}
