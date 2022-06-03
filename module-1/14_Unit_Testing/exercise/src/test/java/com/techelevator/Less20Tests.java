package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Less20Tests {

    //Instance Variable
    private Less20 lessTwenty;

    @Before
    public void setup() {
        lessTwenty = new Less20();
    }

    @Test
    public void number_is_two_less_than_multiple_of_twenty () {
        //Arrange
        int number = 18;
        //Act
        boolean result = lessTwenty.isLessThanMultipleOf20(number);
        //Assert
        Assert.assertEquals(true, result);
    }

    @Test
    public void number_is_one_less_than_multiple_of_twenty () {
        //Arrange
        int number = 19;
        //Act
        boolean result = lessTwenty.isLessThanMultipleOf20(number);
        //Assert
        Assert.assertEquals(true, result);
    }

    @Test
    public void number_is_a_multiple_of_twenty () {
        //Arrange
        int number = 20;
        //Act
        boolean result = lessTwenty.isLessThanMultipleOf20(number);
        //Assert
        Assert.assertEquals(false, result);
    }
}
