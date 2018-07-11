package edu.bu.met.cs665.ui;

import edu.bu.met.cs665.brew.*;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class MainMenu {
    //build out an easy way to add/remove beverages and auto-create the menu system
    //overrides toString so we can get "readable" names into the menu


    private Beverages.beverageChoices beverageChoice;
    //scanner to use for all input
    private static Scanner sc = new Scanner(System.in);

    private Map<Beverages.beverageChoices, BrewBeverage> beverageMap = new HashMap<>();

    public MainMenu() {
        //initialize the beverages choice map on object creation
        this.fillBeverageMap();
    }


    public void show() {
        while (true) {
            System.out.println("Welcome to the Hot Beverage 5000");
            beverageChoice = getBeverage();
            MakeDrink drinkMaker = new MakeDrink(beverageMap.get(beverageChoice));
            drinkMaker.start();
        }
    }

    private static Beverages.beverageChoices getBeverage() {

        //don't want to be making copies values each time we want the length so do it once
        int numBeverages = Beverages.beverageChoices.values().length;
        int selectedDrink = 0;

        System.out.println("Please select one of the following menu options");
        //display potential drinks
        for (int i = 1; i <= numBeverages; i++) {
            System.out.println(i + ". " + Beverages.beverageChoices.values()[i - 1]);
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
        return Beverages.beverageChoices.values()[selectedDrink - 1];
    }


    private void fillBeverageMap() {
        this.beverageMap.put(Beverages.beverageChoices.Americano, new BrewAmericano());
        this.beverageMap.put(Beverages.beverageChoices.Espresso, new BrewEspresso());
        this.beverageMap.put(Beverages.beverageChoices.Latte_Macchiato, new BrewLatteMacchiato());
        this.beverageMap.put(Beverages.beverageChoices.Black_Tea, new BrewBlackTea());
        this.beverageMap.put(Beverages.beverageChoices.Green_Tea, new BrewGreenTea());
        this.beverageMap.put(Beverages.beverageChoices.Yellow_Tea, new BrewYellowTea());
    }
}
