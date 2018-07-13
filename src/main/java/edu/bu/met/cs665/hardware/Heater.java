package edu.bu.met.cs665.hardware;

class Heater {
    private double waterTankCurrentTemp;
    static final double WATER_TARGET_TEMP = 155.0;
    static final double WATER_MIN_TEMP = 140.0;
    private static final double WATER_TANK_START_TEMP = 75.0;
    private boolean heating;

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

    void initialHeat() {
        System.out.println("Heating water");
        while (waterTankCurrentTemp < WATER_TARGET_TEMP) {
            DelayTimer.sleeper(100);
            heatWaterTank(5);
            System.out.print(".");
        }


        System.out.println("\nWater is now a perfect " + waterTankCurrentTemp + " degrees.");
    }

    void heatWaterTank(double amount) {
        waterTankCurrentTemp += amount;
    }

    void decreaseWaterTemp(double amount) {
        waterTankCurrentTemp -= amount;
    }
}