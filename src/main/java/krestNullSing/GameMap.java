package krestNullSing;

import javax.swing.*;
import java.awt.*;

public class GameMap extends JPanel {

    public static final int GAME_MODE_HVH = 0;
    public static final int GAME_MODE_HVA = 1;

    GameMap(){
        setBackground(Color.BLACK);
    }

    void start(int gameMode, int fieldSizeX, int fieldSizeY, int winLength){
        System.out.println("Игра началась\n\n"+ "gameMode: "+ gameMode+"\nfieldSizeX: "+fieldSizeX+
                "\nfieldSizeY: "+fieldSizeY+"\nwinLength: "+winLength);
    }
}
