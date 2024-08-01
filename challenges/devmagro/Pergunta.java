package Desafio1;

import java.util.Scanner;

public class Pergunta {
    static String[] perguntas;

    static {
        perguntas = Arquivo.arquivoParaPerguntas(Menu.caminho);
    }

    public static String[] adicionarPergunta() {
        Scanner scanner = new Scanner(System.in);
        String[] novoPerguntas = new String[perguntas.length + 1];

        System.out.println("Digite a pergunta que deseja adicionar:");
        String pergunta = scanner.nextLine();

        System.arraycopy(perguntas, 0, novoPerguntas, 0, perguntas.length);
        novoPerguntas[perguntas.length] = pergunta;

        return novoPerguntas;
    }

    public static String[] deletarPergunta() {
        Scanner scanner = new Scanner(System.in);
        String[] novoPerguntas = new String[perguntas.length - 1];

        System.out.println("Digite o número da pergunta que deseja remover:");
        int numeroDaPergunta = scanner.nextInt();
        scanner.nextLine();

        if (numeroDaPergunta - 1 >= 0) System.arraycopy(perguntas, 0, novoPerguntas, 0, numeroDaPergunta - 1);
        if (perguntas.length - numeroDaPergunta >= 0)
            System.arraycopy(perguntas, numeroDaPergunta - 1, novoPerguntas, numeroDaPergunta, perguntas.length - numeroDaPergunta);

        return novoPerguntas;
    }

    public static String[] responderPerguntasFixas(String[] respostas) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(perguntas[0]);
        respostas[0] = scanner.nextLine();
        if (respostas[0].length() < 10)
            throw new RespostaInvalidaException("Nome inválido. Deve conter mais de 10 letras!");

        System.out.println(perguntas[1]);
        respostas[1] = scanner.nextLine();
        if (!respostas[1].contains("@")) throw new RespostaInvalidaException("Email inválido. Deve conter um '@'!");
        if (Arquivo.verificarEmailDuplicado(respostas[1])) throw new RespostaInvalidaException("Email já cadastrado!");

        System.out.println(perguntas[2]);
        respostas[2] = scanner.nextLine();
        if (Integer.parseInt(respostas[2]) < 18)
            throw new RespostaInvalidaException("Idade não permitida! Só é possivel cadastrar maiores de 18!");


        System.out.println(perguntas[3]);
        respostas[3] = scanner.nextLine();
        respostas[3] = respostas[3].replaceAll(",", ".");
        if (!respostas[3].contains("."))
            throw new RespostaInvalidaException("Formato de altura inválido! Deve ser escrita como em '1,62'!");
        return respostas;
    }

    public static String[] responderDemaisPerguntas(String[] respostas) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 4; i < respostas.length; i++) {
            System.out.println(perguntas[i]);
            respostas[i] = scanner.nextLine();
        }
        return respostas;
    }

}
