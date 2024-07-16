package Desafio1;

import java.io.*;

public class LerPerguntas {
    public static void main(String[] args) {
        File arquivo = new File("challenges/devmagro/Perguntas.txt");
        FileReader pergunta;

        try {
            pergunta = new FileReader(arquivo);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        BufferedReader buffPergunta = new BufferedReader(pergunta);
        //int numeroDeLinhas = contarLinhas(buffPergunta);
        String[] perguntas = salvarPerguntas(buffPergunta);
        Integer i = Integer.valueOf((args[0]));
        //for (int i = 0; i < 4; i++) {
            System.out.println(perguntas[i]);


        //}
    }

    public static String lerLinhas(BufferedReader buff) {
        try {
            return buff.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static int contarLinhas(BufferedReader buff) {
        int linesNumber = 0;
        while (true) {
            String linhaLida = lerLinhas(buff);
            if (linhaLida != null) {
                linesNumber++;
            } else {
                break;
            }
        }
        return linesNumber;
    }

    public static String[] salvarPerguntas(BufferedReader buff) {
        String[] perguntas = new String[4];
        for (int i = 0; i < 4; i++) {
            perguntas[i] = lerLinhas(buff);
        }
        return perguntas;
    }

    public static String printarPerguntaI(int numeroDaPergunta){
        System.out.println();
        return " ";
    }
}
