package com.techelevator;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class ScratchTests {

    private Scratch s;

    @Before
    public void mySetupMethod() {
        s = new Scratch();

    }

    @After
    public void destroy() {
        // close a database connection
        // close a file

    }

    @Test
    public void testing_array_is_123() {

        // Arrange - set up any variables that we need to run our test
        // Scratch s = new Scratch(); - doing this in the @Before method
        int[] expectedArray = {1,2,3};

        //Act - we run the code we want to test and store it in a result
        int[] result = s.get123();

        //Assert - we compare our result from the Act step to what we expected
        Assert.assertArrayEquals(expectedArray, result);

    }

    @Test
    public void testing_first_element_in_array_is_1() {

        // Arrange - set up any variables that we need to run our test
        // Scratch s = new Scratch(); - doing this in the @Before method
        int[] expectedArray = {1,2,3};

        //Act - we run the code we want to test and store it in a result
        int[] result = s.get123();

        //Assert - we compare our result from the Act step to what we expected
        Assert.assertEquals(expectedArray[0], result[0]);

    }

    @Test
    public void testing_map(){
        // Arrange
        Map<String,String> expectedMap = new HashMap<>();
        expectedMap.put("giraffe", "Tower");
        expectedMap.put("dog", "Pack");
       //expectedMap.put("elephant", "Herd");

        //Act
        Map<String, String> result = s.getMap();

        //Assert
        Assert.assertEquals(expectedMap, result);


    }
}
