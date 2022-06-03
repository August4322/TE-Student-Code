package com.techelevator;

import com.techelevator.MaxEnd3;
import com.techelevator.NonStart;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class NonStartTests {

    //Instance Variables
    private NonStart nonStart;

    @Before
    public void setup() {
        nonStart = new NonStart();
    }

    @Test
    public void does_non_start_work_with_regular_strings() {
        //Arrange
        String firstString = "Spicy";
        String secondString = "Touch";
        //Act
        String result = nonStart.getPartialString(firstString, secondString);
        //Assert
        Assert.assertEquals("picyouch", result);
    }

    @Test
    public void does_non_start_work_with_null() {
        //Arrange
        String firstString = null;
        String secondString = null;
        //Act
        String result = nonStart.getPartialString(firstString, secondString);
        //Assert
        Assert.assertEquals("", result);
    }

    @Test
    public void does_non_start_work_with_a_null_and_a_string() {
        //Arrange
        String firstString = null;
        String secondString = "Touch";
        //Act
        String result = nonStart.getPartialString(firstString, secondString);
        //Assert
        Assert.assertEquals("ouch", result);
    }

    @Test
    public void does_non_start_work_with_a_string_and_a_null() {
        //Arrange
        String firstString = "Spicy";
        String secondString = null;
        //Act
        String result = nonStart.getPartialString(firstString, secondString);
        //Assert
        Assert.assertEquals("picy", result);
    }

}
