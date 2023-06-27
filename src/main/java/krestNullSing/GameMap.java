package krestNullSing;

import javax.swing.*;
import java.awt.*;

public class GameMap extends JPanel {

    GameMap(){
        setBackground(Color.BLACK);
    }

    void start(int gameMode, int fieldSizeX, int fieldSizeY, int winLength){
        System.out.println("Игра началась\n"+ "gameMode: "+ gameMode+"\nfieldSizeX: "+fieldSizeX+
                "\nfieldSizeY: "+fieldSizeY+"\nwinLength: "+winLength);
    }
}
