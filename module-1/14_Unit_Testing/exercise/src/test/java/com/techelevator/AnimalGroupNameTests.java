package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AnimalGroupNameTests<agn> {

    //Instance Variable
    private AnimalGroupName agn;

    @Before
    public void setup() {
        agn = new AnimalGroupName();
    }

    @Test
    public void test_giraffe_returns_tower() {
        //Arrange

        //Act
        String result = agn.getHerd("giraffe");
        //Assert
        Assert.assertEquals("Tower", result);
    }

    @Test
    public void test_giraffe_with_caps_returns_tower() {
        //Arrange

        //Act
        String result = agn.getHerd("gIrAfFe");
        //Assert
        Assert.assertEquals("Tower", result);
    }

    @Test
    public void test_bigfoot_returns_unknown() {
        //Arrange

        //Act
        String result = agn.getHerd("bigfoot");
        //Assert
        Assert.assertEquals("unknown", result);
    }

    @Test
    public void test_null_returns_unknown() {
        //Arrange

        //Act
        String result = agn.getHerd(null);
        //Assert
        Assert.assertEquals("unknown", result);
    }

    @Test
    public void test_empty_returns_unknown() {
        //Arrange

        //Act
        String result = agn.getHerd("");
        //Assert
        Assert.assertEquals("unknown", result);
    }


}
