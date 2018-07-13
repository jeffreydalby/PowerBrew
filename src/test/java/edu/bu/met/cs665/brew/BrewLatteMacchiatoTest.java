package edu.bu.met.cs665.brew;

import edu.bu.met.cs665.hardware.PowerBrew5000;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class BrewLatteMacchiatoTest {

    private PowerBrew5000 testMachine = new PowerBrew5000();

    @Test
    public void brew() {
        BrewLatteMacchiato brewLatteMacchiato = new BrewLatteMacchiato();
        Assert.assertEquals("Making your cup of 75 degree Latte Macchiato", brewLatteMacchiato.brew(testMachine));
    }
}