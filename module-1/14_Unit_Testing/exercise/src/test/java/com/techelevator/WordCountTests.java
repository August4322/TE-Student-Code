package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class WordCountTests {

    //Instance Variables
    private WordCount wordCount;

    @Before
    public void setup() {
        wordCount = new WordCount();
    }

    @Test
    public void does_word_count() {
        //Arrange
        String[] arrayOfWords = {"boo", "I", "am", "a", "boo", "spooky", "ghost", "boo", "spooky", "boo"};
        Map<String, Integer> expectedMap = new HashMap<>();
            expectedMap.put("boo", 4);
            expectedMap.put("I", 1);
            expectedMap.put("am", 1);
            expectedMap.put("a", 1);
            expectedMap.put("spooky", 2);
            expectedMap.put("ghost", 1);
        //Act
        Map<String, Integer> result = wordCount.getCount(arrayOfWords);
        //Assert
        Assert.assertEquals(expectedMap, result);
    }


}
