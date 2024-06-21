package Exercises.Projetinhos.JogoDaVelha;

public class Game {
    static short line;
    static short row;
    static boolean win = false;
    static short pTurn = 1;
    static short turn = 0;
    static short[] canCrossWin = {0,0};
    static short[][] linePoints = new short[2][3];
    static short[][] rowPoints = new short[2][3];

    static {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                linePoints[i][j] = 0;
                rowPoints[i][j] = 0;
            }
        }
    }

    public static void addLinePoint(short player, short line) {
        linePoints[player][line]++;
        if (linePoints[player][line] == 3) {
            System.out.println("Vitória do jogador " + Game.pTurn + "!");
            win = true;
        }
    }

    public static void addRowPoint(short player, short row) {
        rowPoints[player][row]++;
        if (rowPoints[player][row] == 3) {
            System.out.println("Vitória do jogador " + Game.pTurn + "!");
            win = true;
        }
    }

    public static void checkWin(int player) {
        if (canCrossWin[player] == 19 || canCrossWin[player] == 13) {//checa se existe vitória na diagonal
            win = true;
            System.out.println("Vitória do jogador " + Game.pTurn + "!");
        }
        if (turn == 9) {//o controlador de jogadas contou 9, mas não percebeu vitória, logo deu velha.
            System.out.println("Deu velha!!!");
        }
    }

    public static void nextTurn() {
        if (pTurn == 1) {
            pTurn = 2;
        } else {
            pTurn = 1;
        }
        turn++;
    }

    public static void checkCross(int player, int line, int row) {
        if (line == 2 && row == 2) {
            canCrossWin[player - 1] += 1;
        }
        if (line == 1 && row == 1) {
            canCrossWin[player - 1] += 2;
        }
        if (line == 1 && row == 3) {
            canCrossWin[player - 1] += 4;
        }
        if (line == 3 && row == 1) {
            canCrossWin[player - 1] += 8;
        }
        if (line == 3 && row == 3) {
            canCrossWin[player - 1] += 16;
        }
    }

    public static boolean checkValidPlay(int line, int row) {
        if (!(Board.table[line - 1][row - 1] == ' ')) {
            System.out.println("Jogada inválida. Tente novamente!");
        }
        return (Board.table[line - 1][row - 1] == ' ');
    }
}
