package edu.bu.met.cs665.brew;

public interface BrewBeverage {
    //the machine allows for set volume of concentrate for all types of drinks
    //we can change how concentrated they are here
    static final double EXTRACT_CONCENTRATION = 12;
    void brew();
}
