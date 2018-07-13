package edu.bu.met.cs665.brew;

import edu.bu.met.cs665.hardware.PowerBrew5000;
import org.junit.Test;

public class MakeDrinkTest {

    private PowerBrew5000 powerBrew5000 = new PowerBrew5000();
    private MakeDrink drinkMaker = new MakeDrink(new BrewAmericano());

    @Test
    public void brew() {
        //make an Americano
        drinkMaker.brew(powerBrew5000);
        //
        //should only output:

        //**************Brewing the Perfect Drink**************
        //
        //Mixing in Americano
        //Making your cup of 75 degree Americano
        //...........
        //All done! Enjoy your beverage.
    }
}