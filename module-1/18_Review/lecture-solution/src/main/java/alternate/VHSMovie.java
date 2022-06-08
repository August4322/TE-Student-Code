package alternate;

import java.math.BigDecimal;

public class VHSMovie extends MovieRental{
    @Override
    public BigDecimal getRentalPrice() {
        BigDecimal price = new BigDecimal(".99");

        return isPremium() ? price.add(new BigDecimal("1.00")) : price;
    }
}
