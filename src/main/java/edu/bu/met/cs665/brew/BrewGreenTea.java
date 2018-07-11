package edu.bu.met.cs665.brew;

import edu.bu.met.cs665.hardware.PowerBrew5000;

public class BrewGreenTea implements BrewBeverage {
    @Override
    public void brew() {
        //first inject concentrate
        PowerBrew5000.addExtract(Beverages.beverageChoices.Green_Tea, EXTRACT_CONCENTRATION);
        //let the person know their drink is being made
        System.out.println("Making your cup of " + Beverages.beverageChoices.Green_Tea);
    }
}
