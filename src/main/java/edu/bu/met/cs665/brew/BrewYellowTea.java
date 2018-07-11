package edu.bu.met.cs665.brew;

import edu.bu.met.cs665.hardware.PowerBrew5000;

public class BrewYellowTea implements BrewBeverage {
    @Override
    public void brew() {
        //first inject concentrate
        PowerBrew5000.addExtract(Beverages.beverageChoices.Yellow_Tea, EXTRACT_CONCENTRATION);
        //let the person know their drink is being made
        System.out.println("Making your cup of " + Beverages.beverageChoices.Yellow_Tea);
    }
}
