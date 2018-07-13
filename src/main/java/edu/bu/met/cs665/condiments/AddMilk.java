package edu.bu.met.cs665.condiments;

import edu.bu.met.cs665.hardware.PowerBrew5000;

public class AddMilk implements AddCondiment {
    @Override
    public void addCondiment(PowerBrew5000 theMachine, int units) {
        System.out.println("Adding " + units + " splashes of milk.");
        theMachine.addCondiment(Condiments.CondimentChoices.milk, units);
    }
}
