package krestNullSwing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class GameMap extends JPanel {

    private final int EMPTY_DOT = 0;
    private final int HUMAN_DOT = 1;
    private final int AI_DOT = 2;

    public final Random RANDOM = new Random();

    public static final int GAME_MODE_HVH = 0;
    public static final int GAME_MODE_HVA = 1;

    private final int STATE_DRAW = 0;
    private final int STATE_HUMAN_WIN = 1;
    private final int STATE_AI_WIN = 2;
    private int currentStateGameOver;

    private boolean isGameOver;
    private boolean isExistMap;

    private int gameMode;
    private int fieldSizeX;
    private int fieldSizeY;
    private int winLength;
    private int[][] field;

    private int cellWidth;
    private int cellHeight;

    GameMap(){
        setBackground(Color.BLACK);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                update(e);
            }
        });
        isExistMap = false;
    }

    void start(int gameMode, int fieldSizeX, int fieldSizeY, int winLength){
        System.out.println("Игра началась\n\n"+ "gameMode: "+ gameMode+"\nfieldSizeX: "+fieldSizeX+
                "\nfieldSizeY: "+fieldSizeY+"\nwinLength: "+winLength);

            this.gameMode = gameMode;
            this.fieldSizeX = fieldSizeX;
            this.fieldSizeY = fieldSizeY;
            this.winLength = winLength;
            field = new int[fieldSizeX][fieldSizeY];
            isGameOver = false;
            isExistMap = true;
            repaint();
    }

    private void update(MouseEvent e) {
        if (!isExistMap) return;
        if (isGameOver) return;

        int cellX = e.getX() / cellWidth;
        int cellY = e.getY() / cellHeight;

        if (!isValidCell(cellX, cellY) || !isEmptyCell(cellX, cellY)) {
            return;
        }

        field[cellY][cellX] = HUMAN_DOT;

        if (checkWin(HUMAN_DOT)) {
            setGameOver(STATE_HUMAN_WIN);
            return;
        }

        if (isFullMap()) {
            setGameOver(STATE_DRAW);
            return;
        }

        aiTurn();
        repaint();
        if (checkWin(AI_DOT)) {
            setGameOver(STATE_AI_WIN);
            return;
        }

        if (isFullMap()) {
            setGameOver(STATE_DRAW);
            return;
        }

    }

    private void setGameOver(int gameOverState) {
        currentStateGameOver = gameOverState;
        isGameOver = true;
        repaint();
    }

    private void render(Graphics g) {

        int width = getWidth();
        int height = getHeight();

        cellWidth = width / fieldSizeX;
        cellHeight = height / fieldSizeY;
        g.setColor(Color.WHITE);

        for (int i = 0; i <= fieldSizeY; i++) {
            int y = i * cellHeight;
            g.drawLine(0, y, width, y);
        }

        for (int i = 0; i <= fieldSizeX; i++) {
            int x = i * cellWidth;
            g.drawLine(x, 0, x, height);
        }

        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {

                if (isEmptyCell(x, y)) {
                    continue;
                }

                if (field[y][x] == HUMAN_DOT) {
                    g.setColor(new Color(1, 1, 255));
                    g.fillOval(x * cellWidth, y * cellHeight, cellWidth, cellHeight);
                } else if (field[y][x] == AI_DOT) {
                    g.setColor(Color.RED);
                    g.fillOval(x * cellWidth, y * cellHeight, cellWidth, cellHeight);
                } else {
                    throw new RuntimeException("Ошибка при отрисовке X: " + x + " Y: " + y);
                }

            }
        }

        if (isGameOver) {
            showMessageGameOverState(g);
        }

    }

    private void showMessageGameOverState(Graphics g){
        g.setColor(Color.GREEN);
        g.fillRect(0, 200, getWidth(), 60);
        g.setColor(Color.MAGENTA);
        g.setFont(new Font("Times New Roman", Font.BOLD, 40));

        switch (currentStateGameOver) {
            case STATE_DRAW:
                g.drawString("Ничья", 170, getHeight() / 2);
                break;
            case STATE_HUMAN_WIN:
                g.drawString("Победил человек", 100, getHeight() / 2);
                break;
            case STATE_AI_WIN:
                g.drawString("Победил ИИ", 130, getHeight() / 2);
                break;
            default:
                throw new RuntimeException("Непредвиденная ошибка: " + currentStateGameOver);
        }
    }

    private void aiTurn() {
        if (turnAIWinCell()) { //выиграет ли игрок на следующем ходу?
            return;
        }
        if (turnHumanWinCell()) { //выиграет ли комп на следующем ходу?
            return;
        }
        int x;
        int y;
        do {
            x = RANDOM.nextInt(fieldSizeX);
            y = RANDOM.nextInt(fieldSizeY);
        } while (!isEmptyCell(x, y));
        field[y][x] = AI_DOT;
    }

    private boolean turnAIWinCell() {
        for (int i = 0; i < fieldSizeY; i++) {
            for (int j = 0; j < fieldSizeX; j++) {
                if (isEmptyCell(j, i)) {
                    field[i][j] = AI_DOT;    // поставим нолик в каждую клетку поля по очереди
                    if (checkWin(AI_DOT)) {
                        return true;    // если мы выиграли, вернём истину, оставив нолик в выигрышной позиции
                    }
                    field[i][j] = EMPTY_DOT;    // если нет - вернём обратно пустоту в клетку и пойдём дальше
                }
            }
        }
        return false;
    }

    // Проверка, выиграет-ли игрок своим следующим ходом
    private boolean turnHumanWinCell() {
        for (int i = 0; i < fieldSizeY; i++) {
            for (int j = 0; j < fieldSizeX; j++) {
                if (isEmptyCell(j, i)) {
                    field[i][j] = HUMAN_DOT;     // поставим крестик в каждую клетку по очереди
                    if (checkWin(HUMAN_DOT)) {    // если игрок победит
                        field[i][j] = AI_DOT;    // поставить на то место нолик
                        return true;
                    }
                    field[i][j] = EMPTY_DOT;    // в противном случае вернуть на место пустоту
                }
            }
        }
        return false;
    }

    // проверка на победу
    private boolean checkWin(int characterSymbol) {
        for (int i = 0; i < fieldSizeX; i++) {     // ползём по всему полю
            for (int j = 0; j < fieldSizeY; j++) {
                if (checkLine(i, j, 1, 0, winLength, characterSymbol)) {
                    return true;    // проверим линию по х
                }
                if (checkLine(i, j, 1, 1, winLength, characterSymbol)) {
                    return true;    // проверим по диагонали х у
                }
                if (checkLine(i, j, 0, 1, winLength, characterSymbol)) {
                    return true;    // проверим линию по у
                }
                if (checkLine(i, j, 1, -1, winLength, characterSymbol)) {
                    return true;    // проверим по диагонали х -у
                }
            }
        }
        return false;
    }

    // проверка линии
    private boolean checkLine(int x, int y, int vx, int vy, int len, int characterSymbol) {
        final int farX = x + (len - 1) * vx;    // посчитаем конец проверяемой линии
        final int farY = y + (len - 1) * vy;
        if (!isValidCell(farX, farY)) {
            return false;    // проверим не выйдет-ли проверяемая линия за пределы поля
        }
        for (int i = 0; i < len; i++) {    // ползём по проверяемой линии
            if (field[y + i * vy][x + i * vx] != characterSymbol) {
                return false;    // проверим одинаковые-ли символы в ячейках
            }
        }
        return true;
    }

    private boolean isFullMap() {
        for (int i = 0; i < fieldSizeY; i++) {
            for (int j = 0; j < fieldSizeX; j++) {
                if (field[i][j] == EMPTY_DOT) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValidCell(int x, int y) {
        return x >= 0 && x < fieldSizeX && y >= 0 && y < fieldSizeY;
    }

    private boolean isEmptyCell(int x, int y) {
        return field[y][x] == EMPTY_DOT;
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        render(g);
    }
}
