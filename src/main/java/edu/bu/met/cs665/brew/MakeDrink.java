package edu.bu.met.cs665.brew;

import edu.bu.met.cs665.hardware.PowerBrew5000;

//context
public class MakeDrink {

    private BrewBeverage beverageToMake;

    //default to making tea cause that's what I like
    public MakeDrink() {
        this(new BrewBlackTea());

    }

    public MakeDrink(BrewBeverage beverageType) {

        this.beverageToMake = beverageType;
    }

    public void brew(PowerBrew5000 theMachine) {
        //make the drink
        System.out.println("\n**************Brewing the Perfect Drink**************\n");
        this.beverageToMake.brew(theMachine);
        for (int i = 0; i <= 10; i++) {
            try {
                System.out.print(".");
                Thread.sleep(100);
            } catch (Exception ex) {
                //Doing nothing with the catch since this is just a simple program
                System.out.println("My Sleep was Interrupted!");
            }

        }
        //Doing nothing with the catch since this is just a simple program
        System.out.println("\nAll done! Enjoy your beverage. \n\n");
    }

}
