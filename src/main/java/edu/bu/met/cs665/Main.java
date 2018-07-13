package edu.bu.met.cs665;

import edu.bu.met.cs665.hardware.PowerBrew5000;
import edu.bu.met.cs665.ui.MainMenu;

public class Main {

    //hardware implementation to be used throughout
    //NOTE THIS RUNS FOREVER AND WILL NEED CTRL-C TO EXIT
    //this is because we are emulating a hardware device which would not have a menu option to turn it off
    //It will turn itself off if condiment or concentrate levels get low.

    private static PowerBrew5000 theMachine;

    public static void main(String[] args) {
        theMachine = new PowerBrew5000(); //the object to represent the hardware throughout the program
        MainMenu systemMenu = new MainMenu(theMachine);
        Thread runHardware = new Thread(theMachine);
        //power up the PowerBrew5000
        theMachine.powerOn();
        //start monitoring for temp and concentrate/condiment levels
        runHardware.start();
        //display the main menu to the user
        systemMenu.show();

        //shut the machine down on exit
        runHardware.interrupt();
    }


}