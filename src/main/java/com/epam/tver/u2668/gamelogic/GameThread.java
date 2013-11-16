package com.epam.tver.u2668.gamelogic;

public class GameThread implements Runnable {

    private MainLogic mainLogic;

    public GameThread(MainLogic mainLogic) {
        this.mainLogic = mainLogic;
    }

    @Override
    public void run() {
        try {
            while (!mainLogic.getGameThread().isInterrupted()) {
                mainLogic.step();
                Thread.sleep(100);
            }
        } catch (InterruptedException ex) {

        }
    }

}
