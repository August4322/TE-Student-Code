package com.techelevator;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MovieRental {

    // constants
    public static final String VHS = "VHS";
    public static final String DVD = "DVD";
    public static final String BLURAY = "BLURAY";

    private String title;
    private String format;
    private boolean isPremiumMovie;

    public MovieRental(String title, String format, boolean isPremiumMovie) {
        this.title = title;
        this.format = format;
        this.isPremiumMovie = isPremiumMovie;
    }

    //methods:
    //access modifier, return data type, the name of the method, and parentheses that
    //will include any parameters that we are passing in
    public String getTitle() {
        return title;
    }

    public String getFormat() {
        return format;
    }

    public boolean isPremium() {
        return isPremiumMovie;
    }

    public BigDecimal getRentalPrice() {

        // There are a couple ways to initialize big decimal
        BigDecimal price = new BigDecimal("0.00");
        //BigDecimal price = BigDecimal.valueOf(3.5);

        if(format.equals(VHS)) {
            price = new BigDecimal("0.99");
        } else if (format.equals(BLURAY)) {
            price = new BigDecimal("2.99");
        } else if(format.equals(DVD)) {
            price = new BigDecimal("1.99");
        }

        if(isPremiumMovie) {
            price = price.add(new BigDecimal("1.00")) ;
        }

        return price;

        // EXAMPLE: force how many decimals to keep (2) and how to round
        // return price.setScale(2, RoundingMode.UP);
    }

    public BigDecimal getLateFee(int daysLate) {
        BigDecimal lateFee = new BigDecimal("0.00");

        if(daysLate == 0) {
            //do nothing
        } else if (daysLate == 1) {
            lateFee = new BigDecimal("1.99");
        } else if(daysLate ==2) {
            lateFee = new BigDecimal("3.99");
        } else if (daysLate >= 3) {
            lateFee = new BigDecimal("19.99");
        }

        return lateFee;
    }

    @Override
    public String toString() {
        return "MOVIE - " + title + " - " + format + " " + getRentalPrice();
    }

}
