package edu.bu.met.cs665.brew;

import edu.bu.met.cs665.hardware.PowerBrew5000;
import org.junit.Assert;
import org.junit.Test;

public class BrewBlackTeaTest {
    private PowerBrew5000 testMachine = new PowerBrew5000();

    @Test
    public void brew() {
        BrewBlackTea brewBlackTea = new BrewBlackTea();
        Assert.assertEquals("Making your cup of 75 degree Black Tea", brewBlackTea.brew(testMachine));
    }
}