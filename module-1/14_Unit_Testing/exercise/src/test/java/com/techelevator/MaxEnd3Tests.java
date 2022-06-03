package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MaxEnd3Tests {

    //Instance Variables
    private MaxEnd3 maxEndThree;

    @Before
    public void setup() {
        maxEndThree = new MaxEnd3();
    }

    @Test
    public void does_look_at_ends_see_which_is_bigger_give_all_threes () {
        //Arrange
        int[] arrayOfNumbers = {1, 2, 3};
        int[] expected = {3, 3, 3};
        //Act
        int[] result = maxEndThree.makeArray(arrayOfNumbers);
        //Assert
        Assert.assertArrayEquals(expected, result);
    }

    @Test
    public void does_look_at_ends_see_which_is_bigger_give_all_elevens () {
        //Arrange
        int[] arrayOfNumbers = {11, 5, 9};
        int[] expected = {11, 11, 11};
        //Act
        int[] result = maxEndThree.makeArray(arrayOfNumbers);
        //Assert
        Assert.assertArrayEquals(expected, result);
    }

    @Test
    public void does_look_at_ends_see_which_is_bigger_give_all_nines () {
        //Arrange
        int[] arrayOfNumbers = {2, 11, 9};
        int[] expected = {9, 9, 9};
        //Act
        int[] result = maxEndThree.makeArray(arrayOfNumbers);
        //Assert
        Assert.assertArrayEquals(expected, result);
    }
}
