package Exercises.Projetinhos.CampoMinado;

import java.util.Scanner;

public class MineSweeper {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Board.distributeMines(Game.minesNumber);
        Board.printTable();
        Board.boardCalculate();
        System.out.println("Olá. Bem vindo ao Campo Minado!");
        do {
            Board.printTable();
            Board.printRevealedTable();
            do {
                System.out.println("Digite a linha que deseja jogar");
                Game.line = input.nextShort();
                System.out.println("Digite a coluna que deseja jogar");
                Game.row = input.nextShort();
            } while (!Board.checkValidPlay(Game.line, Game.row));//método de checagem de jogada válida
            Game.open( (Game.line), (Game.row));
        } while (Game.running);
        Board.printTable();
        System.out.println("O jogo terminou!!!");
    }
}


