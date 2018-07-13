package edu.bu.met.cs665.condiments;

import edu.bu.met.cs665.hardware.PowerBrew5000;

//Context used for Strategy Pattern
public class InjectCondiment {

    private AddCondiment condimentToAdd;

    public InjectCondiment() {
        this(new AddMilk());
    }

    private InjectCondiment(AddCondiment condimentToAdd) {
        this.condimentToAdd = condimentToAdd;
    }

    /**
     * Adds whatever condiment behavior is passed
     *
     * @param theMachine  - machine object to use
     * @param condiment-  which behavior to use
     * @param unitsToAdd- amount of condiment to add
     */
    //will let us add any type of condiment we want later
    public void addCondimentToDrink(PowerBrew5000 theMachine, AddCondiment condiment, int unitsToAdd) {
        if (condimentToAdd != null) {
            this.condimentToAdd = condiment;
            condimentToAdd.addCondiment(theMachine, unitsToAdd);
        }

    }

}
