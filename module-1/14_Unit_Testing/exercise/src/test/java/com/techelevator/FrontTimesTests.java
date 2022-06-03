package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FrontTimesTests {

    //Instance Variables
    private FrontTimes frontTimes;

    @Before
    public void setup() {
        frontTimes = new FrontTimes();
    }

    @Test
    public void does_the_method_grab_the_first_three_chars_and_repeat_three () {
        //Arrange
        String string = "Red";
        int n = 2;
        //Act
        String result = frontTimes.generateString(string, n);
        //Assert
        Assert.assertEquals("RedRed", result);
    }

    @Test
    public void does_the_method_grab_the_first_three_chars_and_repeat_more_than_three () {
        //Arrange
        String string = "Chocolate";
        int n = 3;
        //Act
        String result = frontTimes.generateString(string, n);
        //Assert
        Assert.assertEquals("ChoChoCho", result);
    }

    @Test
    public void does_the_method_grab_the_first_three_chars_and_repeat_less_than_three () {
        //Arrange
        String string = "no";
        int n = 4;
        //Act
        String result = frontTimes.generateString(string, n);
        //Assert
        Assert.assertEquals("nononono", result);
    }

}
