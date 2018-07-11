package edu.bu.met.cs665;

import edu.bu.met.cs665.hardware.PowerBrew5000;
import edu.bu.met.cs665.ui.MainMenu;

public class Main {


    public static void main(String[] args) {
        MainMenu systemMenu = new MainMenu();
        PowerBrew5000 myMachine = new PowerBrew5000();
        Thread runHardware = new Thread(myMachine);
        //power up the PowerBrew5000
        myMachine.powerOn();
        runHardware.start();
        systemMenu.show();

        //shut the machine down on exit
        runHardware.interrupt();
    }


}