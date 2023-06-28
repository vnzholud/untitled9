package krestNullSing;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsWindow extends JFrame {

    private final int WIN_WIDTH = 350;
    private final int WIN_HEIGHT = 300;

    private final int MIN_FIELD_SIZE = 3;
    private final int MAX_FIELD_SIZE = 10;

    private final int MIN_WIN_LENGTH = 3;

    private GameWindow gameWindow;

    private JRadioButton humanVsHuman;
    private JRadioButton humanVsAi;
    private JSlider sliderWinLength;
    private JSlider sliderFielSize;
    private JButton btnStart;

    private final String FIELD_SIZE_PREFIX = "Размер поля: ";
    private final String WIN_LENGTH_PREFIX = "Выиграшная длинна: ";

    SettingsWindow(GameWindow gameWindow) {
        this.gameWindow = gameWindow;
        setSize(WIN_WIDTH,WIN_HEIGHT);

        Rectangle gameWindowBounds = gameWindow.getBounds();
        int posX = (int) gameWindowBounds.getCenterX() - WIN_WIDTH/2;
        int posY = (int) gameWindowBounds.getCenterY() - WIN_HEIGHT/2;

        setLocation(posX,posY);
        setResizable(false);
        setTitle("Enter Your New Game");

        setLayout(new GridLayout(10,1));
        gameModeControl();
        fieldSizeAndWinControl();

        btnStart = new JButton("Start Game!");
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonClickMethod();
            }
        });

        add(btnStart);

    }

    private void gameModeControl(){

        add(new JLabel("Выбирите режим игры"));
        humanVsHuman = new JRadioButton("Человек против Человека",true);
        humanVsAi = new JRadioButton("Человек против ИИ");

        ButtonGroup gameMode = new ButtonGroup();
        gameMode.add(humanVsHuman);
        gameMode.add(humanVsAi);

        add(humanVsHuman);
        add(humanVsAi);


    }

    private void fieldSizeAndWinControl(){
        JLabel labelFieldSize = new JLabel(FIELD_SIZE_PREFIX + MIN_FIELD_SIZE);
        JLabel labelWinLength = new JLabel(WIN_LENGTH_PREFIX + MIN_WIN_LENGTH);

        sliderFielSize = new JSlider(MIN_FIELD_SIZE,MAX_FIELD_SIZE,MIN_FIELD_SIZE);
        sliderFielSize.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int currentValue = sliderFielSize.getValue();
                labelFieldSize.setText(FIELD_SIZE_PREFIX + currentValue);
                sliderWinLength.setMaximum(currentValue);
            }
        });

        sliderWinLength = new JSlider(MIN_WIN_LENGTH,MAX_FIELD_SIZE,MIN_FIELD_SIZE);
        sliderWinLength.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
               labelWinLength.setText(WIN_LENGTH_PREFIX + sliderWinLength.getValue());
            }
        });

        add(new JLabel("Выбирите размер поля: "));
        add(labelFieldSize);
        add(sliderFielSize);

        add(new JLabel("Выбирите длинну выигрышной позиции: "));
        add(labelWinLength);
        add(sliderWinLength);
    }

    private void buttonClickMethod(){

        int gameMode;

        if (humanVsHuman.isSelected()){
            gameMode = GameMap.GAME_MODE_HVH;
        } else if (humanVsAi.isSelected()){
            gameMode = GameMap.GAME_MODE_HVA;
        } else {
            throw new RuntimeException("Неизвестный тип игры");
        }

        int fieldSize = sliderFielSize.getValue();
        int winLength = sliderWinLength.getValue();


      gameWindow.startNewGame(gameMode, fieldSize,fieldSize,winLength);
        setVisible(false);
    }
}
