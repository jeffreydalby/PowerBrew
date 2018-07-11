package edu.bu.met.cs665.brew;

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

    public void start() {
        //make the drink
        System.out.println("\n**************Brewing the Perfect Drink**************\n");
        this.beverageToMake.brew();
        for (int i = 0; i <= 10; i++) {
            try {
                System.out.print(".");
                Thread.sleep(100);
            } catch (Exception ex) {
                //Doing nothing with the catch since this is just a simple program
            }

        }
        //Doing nothing with the catch since this is just a simple program
        System.out.println("\nAll done! Enjoy your beverage. \n\n");
    }

}
