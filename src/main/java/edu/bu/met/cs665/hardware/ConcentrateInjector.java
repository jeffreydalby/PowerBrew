package edu.bu.met.cs665.hardware;

import edu.bu.met.cs665.brew.Beverages;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

//Hardware emulator to inject concentrate
class ConcentrateInjector {
    //for fun we are using a percentage of the concentrate tanks to simulate they are a refillable container
    private static final double CONCENTRATE_START_PERCENTAGE = 100.0;
    private static final double LOW_CONCETRATE_WARNING_PERCENTAGE = 10.0;
    private Map<Beverages.BeverageChoices, Double> concentrateLevels = new HashMap<>();

    ConcentrateInjector() {
    }

    //for the sake of this exercise we assume that on startup all tanks are full
    void initializeConcentrateLevels() {
        //build concentrate levels from the enum, to simplify adding new options later
        for (Beverages.BeverageChoices beverageChoice : Beverages.BeverageChoices.values()
                ) {
            concentrateLevels.put(beverageChoice, CONCENTRATE_START_PERCENTAGE);

        }
    }

    /**
     * Finds any concentrates below the LOW_CONCENTRATE_WARNING_PERCENTAGE
     *
     * @return -all concentrates below level
     */
    Map<Beverages.BeverageChoices, Double> getLowConcentrateLevels() {
        return concentrateLevels.entrySet()
                .stream()
                .filter(concentrate -> concentrate.getValue() <= LOW_CONCETRATE_WARNING_PERCENTAGE)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));


    }

    /**
     * might seem counterintuitive but addConcentrate adds concentrate to the drink, which removes that quantity from the reserves.
     *
     * @param beverageChoice - type of concentrate to add
     * @param percentToAdd-  percentage to add
     */
    void addConcentrate(Beverages.BeverageChoices beverageChoice, double percentToAdd) {
        System.out.println("Mixing in " + beverageChoice.toString());
        if (concentrateLevels.get(beverageChoice) <= LOW_CONCETRATE_WARNING_PERCENTAGE) {
            System.out.println("Out of " + beverageChoice + "we are sorry!");
            return;
        }
        concentrateLevels.put(beverageChoice, concentrateLevels.get(beverageChoice) - percentToAdd);
    }
}