package Desafio1;

import java.io.*;
import java.util.Scanner;

public class AdicionarPerguntas {
    public static void adicionarPergunta(){
        Scanner leitor = new Scanner(System.in);
        int numeroDePerguntas = contarPerguntas();

        System.out.println("Digite a pergunta que deseja adicionar:");
        String pergunta = leitor.nextLine();

        pergunta = (numeroDePerguntas + 1 ) + " - " + pergunta;
        System.out.println("\n" + pergunta);

        File arquivo = new File("C:\\Users\\DELL\\IdeaProjects\\Java\\challenges\\devmagro\\Perguntas.txt");


        FileReader ler;
        try {
            ler = new FileReader(arquivo);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        BufferedReader buffLer = new BufferedReader(ler);
        String[] perguntas = LerPerguntas.salvarPerguntas(buffLer,contarPerguntas());

        try (FileWriter escritor = new FileWriter(arquivo)) {
            BufferedWriter buffEscritor = new BufferedWriter(escritor);
            for (int i = 0; i < numeroDePerguntas ; i++) {
                buffEscritor.write( perguntas[i] + "\n");
            }
            buffEscritor.write(pergunta);
            buffEscritor.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static int contarPerguntas() {
        File arquivo = new File("C:\\Users\\DELL\\IdeaProjects\\Java\\challenges\\devmagro\\Perguntas.txt");

        int numeroDePerguntas = 0;
        try (FileReader leitor = new FileReader(arquivo)) {
            BufferedReader buffLeitor = new BufferedReader(leitor);
            for (int i = 0; i <= numeroDePerguntas; i++) {
                String line = buffLeitor.readLine();
                if (line != null) {
                    numeroDePerguntas++;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return numeroDePerguntas;
    }
}
