package Exercises.Projetinhos.JogoDaVelha;

public class Board{
    public static char[][] table = new char[3][3];
    public static char[] pSymbol = new char[2];

    static {
        for (int i = 0;i<3;i++){
            for (int j = 0;j<3;j++){
                table[i][j] = ' ';
            }
        }
    }

    public static void setPSymbol(char symbol){
        if (symbol == 'X'){
            pSymbol[0] = 'X';
            pSymbol[1] = 'O';
        } else{
            pSymbol[0] = 'O';
            pSymbol[1] = 'X';
        }
    }

    public static void play(int line, int row, char symbol){
        table[line-1][row-1] = symbol;
    }

    public static void printTable(){
        System.out.println(" |1|2|3|");
        System.out.println("1|" + table[0][0] + "|" + table[0][1] + "|" + table[0][2] + "|");
        System.out.println("2|" + table[1][0] + "|" + table[1][1] + "|" + table[1][2] + "|");
        System.out.println("3|" + table[2][0] + "|" + table[2][1] + "|" + table[2][2] + "|");
    }
}
