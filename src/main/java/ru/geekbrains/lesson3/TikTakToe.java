package ru.geekbrains.lesson3;

import java.util.Random;
import java.util.Scanner;

public class TikTakToe {
    private static final char DOT_HUMAN = 'X';
    private static final char DOT_AI = '0';
    private static final char DOT_EMPTY = '.';
    private static final char DOT_FALSE = '~';
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Random RANDOM = new Random();
    private static  char[][] field;
    private static int fieldSizeX;
    private static int fieldSizeY;
    private static int qFill;

    private static int scoreHuman = 0;
    private static int scoreAi = 0;

    public static void main(String[] args) {
        while (true) {
            initField();
            printField();
            while (true) {
                humanTurn();
                printField();
                if (gameCheck(DOT_HUMAN, "HUMAN wins!!!")) {
                    break;
                }
                aiTurn();
                printField();
                if (gameCheck(DOT_AI, "AI wins!!!")) {
                    break;
                }
            }
            System.out.printf("SCORE IS: HUMAN  AI\n            %d    %d\n", scoreHuman, scoreAi);
            System.out.println("Wanna play again? >> Y or N");
            if (!SCANNER.next().toLowerCase().equals("y")) break;
        }
    }

    private static boolean gameCheck(char dot, String s) {
        if (checkWin() == dot) {
            switch (dot) {
                case DOT_HUMAN:
                    scoreHuman++;
                    break;
                case DOT_AI:
                    scoreAi++;
                    break;
            }
            System.out.println(s);
            return true;
        }
        if (checkDraw()) {
            System.out.println("DRAW!!!");
            return true;
        }
        return false;
    }
    
    private static boolean checkDraw() {
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if (isCellEmpty(x, y)) return false;
            }
        }
        return true;
    }
    
    private static char checkWin(){
        char elem;
        char elemD;
        int qf;
        int qfD;
        // горизонтали
        for (int y = 0; y < fieldSizeY; y++) {
            elem = field[y][0];
            qf = 1;
            for (int x = 1; x < fieldSizeX; x++) {
                if (field[y][x] == elem) {
                    if (++qf == qFill) return elem;
                }
                else {
                    elem = field[y][x];
                    qf = 1;
                }
            }
        }
        // вертикали
        for (int x = 0; x < fieldSizeX; x++) {
            elem = field[0][x];
            qf = 1;
            for (int y = 1; y < fieldSizeX; y++) {
                if (field[y][x] == elem) {
                    if (++qf == qFill) return elem;
                }
                else {
                    elem = field[y][x];
                    qf = 1;
                }
            }
        }
        // диагонали левой верхней части
        for (int y = fieldSizeY - 1; y >= 0; y--) {
            elem = elemD = field[y][0];
            qf = qfD = 1;
            for (int x = 1; x < fieldSizeX; x++) {
                if (y - x >= 0) {
                    if (field[y - x][x] == elem) {
                        if (++qf == qFill) return elem;
                    }
                    else {
                        elem = field[y - x][x];
                        qf = 1;
                    }
                }
                if (y + x <= fieldSizeY - 1) {
                    if (field[y + x][x] == elemD) {
                        if (++qf == qFill) return elem;
                    }
                    else {
                        elemD = field[y + x][x];
                        qfD = 1;
                    }
                }
            }
        }
        // диагонали правой нижней части
        for (int x = fieldSizeX - 1; x >= 0; x--) {
            elem = elemD = field[0][x];
            qf = qfD = 1;
            for (int y = 1; y < fieldSizeY; y++) {
                if (x - y >= 0) {
                    if (field[x - y][y] == elem) {
                        if (++qf == qFill) return elem;
                    }
                    else {
                        elem = field[x - y][y];
                        qf = 1;
                    }
                }
                if (x + y <= fieldSizeX - 1) {
                    if (field[x + y][y] == elemD) {
                        if (++qf == qFill) return elem;
                    }
                    else {
                        elemD = field[x + y][y];
                        qfD = 1;
                    }
                }
            }
        }
        return DOT_FALSE;

        /*
        // hor
        if (field[0][0] == c && field[0][1] == c && field[0][2] == c) return true;
        if (field[1][0] == c && field[1][1] == c && field[1][2] == c) return true;
        if (field[2][0] == c && field[2][1] == c && field[2][2] == c) return true;

        // ver
        if (field[0][0] == c && field[1][0] == c && field[2][0] == c) return true;
        if (field[0][1] == c && field[1][1] == c && field[2][1] == c) return true;
        if (field[0][2] == c && field[1][2] == c && field[2][2] == c) return true;

        // dia
        if (field[0][0] == c && field[1][1] == c && field[2][2] == c) return true;
        if (field[0][2] == c && field[1][1] == c && field[2][0] == c) return true;
        return false;*/
    }

    private static void aiTurn(){
        int x;
        int y;

        do {
            x = RANDOM.nextInt(fieldSizeX);
            y = RANDOM.nextInt(fieldSizeY);
        } while (!isCellEmpty(x, y));
        field[y][x] = DOT_AI;
    }

    private static void humanTurn() {
        int x;
        int y;

        do {
            System.out.println("Введите координаты x и y через пробел >>>>");
            x = SCANNER.nextInt() - 1;
            y = SCANNER.nextInt() - 1;
        } while (!isCellValid(x, y) || !isCellEmpty(x, y));
        field[y][x] = DOT_HUMAN;
    }

    private static boolean isCellValid(int x, int y){
        return x >= 0 && y >= 0 && x < fieldSizeX && y < fieldSizeY;
    }

    private static boolean isCellEmpty(int x, int y){
        return field[y][x] == DOT_EMPTY;
    }

    private static void initField(){
        fieldSizeY = 3;
        fieldSizeX = 3;
        qFill = 3; // кол-во фишек подряд, должно быть <= минимальному размеру поля
                    // но > половины максимального. Иначе нет смысла (наверно).
        field = new char[fieldSizeY][fieldSizeX];
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                field[y][x] = DOT_EMPTY;
            }
        }
    }

    private static void printField(){
        System.out.print("+");
        for (int x = 0; x < fieldSizeX * 2 + 1; x++)
            System.out.print((x % 2 == 0) ? "-" : x / 2 + 1);
        System.out.println();

        for (int y = 0; y < fieldSizeY; y++) {
            System.out.print(y + 1 + "|");
            for (int x = 0; x < fieldSizeX; x++)
                System.out.print(field[y][x] + "|");
            System.out.println();
        }
        for (int x = 0; x <= fieldSizeX * 2 + 1; x++)
            System.out.print("-");
        System.out.println();
    }
}
