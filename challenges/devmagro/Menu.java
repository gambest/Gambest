package Desafio1;

import java.io.File;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
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
                System.out.println("Cadastro de novo usuário:");
                Usuario usuario = ResponderPerguntas.responderPerguntas();
                SalvarUsuario.salvarUsuario(usuario);
                ResponderPerguntas.aperteParaContinuar();
                Menu.main(args);
                break;
            case 2:
                File[] arquivos = ListarUsuarios.listarArquivosTXT();
                ListarUsuarios.extrairNomes(arquivos);
                ResponderPerguntas.aperteParaContinuar();
                Menu.main(args);
                break;
            case 3:
                AdicionarPerguntas.adicionarPergunta();
                System.out.println("Pergunta adicionada com sucesso!");
                ResponderPerguntas.aperteParaContinuar();
                Menu.main(args);
                break;
            case 4:
                System.out.println("aqaa");
                ResponderPerguntas.aperteParaContinuar();
                Menu.main(args);
                break;
            case 5:
                System.out.println("a");
                ResponderPerguntas.aperteParaContinuar();
                Menu.main(args);
                break;
            case 6:
                System.out.println("Programa encerrado.");
                break;
        }
    }
}
