package edu.bu.met.cs665.hardware;

class DelayTimer {
    //created this sleeper method to handle Interrupted Exceptions in one place

    /**
     * Sleeper method so I don't have to keep adding try catch blocks
     *
     * @param millisToSleep - how long to sleep in milliseconds
     */
    static void sleeper(int millisToSleep) {
        try {
            Thread.sleep(millisToSleep);
        } catch (InterruptedException ex) {
            //we don't care that the sleep was interrupted but re-throw to make she the thread itself can catch it
            Thread.currentThread().interrupt();
        }
    }
}