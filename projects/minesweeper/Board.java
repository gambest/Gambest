package Exercises.Projetinhos.CampoMinado;

import java.util.Random;

public class Board {
    public static char[][] table = new char[10][10];
    public static int minesNumber;

    public static void main(String[] args) {
        distributeMines(10);
    }

    static {
        for (int i = 0;i<10;i++){
            for (int j = 0;j<10;j++){
                table[i][j] = ' ';
            }
        }
    }

    public static boolean checkValidPlay(int line, int row) {
        if (!(table[line][row] == ' ') || (line == 0 || row == 0)) {
            System.out.println("Jogada inválida. Tente novamente!");
        }
        return (table[line][row] == ' ');
    }

    public static void printTable(){
        for (int i = 0; i < 10; i++) {
            System.out.print(i + " | ");
        }
        System.out.println();
        for (int i = 1; i < 10; i++) {
            System.out.print(i);
            for (int j = 0; j < 10; j++) {
                System.out.print(" | " + table[i][j]);
            }
            System.out.println();
        }
    }

    public static void distributeMines(int minesNumber){
        Random randomizer = new Random();

        for (int i = 0; i < minesNumber ; i++) {
            while (true){
                int j = randomizer.nextInt(minesNumber - 2) + 1;
                int k = randomizer.nextInt(minesNumber - 2) + 1;
                if (table[j][k] !='M'){
                    table[j][k] = 'M';
                    break;
                }
            }
        }
        printTable();
    }
}
