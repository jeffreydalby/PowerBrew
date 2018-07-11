package edu.bu.met.cs665.hardware;

import edu.bu.met.cs665.brew.Beverages;
import edu.bu.met.cs665.brew.Beverages.beverageChoices;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

//hardware controller for the PowerBrew5000
public class PowerBrew5000 implements Runnable {

    public static double getWaterTankCurrentTemp() {
        return waterTankCurrentTemp;
    }

    private static double waterTankCurrentTemp;

    //target temp and min temp taken from ideal temps to serve hot beverages found at
    //https://www.littlecoffeeplace.com/coffee-ideal-temperature

    public static final double WATER_TARGET_TEMP = 155;
    public static final double WATER_MIN_TEMP = 140;

    public static boolean isHeating() {
        return heating;
    }

    public static void setHeating(boolean heating) {
        PowerBrew5000.heating = heating;
    }

    public static boolean heating;

    //static so brewing the beverage can deplete the level
    public static Map<Beverages.beverageChoices, Double> concentrateLevels = new HashMap<>();


    public PowerBrew5000() {
        //initial water temp is ambient, for fun we'll say 72
        waterTankCurrentTemp = 75.0;
        //initialize extract levels
        initializeConcentrateLevels();

    }

    //for the sake of this exercise we assume that on startup all tanks are full
    private static void initializeConcentrateLevels() {
        concentrateLevels.put(beverageChoices.Americano, 100.0);
        concentrateLevels.put(beverageChoices.Espresso, 100.0);
        concentrateLevels.put(beverageChoices.Latte_Macchiato, 100.0);
        concentrateLevels.put(beverageChoices.Black_Tea, 100.0);
        concentrateLevels.put(beverageChoices.Yellow_Tea, 100.0);
        concentrateLevels.put(beverageChoices.Green_Tea, 100.0);

    }

    public void powerOn() {
        System.out.println("Initialize PowerBrew5000....please wait");
        initialHeat();

    }

    public void initialHeat() {
        System.out.println("Heating water");
        while (waterTankCurrentTemp < WATER_TARGET_TEMP) {
            sleeper(100);
            heatWaterTank(5);
            System.out.print(".");
        }


        System.out.println("\nWater is now a perfect " + waterTankCurrentTemp + " degrees.");
    }

    private void heatWaterTank(double amount) {
        waterTankCurrentTemp += amount;
    }

    private void decreaseWaterTemp(double amount) {
        waterTankCurrentTemp -= amount;
    }

    private Map<beverageChoices, Double> getLowExtractLevels() {
        return concentrateLevels.entrySet()
                .stream()
                .filter(extract -> extract.getValue() <= 10.0)
                .collect(Collectors.toMap(extract -> extract.getKey(), extract -> extract.getValue()));


    }

    //might seem counterintuitive but addExtract adds extract to the drink, which removes that quantity from the reserves.
    public static void addExtract(beverageChoices beverageChoice, double percentToAdd) {
        System.out.println("Mixing in " + beverageChoice.toString());
        if (concentrateLevels.get(beverageChoice) <= 5) {
            System.out.println("Out of " + beverageChoice + "we are sorry!");
            return;
        }
        concentrateLevels.put(beverageChoice, concentrateLevels.get(beverageChoice) - percentToAdd);
    }

    //created this sleeper method to handle Interrupted Exceptions in one place
    private void sleeper(int millisToSleep) {
        try {
            Thread.sleep(millisToSleep);
        } catch (InterruptedException ex) {
            //do nothing since we'll catch it in the isInterrupt check
        }
    }

    //background process that keeps the PowerBrew5000 running
    @Override
    public void run() {
        Map<beverageChoices, Double> lowExtracts;


        //loop that is running continuously to keep water heated and check extract levels
        while (true) {
            //exit if our thread gets shut down
            if (Thread.currentThread().isInterrupted()) break;

            //check extract levels and warn if low
            lowExtracts = getLowExtractLevels();
            if (!lowExtracts.isEmpty()) {
                lowExtracts.forEach((extract, level) -> System.out.println(extract.toString() + " extract is at " + level.toString() + "%, Shutting down to be refilled."));
                System.exit(0);
            }

            //check heat levels and heat until at ideal temp

            if (waterTankCurrentTemp <= WATER_MIN_TEMP) {
                while (waterTankCurrentTemp < WATER_TARGET_TEMP) {
                    //no need to keep heating...exit if our thread gets shut down
                    if (Thread.currentThread().isInterrupted()) break;
                    heating = true;
                    sleeper(300);
                    this.heatWaterTank(3);
                }
            }
            //set heating to false unless we are actually in the heating loop
            heating = false;
            //each time through this loop the water temp drops by .1 degrees which essentially will turn the heater on every minute and 15 seconds.
            decreaseWaterTemp(.1);

            //sleep for half a second
            sleeper(500);
        }
    }
}
