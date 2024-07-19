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
        String[] perguntas = salvarPerguntas(buffPergunta, AdicionarPerguntas.contarPerguntas());
        int i = Integer.parseInt((args[0]));
        System.out.println(perguntas[i]);
    }

    public static String lerLinhas(BufferedReader buff) {
        try {
            return buff.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String[] salvarPerguntas(BufferedReader buff, int numeroDePerguntas) {
        String[] perguntas = new String[numeroDePerguntas];
        for (int i = 0; i < 4; i++) {
            perguntas[i] = lerLinhas(buff);
        }
        return perguntas;
    }
}
