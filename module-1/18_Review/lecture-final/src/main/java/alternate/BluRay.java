package alternate;

import java.math.BigDecimal;

public class BluRay extends MovieRental{
    @Override
    public BigDecimal getRentalPrice() {
        BigDecimal price = new BigDecimal("2.99");

        return isPremium() ? price.add(new BigDecimal("1.00")) : price;
    }
}
