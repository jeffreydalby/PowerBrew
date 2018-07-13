package edu.bu.met.cs665.brew;

import edu.bu.met.cs665.hardware.PowerBrew5000;

public interface BrewBeverage {
    //the machine allows for set volume of concentrate for all types of drinks
    //we can change how concentrated they are here
    double EXTRACT_CONCENTRATION = 12;

    void brew(PowerBrew5000 theMachine);
}
