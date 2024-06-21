package Exercises.Projetinhos.JogoDaVelha;

import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Olá. Bem vindo ao Jogo da Velha!");
        System.out.println("Você é o jogador 1! Digite o simbolo que quer jogar (X) ou (O)");
        Board.setPSymbol(input.next().charAt(0));
        do {
            Board.printTable();
            do {
                System.out.println("É a vez do jogador " + (Game.pTurn) + "(" + Board.pSymbol[Game.pTurn-1] + ")");
                System.out.println("Digite a linha que deseja jogar");
                Game.line = input.nextShort();
                System.out.println("Digite a coluna que deseja jogar");
                Game.row = input.nextShort();
            } while (!Game.checkValidPlay(Game.line, Game.row));
            Board.play(Game.line,Game.row,Board.pSymbol[Game.pTurn-1]);
            Game.checkCross(Game.pTurn, Game.line, Game.row);
            Game.addLinePoint((short) (Game.pTurn-1), (short) (Game.line-1));
            Game.addRowPoint((short) (Game.pTurn-1), (short) (Game.row-1));
            Game.checkWin(Game.pTurn-1);
            Game.nextTurn();
        } while (!Game.win);
        Board.printTable();
        System.out.println("O jogo terminou!!!");
    }

}
