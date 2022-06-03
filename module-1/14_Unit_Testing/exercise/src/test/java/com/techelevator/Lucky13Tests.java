package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Array;

public class Lucky13Tests {

    //Instance Variables
    private Lucky13 luckyThirteen;

    @Before
    public void setup() {
        luckyThirteen = new Lucky13();
    }

    @Test
    public void does_the_array_have_1_and_or_3_has_one () {
        //Arrange
        int[] arrayOfNumbers = {0, 1, 2};
        //Act
        boolean result = luckyThirteen.getLucky(arrayOfNumbers);
        //Assert
        Assert.assertEquals(false, result);
    }

    @Test
    public void does_the_array_have_1_and_or_3_has_three () {
        //Arrange
        int[] arrayOfNumbers = {3, 6, 2};
        //Act
        boolean result = luckyThirteen.getLucky(arrayOfNumbers);
        //Assert
        Assert.assertEquals(false, result);
    }

    @Test
    public void does_the_array_have_1_and_or_3_has_neither () {
        //Arrange
        int[] arrayOfNumbers = {0, 2, 4};
        //Act
        boolean result = luckyThirteen.getLucky(arrayOfNumbers);
        //Assert
        Assert.assertEquals(true, result);
    }



}
