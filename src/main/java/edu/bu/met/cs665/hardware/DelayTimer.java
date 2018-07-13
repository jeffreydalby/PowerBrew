package edu.bu.met.cs665.hardware;

class DelayTimer {//created this sleeper method to handle Interrupted Exceptions in one place

    static void sleeper(int millisToSleep) {
        try {
            Thread.sleep(millisToSleep);
        } catch (InterruptedException ex) {
            //do nothing since we'll catch it in the isInterrupt check
        }
    }
}