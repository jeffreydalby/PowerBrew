package edu.bu.met.cs665;

import edu.bu.met.cs665.hardware.PowerBrew5000;
import edu.bu.met.cs665.ui.MainMenu;

public class Main {

    //hardware implementation to be used throughout

    private static PowerBrew5000 theMachine;

    public static boolean isNeedsService() {
        return needsService;
    }

    public static void setNeedsService(boolean needsService) {
        Main.needsService = needsService;
    }

    private static boolean needsService;

    public static void main(String[] args) {
        theMachine = new PowerBrew5000();
        MainMenu systemMenu = new MainMenu(theMachine);
        Thread runHardware = new Thread(theMachine);
        //power up the PowerBrew5000
        theMachine.powerOn();
        runHardware.start();
        systemMenu.show();

        //shut the machine down on exit
        runHardware.interrupt();
    }


}