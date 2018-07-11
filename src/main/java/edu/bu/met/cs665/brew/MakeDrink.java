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
        this.beverageToMake.brew();
    }

}
