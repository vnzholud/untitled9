package krestnull;

import java.util.Scanner;

public class KrestNullApplication {
    static Scanner scanner;
    static char[][] map;

    static final int MAP_SIZE = 3;

    static final char EMPTY_FIELD = '*';
    static final char X_FIELD = 'X';
    static final char O_FIELD = '0';

    public static void main(String[] args) {

        init();
        printMap();
        while (true){
            humanTurn();
            printMap();
            if (checkDraft()){
                System.out.println("Игра завершина. Ничья.");
                break;
            }
            compTurn();
            printMap();
            if (checkDraft()){
                System.out.println("Игра завершина. Ничья.");
                break;
            }
        }


    }

    public static boolean checkDraft(){
        for (int i = 0; i < MAP_SIZE; i++) {
            for (int j = 0; j < MAP_SIZE; j++) {
                if (map[i][j] == EMPTY_FIELD){
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isCellValid(int x, int y){
        if(x < 0 || y < 0 || x >= MAP_SIZE || y >= MAP_SIZE){
            System.out.println("Вы ввели некорректные координаты. Они должны быть не больше " + MAP_SIZE + " и не равны 0");
            return false;

        }
        if (map[x][y] != EMPTY_FIELD) {
            System.out.println("Вы ввели некорректные координаты. Они должны быть не больше " + MAP_SIZE + " и не равны 0");
            return false;
        }
        return true;
    }

    public static void compTurn(){
        int x, y;

        do {

            x = (int) Math.random()*MAP_SIZE;
            y = (int) Math.random()*MAP_SIZE;
            System.out.println("Компьютер ввёл координаты Х = " + (x+1) + " Y = " + (y+1));
        } while (!isCellValid(x,y));


        map[x][y] = O_FIELD;
    }

    public static void humanTurn(){
        int x, y;

        do {
            System.out.println("Введите координаты Вашего хода X Y");

            x = scanner.nextInt() - 1;
            y = scanner.nextInt() -1;
            System.out.println("Вы ввели координаты Х = " + (x+1) + " Y = " + (y+1));
        } while (!isCellValid(x,y));


        map[x][y] = X_FIELD;
    }

    public static void printMap(){
        // 0 1 2 3
        // 1 * * *
        // 2 * * *
        // 3 * * *

        for (int i = 0; i <= MAP_SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < MAP_SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < MAP_SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void init(){
        map = new char [MAP_SIZE][MAP_SIZE];
        for (int i = 0; i < MAP_SIZE; i++) {
            for (int j = 0; j < MAP_SIZE; j++) {
                map[i][j] = EMPTY_FIELD;

            }
        }
        scanner = new Scanner(System.in);
    }
}
