package Desafio1;

import java.io.*;
import java.util.Scanner;

//FIXME - precisa reescrever as perguntas e corrigir o número dela após apagar uma.
public class DeletarPerguntas {
    public static void deletarPergunta() {
        Scanner leitor = new Scanner(System.in);
        int numeroDePerguntas = AdicionarPerguntas.contarPerguntas();
        System.out.println(numeroDePerguntas);
        int numeroDaPergunta;
        System.out.println("Digite a opção de pergunta que deseja remover");

        do {
            numeroDaPergunta = leitor.nextInt();
        } while ((numeroDaPergunta <= 4) || (numeroDaPergunta > numeroDePerguntas));

        File arquivo = new File("C:\\Users\\DELL\\IdeaProjects\\Java\\challenges\\devmagro\\Perguntas.txt");

        FileReader ler;
        try {
            ler = new FileReader(arquivo);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        BufferedReader buffLer = new BufferedReader(ler);
        String[] perguntas = LerPerguntas.salvarPerguntas(buffLer, numeroDePerguntas);

        try (FileWriter escritor = new FileWriter(arquivo)) {
            BufferedWriter buffEscritor = new BufferedWriter(escritor);
            for (int i = 0; i < numeroDePerguntas; i++) {
                if (i == numeroDaPergunta - 1) {
                    continue;
                }
                buffEscritor.write(perguntas[i] + "\n");
            }
            buffEscritor.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
