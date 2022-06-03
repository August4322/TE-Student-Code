package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DateFashionTests {

    //Instance Variable
    private DateFashion dateFashion;

    @Before
    public void setup() {
        dateFashion = new DateFashion();
    }

    @Test
    public void is_the_couple_stylish_enough_zero () {
        //Arrange
        int you = 1;
        int date = 8;
        //Act
        int result = dateFashion.getATable(you, date);
        //Assert
        Assert.assertEquals(0, result);
    }

    @Test
    public void is_the_couple_stylish_enough_one () {
        //Arrange
        int you = 5;
        int date = 5;
        //Act
        int result = dateFashion.getATable(you, date);
        //Assert
        Assert.assertEquals(1, result);
    }

    @Test
    public void is_the_couple_stylish_enough_two () {
        //Arrange
        int you = 5;
        int date = 8;
        //Act
        int result = dateFashion.getATable(you, date);
        //Assert
        Assert.assertEquals(2, result);
    }

}
