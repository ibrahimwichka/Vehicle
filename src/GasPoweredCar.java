package src;
public abstract class GasPoweredCar extends Car {
    /**
     * Note: Start with a full tank of gas
     * 
     * @throws IllegalArgumentException if mpg or fuelCapacityGallons are
     *                                  non-positive.
     */
    private double mpg;
    private double fuelLevel;
    private double fuelCapacityGallons;

    public GasPoweredCar(String make, String model, double startingOdometerValue, double mpg, double fuelCapacityGallons) {
        super(make, model, startingOdometerValue);
        if (mpg <= 0){
            throw new IllegalArgumentException("Invalid mpg input: " + mpg);
        }
        if (fuelCapacityGallons <= 0){
            throw new IllegalArgumentException("Invalid fuel capacity: " + fuelCapacityGallons);
        }
        this.mpg = mpg;
        this.fuelCapacityGallons = fuelCapacityGallons;
        fuelLevel = this.fuelCapacityGallons;
    }

    /**
     * Defaults startingOdometerValue to 0.
     * 
     * @throws IllegalArgumentException if mpg or fuelCapacityGallons are
     *                                  non-positive.
     */
    public GasPoweredCar(String make, String model, double mpg, double fuelCapacityGallons) {
        super(make, model);
        if (mpg <= 0){
            throw new IllegalArgumentException("Invalid mpg input: " + mpg);
        }
        if (fuelCapacityGallons <= 0){
            throw new IllegalArgumentException("Invalid fuel capacity: " + fuelCapacityGallons);
        }
        this.mpg = mpg;
        this.fuelCapacityGallons = fuelCapacityGallons;
    }

    /**
     * Drives the full given number of miles.
     * 
     * @throws IllegalArgumentException if miles is negative.
     * @throws IllegalArgumentException if miles is too high given the
     *                                  current fuel.
     */
    public void drive(double miles) {
        if (miles < 0){
            throw new IllegalArgumentException("Miles input: " + miles + " is too low.");
        }
        if (miles > fuelCapacityGallons){
            throw new IllegalArgumentException("Miles input: " + miles + " is too high.");
        }
        // To Do
    }

    /** Returns how many miles can be driven on one gallon of gas. */
    public double getMPG() {
        return mpg;
    }

    /** Returns how many gallons of fuel are currently in the car. */
    public double getFuelLevel() {
        return fuelLevel;
    }

    /** Returns how many gallons of fuel the car can hold at max. */
    public double getFuelCapacity() {
        return fuelCapacityGallons;
    }

    /** Refuels the car to max fuel capacity. */
    public void refillTank() {
        fuelLevel = fuelCapacityGallons;
    }

    /**
     * Returns how many more miles the car can currently go without
     * refueling.
     */
    public double getRemainingRange() {
        return fuelLevel * mpg;
    }

    /**
     * Attempt to refuel the car with additional gallons.
     * 
     * @throws IllegalArgumentException if gallons is negative OR gallons
     *                                  would overfill the tank.
     */
    public void refillTank(double gallons) {
        if (gallons < 0){
            throw new IllegalArgumentException("Invalid refill gallons input: " + gallons);
        }
        if (gallons + fuelLevel > fuelCapacityGallons){
            throw new IllegalArgumentException("Refill exceeds fuelCapacity " + gallons);
        }
        fuelLevel += gallons;
    }

    /**
     * Decreases the amount of fuel in the gas tank based upon
     * mpg and the number of miles passed as an argument.
     */
    protected void decreaseFuelLevel(double miles) {
        fuelLevel -= (miles * (1/ mpg));
    };

}