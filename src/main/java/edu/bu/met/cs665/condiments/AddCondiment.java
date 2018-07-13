package edu.bu.met.cs665.condiments;

import edu.bu.met.cs665.hardware.PowerBrew5000;

//Interface for behaviors using Strategy Pattern
public interface AddCondiment {

    void addCondiment(PowerBrew5000 theMachine, int units);
}
