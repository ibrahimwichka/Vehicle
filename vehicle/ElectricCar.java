package vehicle;
public abstract class ElectricCar extends Car {

    /**
     * Note: Car begins with a full charge (and thus range).
     * 
     * @throws IllegalArgumentException if milesOnMaxCharge is nonpositive.
     */
    private double milesOnMaxCharge;
    private double rem_range;

    public ElectricCar(String make, String model, double startingOdometerValue, double milesOnMaxCharge) {
        super(make, model, startingOdometerValue);
        this.milesOnMaxCharge = milesOnMaxCharge;
        rem_range = milesOnMaxCharge;
    }

    /**
     * Defaults startingOdometerValue to 0.
     * 
     * @throws IllegalArgumentException if milesOnMaxCharge is nonpositive.
     */
    public ElectricCar(String make, String model, double milesOnMaxCharge) {
        super(make, model);
        this.milesOnMaxCharge = milesOnMaxCharge;
        rem_range = milesOnMaxCharge;
    }

    /**
     * Drives the full given number of miles.
     * 
     * @throws IllegalArgumentException if miles is negative.
     * @throws IllegalArgumentException if miles is too high given the
     *                                  current charge.
     */
    public void drive(double miles) {
        if (miles < 0){
            throw new IllegalArgumentException("Miles input: " + miles + " is negative");
        }
        if (miles > rem_range){
            throw new IllegalArgumentException("Miles input: " + miles + " is too high.");
        }
        if (canDrive(miles)) {
            addMiles(miles);
            decreaseCharge(miles);
        }
    }

    /**
     * Returns how many more miles the car can currently go without
     * recharging.
     */
    public double getRemainingRange() {
        return rem_range;
    }

    /** Returns how many miles the car could go on a full charge. */
    public double getMaxRange() {
        return milesOnMaxCharge;
    }

    /** Recharges the car to max range capability. */
    public void recharge() {
        rem_range = milesOnMaxCharge;
    }

    /**
     * Decreases the amount of energy in the battery based by the number
     * of miles passed as an argument.
     */
    protected void decreaseCharge(double miles) {
        rem_range -=miles;
    }

}