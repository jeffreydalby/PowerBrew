package edu.bu.met.cs665.brew;

import edu.bu.met.cs665.hardware.PowerBrew5000;

//Concrete implementation using Strategy Pattern for Yellow Tea
public class BrewYellowTea implements BrewBeverage {
    /**
     * Brew us up some Yellow Tea
     *
     * @param theMachine - pass the hardware around to keep things decoupled
     */
    @Override
    public String brew(PowerBrew5000 theMachine) {
        //first inject concentrate
        theMachine.addConcentrate(Beverages.BeverageChoices.Yellow_Tea, EXTRACT_CONCENTRATION);
        //let the person know their drink is being made
        return "Making your cup of " + (int) theMachine.getWaterTankCurrentTemp() + " degree " + Beverages.BeverageChoices.Yellow_Tea;
    }
}
