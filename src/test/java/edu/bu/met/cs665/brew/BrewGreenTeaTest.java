package edu.bu.met.cs665.brew;

import edu.bu.met.cs665.hardware.PowerBrew5000;
import org.junit.Assert;
import org.junit.Test;

public class BrewGreenTeaTest {
    private PowerBrew5000 testMachine = new PowerBrew5000();

    @Test
    public void brew() {
        BrewGreenTea brewGreenTea = new BrewGreenTea();
        Assert.assertEquals("Making your cup of 75 degree Green Tea", brewGreenTea.brew(testMachine));
    }
}