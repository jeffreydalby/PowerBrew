package edu.bu.met.cs665.condiments;

import edu.bu.met.cs665.hardware.PowerBrew5000;

//Concrete implementation to add milk
public class AddMilk implements AddCondiment {
    /**
     * ALlows us to add milk to the drink
     *
     * @param theMachine - pass in the machine
     * @param units      - User selected units of milk "splashes"
     */
    @Override
    public void addCondiment(PowerBrew5000 theMachine, int units) {
        System.out.println("Adding " + units + " splashes of milk.");
        theMachine.addCondiment(Condiments.CondimentChoices.milk, units);
    }
}
