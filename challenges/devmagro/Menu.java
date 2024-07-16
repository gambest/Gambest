package Desafio1;

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
        do {
            opcao = scanner.nextInt();
            if (opcao < 5 && opcao > 0) {
                break;
            }
            System.out.println("Opção inválida, tente novamente.");
        } while (true);
        switch (opcao) {
            case 1:
                System.out.println("Cadastro de novo usuário:");
                Usuario usuario = ResponderPerguntas.responderPerguntas();
                SalvarUsuario.salvarUsuario(usuario);
                break;
            case 2:
                System.out.println("aaa");
                break;
        }
    }
}
