package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class ShapeTests {

    private RectangleBlock block;

    @Before
    public void runFirst() {
        block  = new RectangleBlock("Rectangle",1,1,1);
    }

    @Test
    public void test_volume_of_rectangle(){

        //Act - where we are running the code that we want to test and storing the result
        int volume = block.getVolume();

        //Assert - where we take the result from act, and compare it to what we expect it should be
        Assert.assertEquals("Volume should be 1", 1, volume);
    }

    @Test
    public void test_depth_of_rectangle(){

        //Act - where we are running the code that we want to test and storing the result
        int result = block.getDepth();

        //Assert - where we take the result from act, and compare it to what we expect it should be
        Assert.assertEquals("Depth should be 1", 1, result);
    }

    @Test
    public void test_width_of_rectangle(){

        //Act - where we are running the code that we want to test and storing the result
        int result = block.getWidth();

        //Assert - where we take the result from act, and compare it to what we expect it should be
        Assert.assertEquals("Width should be 1", 1, result);
    }

    @Test
    public void test_height_of_rectangle(){

        //Act - where we are running the code that we want to test and storing the result
        int result = block.getHeight();

        //Assert - where we take the result from act, and compare it to what we expect it should be
        Assert.assertEquals("Height should be 1", 1, result);
    }
}
