package com.test;

import com.graphics.ScreenManager;

import javax.swing.*;
import java.awt.*;

public abstract class GameCore {
    protected static final int FONT_SIZE = 18;
    private static final DisplayMode[] POSSIBLE_MODES = {
            new DisplayMode(1000, 800, 32, 0),
            new DisplayMode(1000, 800, 16, 0),
            new DisplayMode(1000, 800, 24, 0),
            new DisplayMode(840, 680, 16, 0),
            new DisplayMode(840, 680, 32, 0),
            new DisplayMode(840, 680, 24, 0),
            new DisplayMode(1080, 900, 16, 0),
            new DisplayMode(1080, 900, 32, 0),
            new DisplayMode(1080, 900, 24, 0),
    };
    private boolean isRunning;
    protected ScreenManager screen;
    /**
     Signals the game loop that it's time to quit
     */
    public void stop() {
        isRunning = false;
    }
    /**
     Calls init() and gameLoop()
     */
    public void run() {
        try {
            init();
            gameLoop();
        }
        finally {
            screen.restoreScreen();
            lazilyExit();
        }
    }
    /**
     Exits the VM from a daemon thread. The daemon thread waits
     2 seconds then calls System.exit(0). Since the VM should
     exit when only daemon threads are running, this makes sure
     System.exit(0) is only called if necessary. It's necessary
     if the Java Sound system is running.
     */
    public void lazilyExit() {
        Thread thread = new Thread() {
            public void run() {
                // first, wait for the VM exit on its own.
                try {
                    Thread.sleep(2000);
                }
                catch (InterruptedException ex) { }
                // system is still running, so force an exit
                System.exit(0);
            }
        };
        thread.setDaemon(true);
        thread.start();
    }
    /**
     Sets full screen mode and initiates and objects.
     */
    public void init() {
        screen = new ScreenManager();
        DisplayMode displayMode = screen.findFirstCompatibleMode(POSSIBLE_MODES);
        screen.setFullScreen(displayMode);
        Window window = screen.getFullScreenWindow();
        window.setFont(new Font("Dialog", Font.PLAIN, FONT_SIZE));
        window.setBackground(Color.BLACK);
        window.setForeground(Color.WHITE);
        isRunning = true;
    }
    public Image loadImage(String fileName) {
        return new ImageIcon(fileName).getImage();
    }
    /**
     Runs through the game loop until stop() is called.
     */
    public void gameLoop() {
        long currTime = System.currentTimeMillis();

        while (isRunning) {
            long elapsedTime =
                    System.currentTimeMillis() - currTime;
            currTime += elapsedTime;
            // update
            update(elapsedTime);
            // draw the screen
            Graphics2D g = screen.getGraphics();
            draw(g);
            g.dispose();
            screen.update();
        }
    }
    /**
     Updates the state of the game/animation based on the
     amount of elapsed time that has passed.
     */
    public void update(long elapsedTime) {
        // do nothing
    }
    /**
     Draws to the screen. Subclasses must override this
     method.
     */
    public abstract void draw(Graphics2D g);
}
