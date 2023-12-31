package vehicle;
public class FordFrivolous extends GasPoweredCar implements SelfDriving, Flying {
    /** FordFrivolous has a gas tank of 20 gallons and an MPG of 23.6. */
    public FordFrivolous(double startingOdometerValue) {
        super("Ford", "Frivolous", startingOdometerValue, 23.6, 20.0);
    }

    /** Defaults startingOdometerValue to 0. */
    public FordFrivolous() {
        this(0);
    }

    /**
     * Autonomous driving works like Tesla’s – but it uses twice the
     * amount of the gas in comparison to regular driving. Whoops!
     * 
     * @throws IllegalArgumentException if miles is negative.
     */
    public void driveAutonomously(double miles) {
        if (miles < 0){
            throw new IllegalArgumentException("Miles input: " + miles + " is negative.");
        }
        if (miles > getRemainingRange() / 2){
            drive(getRemainingRange() /2 );
            decreaseFuelLevel(getRemainingRange() /2);
        }
        else {
            drive(miles);
            decreaseFuelLevel(miles);
        }

    }

    /** Same as for Chevrolet Bird. */
    public boolean canFly(double miles) {
        if (miles < 0) {
            throw new IllegalArgumentException("Invalid Miles Input");
        }
        return canDrive(miles*3);
    }

    /**
     * Same as for Chevrolet Bird except the Ford Frivolous doesn’t need
     * wings to fly! But, flying uses triple the amount of gas as driving,
     * per mile traveled. Ouch!
     */
    public void fly(double miles) {
        if (canFly(miles)) {
            decreaseFuelLevel(miles*3);
        }
        else {
            throw new IllegalArgumentException("Invalid Miles Input");
        }
    }

}