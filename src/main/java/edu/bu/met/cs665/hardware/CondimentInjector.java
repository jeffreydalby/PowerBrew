package edu.bu.met.cs665.hardware;

import edu.bu.met.cs665.condiments.Condiments;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

class CondimentInjector {//for fun condiments come in small packages "units" that are auto-fed and added to drinks
    private static final int CONDIMENTS_START_UNITS = 1000;
    private static final int LOW_CONDIMENT_WARNING_UNITS = 500;
    private Map<Condiments.CondimentChoices, Integer> condimentLevels = new HashMap<>();

    CondimentInjector() {
    }

    void initializeCondimentLevels() {
        //build condiment levels from the enum, to simplify adding new options later
        for (Condiments.CondimentChoices condimenteChoice : Condiments.CondimentChoices.values()
                ) {
            condimentLevels.put(condimenteChoice, CONDIMENTS_START_UNITS);
        }

    }

    Map<Condiments.CondimentChoices, Integer> getLowCondimentLevels() {
        return condimentLevels.entrySet()
                .stream()
                .filter(condiment -> condiment.getValue() <= LOW_CONDIMENT_WARNING_UNITS)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    }//might seem counterintuitive but addCondiment adds condiments to the drink, which removes that quantity from the reserves.

    void addCondiment(Condiments.CondimentChoices condimentChoice, int quantityToAdd) {

        if (condimentLevels.get(condimentChoice) <= LOW_CONDIMENT_WARNING_UNITS) {
            System.out.println("Out of " + condimentChoice + "we are sorry!");
            return;
        }
        condimentLevels.put(condimentChoice, condimentLevels.get(condimentChoice) - quantityToAdd);
        DelayTimer.sleeper(500 * quantityToAdd);
        System.out.println("Added " + quantityToAdd + " " + condimentChoice.toString());
    }
}