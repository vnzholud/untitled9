package krestNullSing;

import javax.swing.*;

public class SettingsWindow extends JFrame {

    private final int WIN_WIDTH = 350;
    private final int WIN_HEIGHT = 300;

    private GameWindow gameWindow;

    SettingsWindow(GameWindow gameWindow) {
        this.gameWindow = gameWindow;
        setSize(WIN_WIDTH,WIN_HEIGHT);


    }
}
