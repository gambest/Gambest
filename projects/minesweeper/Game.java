package Exercises.Projetinhos.CampoMinado;

public class Game {
    static short line;
    static short row;
    static boolean running = true;
    static int minesNumber = 10;

    public static void reveal(int line, int row){
        Board.revealedTable[line][row] = Board.table[line][row];
    }

    public static void open(int line, int row){
        if (Board.table[line][row] == 'M'){
            System.out.println("Você encontrou uma mina! Jogo terminado.");
            running = false;
        } else {
            Board.revealedTable[line][row] = Board.table[line][row];
            Board.openVoidSquares(line,row);
        }
    }
}
