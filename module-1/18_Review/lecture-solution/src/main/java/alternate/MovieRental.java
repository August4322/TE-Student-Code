package alternate;

import java.math.BigDecimal;
import java.math.RoundingMode;

public abstract class MovieRental {

    // constants
    public static final String VHS = "VHS";
    public static final String DVD = "DVD";
    public static final String BLURAY = "BLURAY";

    private String title;
    private String format;
    private boolean isPremiumMovie;

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

    public abstract BigDecimal getRentalPrice();

}
