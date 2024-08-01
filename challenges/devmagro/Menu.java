package Desafio1;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Menu {
    static String caminho;
    static int numeroDePerguntas;

    public static void main(String[] args) {
        caminho = getAbsolutePath();

        numeroDePerguntas = Arquivo.contarPerguntas();
        Arquivo.inicializarPasta();

        Scanner scanner = new Scanner(System.in);
        int opcao;
        System.out.println("Olá! Bem vindo ao sistema de cadastro. Digite opção desejada:");
        System.out.println("1 - Cadastrar o usuário");
        System.out.println("2 - Listar todos usuários cadastrados");
        System.out.println("3 - Cadastrar nova pergunta no formulário");
        System.out.println("4 - Deletar pergunta do formulário");
        System.out.println("5 - Pesquisar usuário por nome ou idade ou email");
        System.out.println("6 - Encerrar o programa.");
        do {
            opcao = scanner.nextInt();
            if (opcao < 7 && opcao > 0) {
                break;
            }
            System.out.println("Opção inválida, tente novamente.");
        } while (true);
        switch (opcao) {
            case 1:
                cadastrarUsuario();
                aperteParaContinuar(args);
                break;
            case 2:
                listarUsuarios();
                aperteParaContinuar(args);
                break;
            case 3:
                cadastrarPergunta();
                atualizar();
                aperteParaContinuar(args);
                break;
            case 4:
                deletarPergunta();
                atualizar();
                aperteParaContinuar(args);
                break;
            case 5:
                pesquisarUsuarios();
                aperteParaContinuar(args);
                break;
            case 6:
                System.out.println("Programa encerrado.");
                break;
        }
    }

    public static void cadastrarUsuario(){
        System.out.println("Cadastro de novo usuário:");
        String[] respostas = new String[numeroDePerguntas];

        Pergunta.responderPerguntasFixas(respostas);
        if (Menu.numeroDePerguntas>4) {
            Pergunta.responderDemaisPerguntas(respostas);
        }

        Usuario usuario = new Usuario(respostas);
        Usuario.salvarUsuario(usuario);

        System.out.println("Usuário cadastrado com sucesso!");
    }

    public static void listarUsuarios(){
        System.out.println("Essa é a lista com os usuários cadastrados:");
        Arquivo.listarUsuarios();
    }

    public static void cadastrarPergunta(){
        System.out.println("Cadastro de nova pergunta:");
        String[] novoPerguntas = Pergunta.adicionarPergunta();
        Arquivo.perguntasParaArquivo(caminho, novoPerguntas);
        System.out.println("Pergunta cadastrada com sucesso!");
    }

    public static void deletarPergunta(){
        System.out.println("Deletar uma pergunta:");
        String[] novoPerguntas = Pergunta.deletarPergunta();
        Arquivo.perguntasParaArquivo(caminho, novoPerguntas);
        System.out.println("Pergunta deletada com sucesso!");
    }

    public static void pesquisarUsuarios(){
         Arquivo.pesquisarUsuarios();
    }

    public static String getAbsolutePath() {
        File teste = new File("Menu.java");
        return teste.getAbsolutePath().replace("Menu.java","");
    }

    public static void atualizar(){
        Pergunta.perguntas = Arquivo.arquivoParaPerguntas(caminho);
        numeroDePerguntas = Arquivo.contarPerguntas();
    }

    public static void aperteParaContinuar(String[] args) {
        System.out.println("Aperte enter para continuar.");
        try {
            System.in.read();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        atualizar();
        Menu.main(args);
    }
}
