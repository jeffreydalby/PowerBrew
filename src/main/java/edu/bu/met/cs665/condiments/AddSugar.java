package edu.bu.met.cs665.condiments;

import edu.bu.met.cs665.hardware.PowerBrew5000;

public class AddSugar implements AddCondiment {
    @Override
    public void addCondiment(PowerBrew5000 theMachine, int units) {
        System.out.println("Adding " + units + " spoonful(s) of sugar.");
        theMachine.addCondiment(Condiments.CondimentChoices.sugar, units);
    }
}
