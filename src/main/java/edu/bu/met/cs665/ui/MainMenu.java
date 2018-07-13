package edu.bu.met.cs665.ui;

import edu.bu.met.cs665.Main;
import edu.bu.met.cs665.brew.*;
import edu.bu.met.cs665.condiments.*;
import edu.bu.met.cs665.hardware.PowerBrew5000;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class MainMenu {

    private PowerBrew5000 theMachine;
    private static final int MAX_NUMBER_OF_CONDIMENT_UNITS = 3;

    private Beverages.BeverageChoices beverageChoice;
    //scanner to use for all input
    private static Scanner sc = new Scanner(System.in, "UTF-8");

    private Map<Beverages.BeverageChoices, BrewBeverage> beverageMap = new HashMap<>();
    private Map<Condiments.CondimentChoices, AddCondiment> condimentMap = new HashMap<>();

    public MainMenu(PowerBrew5000 theMachine) {
        this.theMachine = theMachine;
        //initialize the beverages choice map on object creation
        this.fillBeverageMap();
        this.fillCondimentMap();
    }


    public void show() {
        while (true) {
            if (!Main.isNeedsService()) {
                System.out.println("Welcome to the PowerBrew 5000");
                beverageChoice = this.getBeverage();
                this.addCondiments();
                MakeDrink drinkMaker = new MakeDrink(beverageMap.get(beverageChoice));
                drinkMaker.brew(this.theMachine);
            } else {
                System.out.println("System is in need of service.");
                break;
            }

        }
    }

    private void addCondiments() {

        InjectCondiment injectCondiment = new InjectCondiment();

        //map to store amounts of condiments they would like
        Map<Condiments.CondimentChoices, Integer> condimentAmounts = new HashMap<>();

        //autobuild menu and get condiments options
        for (Condiments.CondimentChoices condimentChoice : Condiments.CondimentChoices.values()
                ) {
            int amountSelected = this.getCondimentAmount(condimentChoice);
            //only add to list if more than 0
            if (amountSelected > 0) condimentAmounts.put(condimentChoice, amountSelected);

        }

        //add the condiments to the drink if we have any to add
        if (!condimentAmounts.isEmpty())
            condimentAmounts.forEach((condiment, units) -> injectCondiment.addCondimentToDrink(this.theMachine, condimentMap.get(condiment), units));

    }

    private int getCondimentAmount(Condiments.CondimentChoices condiment) {
        int amountDesired;
        while (true) {
            try {
                System.out.println("How many " + condiment + " would you like? Please choose an amount between 0 and " + MAX_NUMBER_OF_CONDIMENT_UNITS);
                amountDesired = sc.nextInt();
                if (amountDesired >= 0 && amountDesired <= MAX_NUMBER_OF_CONDIMENT_UNITS) break;
                else System.out.println("That is not between 0 and " + MAX_NUMBER_OF_CONDIMENT_UNITS);

            } catch (InputMismatchException ex) {
                //in reality we wouldn't have this because it would be a keypad that only allows numbers
                System.out.println("That wasn't a proper number between 0 and " + MAX_NUMBER_OF_CONDIMENT_UNITS);
            } finally {
                //have to grab the carriage return since nextInt doesn't do it for us.
                sc.nextLine();
            }
        }
        return amountDesired;
    }

    private Beverages.BeverageChoices getBeverage() {

        //don't want to be making copies values each time we want the length so do it once
        int numBeverages = Beverages.BeverageChoices.values().length;
        int selectedDrink;

        System.out.println("Please select one of the following menu options");
        //display potential drinks
        for (int i = 1; i <= numBeverages; i++) {
            System.out.println(i + ". " + Beverages.BeverageChoices.values()[i - 1]);
        }

        while (true) {
            try {
                selectedDrink = sc.nextInt();
                if (selectedDrink < 0 || selectedDrink > numBeverages) {
                    System.out.println("Please choose between 0 and " + numBeverages);
                    continue;
                }
                break;
            } catch (InputMismatchException ex) {
                System.out.println("Please only enter an integer between 1 - " + numBeverages);
            } finally {
                //pick up the carriage return
                sc.nextLine();
            }

        }

        //return the enum that corresponds to the menu choice
        return Beverages.BeverageChoices.values()[selectedDrink - 1];
    }

    //This has to be created by hand so don't miss it when adding a new beverage option
    private void fillBeverageMap() {

        this.beverageMap.put(Beverages.BeverageChoices.Americano, new BrewAmericano());
        this.beverageMap.put(Beverages.BeverageChoices.Espresso, new BrewEspresso());
        this.beverageMap.put(Beverages.BeverageChoices.Latte_Macchiato, new BrewLatteMacchiato());
        this.beverageMap.put(Beverages.BeverageChoices.Black_Tea, new BrewBlackTea());
        this.beverageMap.put(Beverages.BeverageChoices.Green_Tea, new BrewGreenTea());
        this.beverageMap.put(Beverages.BeverageChoices.Yellow_Tea, new BrewYellowTea());
    }

    private void fillCondimentMap() {
        this.condimentMap.put(Condiments.CondimentChoices.milk, new AddMilk());
        this.condimentMap.put(Condiments.CondimentChoices.sugar, new AddSugar());
    }
}
