pubpackage com.techelevator.startrek;

public class WarpDrive {

    private int powerCapacity;
    private int maxCapability;

    //overloaded the constructors - named the same thing but accept different number of parameters
    public WarpDrive() {
        powerCapacity = 100;
        maxCapability = 9;
    }

    public WarpDrive(int powerCapacity, int maxCapability) {
        this.powerCapacity = powerCapacity;
        this.maxCapability = maxCapability;
    }

    public int getPowerCapacity() {
        return powerCapacity;
    }

    public int getMaxCapability() {
        return maxCapability;
    }
}
