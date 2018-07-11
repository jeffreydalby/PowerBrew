package edu.bu.met.cs665.hardware;

import org.junit.Test;

public class PowerBrew5000Test {

    PowerBrew5000 myMachine = new PowerBrew5000();

    @Test
    public void run() {
        Thread testThread = new Thread(myMachine);
        System.out.println("Current Water temp is " + myMachine.getWaterTankCurrentTemp());
        testThread.start();


        try {
            Thread.sleep(10000);

        } catch (InterruptedException ex) { //do nothing just a test
        }

        System.out.println("Water temp is now " + myMachine.getWaterTankCurrentTemp());


        testThread.interrupt();
    }
}