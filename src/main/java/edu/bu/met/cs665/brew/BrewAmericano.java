package edu.bu.met.cs665.brew;

import edu.bu.met.cs665.hardware.PowerBrew5000;

//Concrete implementation using Strategy Pattern for an Americano
public class BrewAmericano implements BrewBeverage {
    /**
     * Brew us up some Americano
     *
     * @param theMachine - pass the hardware around to keep things decoupled
     */

    @Override
    public void brew(PowerBrew5000 theMachine) {
        //first inject concentrate
        theMachine.addConcentrate(Beverages.BeverageChoices.Americano, EXTRACT_CONCENTRATION);
        //let the person know their drink is being made
        System.out.println("Making your cup of " + (int) theMachine.getWaterTankCurrentTemp() + " degree " + Beverages.BeverageChoices.Americano);
    }

}
