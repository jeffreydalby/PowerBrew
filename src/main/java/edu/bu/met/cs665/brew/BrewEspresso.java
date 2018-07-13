package edu.bu.met.cs665.brew;

import edu.bu.met.cs665.hardware.PowerBrew5000;

//Concrete implementation using Strategy Pattern for an Espresso
public class BrewEspresso implements BrewBeverage {
    /**
     * Brew us up some Espresso
     *
     * @param theMachine - pass the hardware around to keep things decoupled
     */
    @Override
    public String brew(PowerBrew5000 theMachine) {
        //first inject concentrate
        theMachine.addConcentrate(Beverages.BeverageChoices.Espresso, EXTRACT_CONCENTRATION);
        //let the person know their drink is being made
        return "Making your cup of " + (int) theMachine.getWaterTankCurrentTemp() + " degree " + Beverages.BeverageChoices.Espresso;
    }
}
