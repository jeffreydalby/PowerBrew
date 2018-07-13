package edu.bu.met.cs665.hardware;

import edu.bu.met.cs665.brew.Beverages.BeverageChoices;
import edu.bu.met.cs665.condiments.Condiments;

import java.util.Map;

//hardware controller for the PowerBrew5000
public class PowerBrew5000 implements Runnable {

    //The PowerBrew5000 consists of three major hardware components
    private final ConcentrateInjector concentrateInjector = new ConcentrateInjector();
    private final CondimentInjector condimentInjector = new CondimentInjector();
    private final Heater heater = new Heater();

    //flag to let us know that either a condiment or concentrate is out.
    //not super user friendly cause if anything is out we shut the whole machine down.
    public static boolean isNeedsToBeServiced() {
        return needsToBeServiced;
    }

    private static boolean needsToBeServiced;


    //we want external resourse to access hardware componenets via the PowerBrew5000
    public double getWaterTankCurrentTemp() {
        return heater.getWaterTankCurrentTemp();
    }

    //target temp and min temp taken from ideal temps to serve hot beverages found at
    //https://www.littlecoffeeplace.com/coffee-ideal-temperature

    //this is just here to simulate a heating light on the machine, at the moment it is just
    //running in the background. Let's other packages check if the heater is on
    public boolean isHeating() {
        return heater.isHeating();
    }

    public void setHeating(boolean heating) {
        heater.setHeating(heating);
    }

    public PowerBrew5000() {

        //initialize concentrate levels
        concentrateInjector.initializeConcentrateLevels();
        //initialize the Condiment levels
        condimentInjector.initializeCondimentLevels();

    }

    /**
     * Turn on the machine and heat up the water
     */
    public void powerOn() {
        System.out.println("Initialize PowerBrew5000....please wait (CTRL-C to Power Down)");
        heater.initialHeat();

    }

    /**
     * allows outside object to add concentrate
     *
     * @param beverageChoice - which beverage concentrate to add
     * @param percentToAdd   - percentage concentrate to add
     */
    public void addConcentrate(BeverageChoices beverageChoice, double percentToAdd) {
        concentrateInjector.addConcentrate(beverageChoice, percentToAdd);
    }

    /**
     * allows external object to add condiments (sugar, milk)
     *
     * @param condimentChoice- type of condiment to add
     * @param quantityToAdd-   quantity of condiment to add
     */
    public void addCondiment(Condiments.CondimentChoices condimentChoice, int quantityToAdd) {

        condimentInjector.addCondiment(condimentChoice, quantityToAdd);
    }


    //background process that keeps the PowerBrew5000 running
    @Override
    public void run() {
        //maps to trak low beverages and condiments
        Map<BeverageChoices, Double> lowConcentrate;
        Map<Condiments.CondimentChoices, Integer> lowCondiments;


        //loop that is running continuously to keep water heated and check concentrate levels
        while (true) {
            //exit if our thread gets shut down
            if (Thread.currentThread().isInterrupted()) break;

            //check concentrate levels and warn if low
            lowConcentrate = concentrateInjector.getLowConcentrateLevels();
            if (!lowConcentrate.isEmpty()) {
                lowConcentrate.forEach((concentrate, level) -> System.out.println(concentrate.toString() + " concentrate is at " + level.toString() + "%, Shutting down to be refilled."));
                needsToBeServiced = true;
                break;
            }

            //check condiment levels and warn if low
            lowCondiments = condimentInjector.getLowCondimentLevels();
            if (!lowCondiments.isEmpty()) {
                lowCondiments.forEach((condiment, level) -> System.out.println("There are only " + level.toString() + condiment.toString() + " left, Shutting down to be refilled."));
                needsToBeServiced = true;
                break;
            }

            //check heat levels and heat until at ideal temp

            if (heater.getWaterTankCurrentTemp() <= Heater.WATER_MIN_TEMP) {
                while (heater.getWaterTankCurrentTemp() < Heater.WATER_TARGET_TEMP) {
                    //no need to keep heating...exit if our thread gets shut down
                    if (Thread.currentThread().isInterrupted()) break;
                    this.heater.setHeating(true);
                    DelayTimer.sleeper(300);
                    heater.heatWaterTank(3);
                }
            }
            //set heating to false unless we are actually in the heating loop
            this.heater.setHeating(false);
            //each time through this loop the water temp drops by .1 degrees which essentially will turn the heater on every minute and 15 seconds.
            heater.decreaseWaterTemp(.1);

            //sleep for half a second
            DelayTimer.sleeper(500);
        }
    }
}
