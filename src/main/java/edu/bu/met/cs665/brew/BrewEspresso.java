package edu.bu.met.cs665.brew;

import edu.bu.met.cs665.hardware.PowerBrew5000;

public class BrewEspresso implements BrewBeverage {
    @Override
    public void brew(PowerBrew5000 theMachine) {
        //first inject concentrate
        theMachine.addConcentrate(Beverages.BeverageChoices.Espresso, EXTRACT_CONCENTRATION);
        //let the person know their drink is being made
        System.out.println("Making your cup of " + (int) theMachine.getWaterTankCurrentTemp() + " degree " + Beverages.BeverageChoices.Espresso);
    }
}
