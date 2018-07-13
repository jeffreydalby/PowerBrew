package edu.bu.met.cs665.brew;

import edu.bu.met.cs665.hardware.PowerBrew5000;
import org.junit.Assert;
import org.junit.Test;

public class BrewYellowTeaTest {
    private PowerBrew5000 testMachine = new PowerBrew5000();

    @Test
    public void brew() {
        BrewYellowTea brewYellowTea = new BrewYellowTea();
        Assert.assertEquals("Making your cup of 75 degree Yellow Tea", brewYellowTea.brew(testMachine));
    }
}