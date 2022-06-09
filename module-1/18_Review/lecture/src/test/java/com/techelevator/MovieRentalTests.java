package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MovieRentalTests {

    private MovieRental movieRental;

    @Before
    //Arrange
    public void setMovie() {

    }

    @Test
    public void test_rental_price_VHS_not_premium() {
        //Arrange
        movieRental = new MovieRental("Jaws", MovieRental.VHS, false);
        //Act
        String result = String.valueOf(movieRental.getRentalPrice());
        //Assert
        Assert.assertEquals("0.99", result);
    }

    @Test
    public void test_rental_price_DVD_not_premium() {
        //Arrange
        movieRental = new MovieRental("Jaws", MovieRental.DVD, false);
        //Act
        String result = String.valueOf(movieRental.getRentalPrice());
        //Assert
        Assert.assertEquals("1.99", result);
    }

    @Test
    public void test_rental_price_BLURAY_premium() {
        //Arrange
        movieRental = new MovieRental("Jaws", MovieRental.BLURAY, true);
        //Act
        String result = String.valueOf(movieRental.getRentalPrice());
        //Assert
        Assert.assertEquals("3.99", result);
    }

    @Test
    public void test_days_late_is_0() {
        //Arrange
        movieRental = new MovieRental("Jaws", MovieRental.VHS, false);
        //Act
        String result = String.valueOf(movieRental.daysLate(0));
        //Assert
        Assert.assertEquals("0.00", result);
    }

    @Test
    public void test_days_late_is_1() {
        //Arrange
        movieRental = new MovieRental("Jaws", MovieRental.VHS, false);
        //Act
        String result = String.valueOf(movieRental.daysLate(1));
        //Assert
        Assert.assertEquals("1.99", result);
    }

    @Test
    public void test_days_late_is_2() {
        //Arrange
        movieRental = new MovieRental("Jaws", MovieRental.VHS, false);
        //Act
        String result = String.valueOf(movieRental.daysLate(2));
        //Assert
        Assert.assertEquals("3.99", result);
    }

    @Test
    public void test_days_late_is_3() {
        //Arrange
        movieRental = new MovieRental("Jaws", MovieRental.VHS, false);
        //Act
        String result = String.valueOf(movieRental.daysLate(3));
        //Assert
        Assert.assertEquals("19.99", result);
    }
}
