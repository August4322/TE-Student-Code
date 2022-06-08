package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class MovieRentalTests {

    @Test
    public void test_rental_1_day_late(){
        //arrange
        MovieRental movie = new MovieRental("Test",MovieRental.DVD, false);

        //act
        BigDecimal result = movie.getLateFee(1);

        //assert
        Assert.assertEquals(new BigDecimal("1.99"), result);
    }
}
