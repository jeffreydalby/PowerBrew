package edu.bu.met.cs665.brew;

import edu.bu.met.cs665.hardware.PowerBrew5000;

//Context for Strategy Pattern
public class MakeDrink {

    private BrewBeverage beverageToMake;

    //default to making tea cause that's what I like
    public MakeDrink() {
        this(new BrewBlackTea());

    }

    //pass in the behavior we want for the type of beverage
    public MakeDrink(BrewBeverage beverageType) {

        this.beverageToMake = beverageType;
    }

    /**
     * Brew whatever type of drink behavior this has been created with
     *
     * @param theMachine - we pass in the machine to brew it on to decouple it a bit
     */
    public void brew(PowerBrew5000 theMachine) {
        //make the drink
        System.out.println("\n**************Brewing the Perfect Drink**************\n");
        System.out.println(this.beverageToMake.brew(theMachine));
        for (int i = 0; i <= 10; i++) {
            try {
                System.out.print(".");
                Thread.sleep(100);
            } catch (Exception ex) {
                //Doing nothing significant with the catch since this is just a simple program
                System.out.println("My Sleep was Interrupted!");
            }

        }
        System.out.println("\nAll done! Enjoy your beverage. \n\n");
    }

}
