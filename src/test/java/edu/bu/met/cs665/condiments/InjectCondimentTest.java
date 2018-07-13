package edu.bu.met.cs665.condiments;

import edu.bu.met.cs665.hardware.PowerBrew5000;
import org.junit.Test;

public class InjectCondimentTest {
    private PowerBrew5000 powerBrew5000 = new PowerBrew5000();
    private InjectCondiment condimentInjector = new InjectCondiment();

    @Test
    public void addCondimentToDrink() {
        condimentInjector.addCondimentToDrink(powerBrew5000, new AddSugar(), 3);
        //should output to the console:
        //
        //Adding 3 spoonful(s) of sugar.
        //Added 3 spoonful(s)of sugar.
    }
}