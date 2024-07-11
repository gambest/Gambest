package Exercises.Projetinhos.CampoMinado;

import java.util.Random;

public class Board {
    public static char[][] table = new char[10][10];
    public static char[][] revealedTable = new char[10][10];
    public static int[][] minesPositions = new int[10][2];

    static {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                table[i][j] = '0';
                revealedTable[i][j] = ' ';
            }
        }
    }

    public static boolean checkValidPlay(int line, int row) {
        if (line == 0 || row == 0) {
            System.out.println("Jogada inválida. Tente novamente!");
            return false;
        }
        return true;
    }

    public static void printTable() {
        for (int i = 0; i < 10; i++) {
            System.out.print(i + " | ");
        }
        System.out.println();
        for (int i = 1; i < 10; i++) {
            System.out.print(i + " | ");
            for (int j = 1; j < 10; j++) {
                System.out.print(table[i][j] + " | ");
            }
            System.out.println();
        }
    }

    public static void printRevealedTable() {
        for (int i = 0; i < 10; i++) {
            System.out.print(i + " | ");
        }
        System.out.println();
        for (int i = 1; i < 10; i++) {
            System.out.print(i + " | ");
            for (int j = 1; j < 10; j++) {
                System.out.print(revealedTable[i][j] + " | ");
            }
            System.out.println();
        }
    }

    public static void distributeMines(int minesNumber) {
        Random randomizer = new Random();

        for (int i = 0; i < minesNumber; i++) {
            while (true) {
                int j = randomizer.nextInt(minesNumber - 2) + 1;
                int k = randomizer.nextInt(minesNumber - 2) + 1;
                if (table[j][k] != 'M') {
                    table[j][k] = 'M';
                    minesPositions[i][0] = j;
                    minesPositions[i][1] = k;
                    break;
                }
            }
        }
    }

    public static void boardCalculate() {
        for (int[] mine : minesPositions) {
            table[mine[0] - 1][mine[1] - 1]++;
            table[mine[0] - 1][mine[1]]++;
            table[mine[0] - 1][mine[1] + 1]++;
            table[mine[0]][mine[1] - 1]++;
            table[mine[0]][mine[1] + 1]++;
            table[mine[0] + 1][mine[1] - 1]++;
            table[mine[0] + 1][mine[1]]++;
            table[mine[0] + 1][mine[1] + 1]++;
        }
        for (int[] mine : minesPositions) {
            table[mine[0]][mine[1]] = 'M';
        }
    }

    public static void openVoidSquares(int line, int row) {
        if (line - 1 > 0) {
            if (Board.table[line - 1][row] == '0' && Board.revealedTable[line - 1][row] != '0') {
                revealAdjacentSquares(line - 1, row);
                openVoidSquares(line - 1, row);
            }
        }
        if (line + 1 < 10) {
            if (Board.table[line + 1][row] == '0' && Board.revealedTable[line + 1][row] != '0') {
                revealAdjacentSquares(line + 1, row);
                openVoidSquares(line + 1, row);
            }
        }
        if (row - 1 > 0) {
            if (Board.table[line][row - 1] == '0' && Board.revealedTable[line][row - 1] != '0') {
                revealAdjacentSquares(line, row - 1);
                openVoidSquares(line, row - 1);
            }
        }
        if (row + 1 < 10) {
            if (Board.table[line][row + 1] == '0' && Board.revealedTable[line][row + 1] != '0') {
                revealAdjacentSquares(line, row + 1);
                openVoidSquares(line, row + 1);
            }
        }
    }

    public static void revealAdjacentSquares(int line, int row) {
        if (line - 1 > 0 && row - 1 > 0) Game.reveal(line - 1, row - 1);
        if (line - 1 > 0) Game.reveal(line - 1, row);
        if (line - 1 > 0 && row + 1 < 10) Game.reveal(line - 1, row + 1);
        if (row - 1 > 0) Game.reveal(line, row - 1);
        Game.reveal(line,row);
        if (row + 1 < 10) Game.reveal(line, row + 1);
        if (line + 1 < 10 && row - 1 > 0) Game.reveal(line + 1, row - 1);
        if (line + 1 < 10) Game.reveal(line + 1, row);
        if (line + 1 < 10 && row + 1 < 10) Game.reveal(line + 1, row + 1);
    }
}
