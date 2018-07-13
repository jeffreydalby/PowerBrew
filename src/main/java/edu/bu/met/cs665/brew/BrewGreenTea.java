package edu.bu.met.cs665.brew;

import edu.bu.met.cs665.hardware.PowerBrew5000;

//Concrete implementation using Strategy Pattern for Green Tea
public class BrewGreenTea implements BrewBeverage {
    /**
     * Brew us up some green Tea
     *
     * @param theMachine - pass the hardware around to keep things decoupled
     */
    @Override
    public String brew(PowerBrew5000 theMachine) {
        //first inject concentrate
        theMachine.addConcentrate(Beverages.BeverageChoices.Green_Tea, EXTRACT_CONCENTRATION);
        //let the person know their drink is being made
        return "Making your cup of " + (int) theMachine.getWaterTankCurrentTemp() + " degree " + Beverages.BeverageChoices.Green_Tea;
    }
}
