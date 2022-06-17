package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class CarTests {

    @Test
    public void test_age_calculation() {
        //Arrange
        Car testCar = new Car(2018, "Honda Civic", false);
        //Act
        int result = testCar.getAge();
        //Assert
        Assert.assertEquals(4, result);
    }

    @Test
    public void test_e_check_method_classic_car_true() {
        //Arrange
        Car testCar = new Car(1965, "Ford Mustang", true);
        //Act
        boolean result = testCar.isYearToCheck(testCar.getYear());
        //Assert
        Assert.assertEquals(false, result);
    }

    @Test
    public void test_e_check_method_car_age_too_young() {
        //Arrange
        Car testCar = new Car(2020, "Honda Accord", false);
        //Act
        boolean result = testCar.isYearToCheck(testCar.getYear());
        //Assert
        Assert.assertEquals(false, result);
    }

    @Test
    public void test_e_check_method_car_age_just_right_odd() {
        //Arrange
        Car testCar = new Car(2015, "Honda Civic", false);
        //Act
        boolean result = testCar.isYearToCheck(testCar.getYear());
        //Assert
        Assert.assertEquals(false, result);
    }

    @Test
    public void test_e_check_method_car_age_just_right_even() {
        //Arrange
        Car testCar = new Car(2016, "Honda Civic", false);
        //Act
        boolean result = testCar.isYearToCheck(testCar.getYear());
        //Assert
        Assert.assertEquals(true, result);
    }
}
