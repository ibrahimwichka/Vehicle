package vehicle;
public abstract class ElectricCar extends Car {

    /**
     * Note: Car begins with a full charge (and thus range).
     * 
     * @throws IllegalArgumentException if milesOnMaxCharge is nonpositive.
     */
    private double milesOnMaxCharge;
    private double range;
    public ElectricCar(String make, String model, double startingOdometerValue, double milesOnMaxCharge) {
        super(make, model, startingOdometerValue);
        range = milesOnMaxCharge;
    }

    /**
     * Defaults startingOdometerValue to 0.
     * 
     * @throws IllegalArgumentException if milesOnMaxCharge is nonpositive.
     */
    public ElectricCar(String make, String model, double milesOnMaxCharge) {
        super(make, model);
        range = milesOnMaxCharge;
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
            throw new IllegalArgumentException("Miles input: " + miles + " is too low.");
        }
        if (miles > milesOnMaxCharge){
            throw new IllegalArgumentException("Miles input: " + miles + " is too high.");
        }
        // To Do
    }

    /**
     * Returns how many more miles the car can currently go without
     * recharging.
     */
    public double getRemainingRange() {
        return range;
    }

    /** Returns how many miles the car could go on a full charge. */
    public double getMaxRange() {
        return milesOnMaxCharge;
    }

    /** Recharges the car to max range capability. */
    public void recharge() {
        // ToDO
    }

    /**
     * Decreases the amount of energy in the battery based by the number
     * of miles passed as an argument.
     */
    protected void decreaseCharge(double miles) {
        // ToDo
    }

}