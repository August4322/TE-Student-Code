package alternate;

import java.math.BigDecimal;

public class DVDMovie extends MovieRental{
    @Override
    public BigDecimal getRentalPrice() {
        BigDecimal price = new BigDecimal("1.99");

        return isPremium() ? price.add(new BigDecimal("1.00")) : price;
    }

    @Override
    public String toString() {
        return "MOVIE - " + getTitle() + " - " + getFormat() + " " + getRentalPrice();
    }
}
