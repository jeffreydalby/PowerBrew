package edu.bu.met.cs665.brew;

import edu.bu.met.cs665.hardware.PowerBrew5000;

public class BrewEspresso implements BrewBeverage {
    @Override
    public void brew() {
        //first inject concentrate
        PowerBrew5000.addExtract(Beverages.beverageChoices.Espresso, EXTRACT_CONCENTRATION);
        //let the person know their drink is being made
        System.out.println("Making your cup of " + (int) PowerBrew5000.getWaterTankCurrentTemp() + " degree " + Beverages.beverageChoices.Espresso);
    }
}
