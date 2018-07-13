package edu.bu.met.cs665.hardware;

import edu.bu.met.cs665.brew.Beverages;
import edu.bu.met.cs665.condiments.Condiments;
import org.junit.Test;

public class PowerBrew5000Test {

    private PowerBrew5000 myMachine = new PowerBrew5000();

    @Test
    public void run() {
        Thread testThread = new Thread(myMachine);
        System.out.println("Current Water temp is " + myMachine.getWaterTankCurrentTemp());
        testThread.start();


        try {
            Thread.sleep(200);

        } catch (InterruptedException ex) { //do nothing just a test
        }

        System.out.println("Water temp is now " + myMachine.getWaterTankCurrentTemp());


        testThread.interrupt();
    }

    @Test
    public void addExtract() {
        myMachine.addConcentrate(Beverages.BeverageChoices.Americano, 2.0);

        // will output to screen
        // Mixing in Americano

    }

    @Test
    public void addCondiment() {
        myMachine.addCondiment(Condiments.CondimentChoices.milk, 3);

        //will output to screen
        //Added 3 splash(es) of milk.

    }
}