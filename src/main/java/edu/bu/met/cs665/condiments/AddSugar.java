package edu.bu.met.cs665.condiments;

import edu.bu.met.cs665.hardware.PowerBrew5000;

//Concrete implementation to add sugar
public class AddSugar implements AddCondiment {
    /**
     * Adds sugar to the drink
     *
     * @param theMachine- the machine object to use to add the sugar
     * @param units-      amount of user selected sugar to add
     */
    @Override
    public void addCondiment(PowerBrew5000 theMachine, int units) {
        System.out.println("Adding " + units + " spoonful(s) of sugar.");
        theMachine.addCondiment(Condiments.CondimentChoices.sugar, units);
    }
}
