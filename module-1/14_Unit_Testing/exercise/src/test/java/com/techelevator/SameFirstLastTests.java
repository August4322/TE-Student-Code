package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SameFirstLastTests {

    //Instance Variables
    private SameFirstLast sameFirstLast;

    @Before
    public void setup() {
        sameFirstLast = new SameFirstLast();
    }

    @Test
    public void does_the_first_and_last_equal_test_work_same () {
        //Arrange
        int[] arrayOfNumbers = {1, 4, 1};
        //Act
        boolean result = sameFirstLast.isItTheSame(arrayOfNumbers);
        //Assert
        Assert.assertEquals(true, result);
    }

    @Test
    public void does_the_first_and_last_equal_test_work_different () {
        //Arrange
        int[] arrayOfNumbers = {1, 4, 9};
        //Act
        boolean result = sameFirstLast.isItTheSame(arrayOfNumbers);
        //Assert
        Assert.assertEquals(false, result);
    }
}
