package edu.bu.met.cs665.hardware;

//Hardware emulation of onboard water heater
class Heater {

    private double waterTankCurrentTemp;
    static final double WATER_TARGET_TEMP = 155.0; //Ideal temp for storage tank
    static final double WATER_MIN_TEMP = 140.0; //minimum temp we allow for drinks
    private static final double WATER_TANK_START_TEMP = 75.0; //emulation of ambient temp
    private boolean heating; //for future use to turn on and off an light to show it is heating

    Heater() {
        //initial water temp is ambient (set by constant)
        this.waterTankCurrentTemp = WATER_TANK_START_TEMP;
    }

    double getWaterTankCurrentTemp() {
        return this.waterTankCurrentTemp;
    }

    //this is just here to simulate a heating light on the machine, at the moment it is just
    //running in the background.
    boolean isHeating() {
        return this.heating;
    }

    void setHeating(boolean heating) {
        this.heating = heating;
    }

    /**
     * Bring the water up to temp on machine power on.
     */
    void initialHeat() {
        System.out.println("Heating water");
        while (waterTankCurrentTemp < WATER_TARGET_TEMP) {
            DelayTimer.sleeper(100); //just simulation how long it might take to raise temp by X degrees
            heatWaterTank(5);
            System.out.print(".");
        }


        System.out.println("\nWater is now a perfect " + waterTankCurrentTemp + " degrees.");
    }

    /**
     * heat our water
     *
     * @param amount - how many degrees it heats by
     */
    void heatWaterTank(double amount) {
        waterTankCurrentTemp += amount;
    }

    /**
     * Simulate water cooling off
     *
     * @param amount- amount to cool
     */
    void decreaseWaterTemp(double amount) {
        waterTankCurrentTemp -= amount;
    }
}