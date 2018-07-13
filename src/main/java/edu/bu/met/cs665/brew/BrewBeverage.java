package edu.bu.met.cs665.brew;

import edu.bu.met.cs665.hardware.PowerBrew5000;

//Interface for Strategy Pattern Implementation
public interface BrewBeverage {
    //the machine allows for set volume of concentrate for all types of drinks
    //we can change how concentrated they are here currently set pretty high so you can test
    //the machine running out without creating a million drinks.
    double EXTRACT_CONCENTRATION = 12;

    String brew(PowerBrew5000 theMachine);
}
