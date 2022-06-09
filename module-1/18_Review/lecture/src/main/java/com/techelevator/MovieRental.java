package com.techelevator;

import java.math.BigDecimal;

public class MovieRental {

    //Constants
    public static final String VHS = "VHS";
    public static final String DVD = "DVD";
    public static final String BLURAY = "Blu-ray";

    //Instance Variables
    private String title;
    private String format;
    private boolean isPremiumMovie;

    //Getters
    public String getTitle() {
        return title;
    }
    public String getFormat() {
        return format;
    }
    public boolean isPremiumMovie() {
        return isPremiumMovie;
    }
    public BigDecimal getRentalPrice() {

        BigDecimal price = new BigDecimal("0.00");
        //BigDecimal price = BigDecimal.valueOf(0.00); (Can use this, not preferred)

        if (format.equals(VHS)) {
            price = new BigDecimal("0.99");
        } else if (format.equals(DVD)) {
            price = new BigDecimal("1.99");
        } else if (format.equals(BLURAY)) {
            price = new BigDecimal("2.99");
        }

        if (isPremiumMovie) {
            price = price.add(new BigDecimal("1.00"));
        }
        return price;
    }

    //Constructors
    public MovieRental (String title, String format, boolean isPremiumMovie) {
        this.title = title;
        this.format = format;
        this.isPremiumMovie = isPremiumMovie;
    }

    //Methods
    public BigDecimal daysLate(int daysLate) {
        if (daysLate >= 3) {
           return new BigDecimal("19.99");
        } else if (daysLate == 2) {
            return new BigDecimal("3.99");
        } else if (daysLate == 1) {
            return new BigDecimal("1.99");
        } else return new BigDecimal("0.00");
    }

    @Override
    public String toString() {
        return "MOVIE - " + getTitle() + " - " + getFormat() + " " + getRentalPrice();
    }

}
