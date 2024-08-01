package Desafio1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Usuario {
    private final String nome;
    private final String email;
    private final int idade;
    private final float altura;
    private final String[] respostas;
    private static final int numeroDeUsuarios;

    static {
        numeroDeUsuarios = Arquivo.contarUsuarios();
    }

    public Usuario(String[] respostas) {
        this.nome = respostas[0];
        this.email = respostas[1];
        this.idade = Integer.parseInt(respostas[2]);
        this.altura = Float.parseFloat(respostas[3]);
        this.respostas = respostas;
    }

    //TODO - criar um sistema de tags associadas a cada pergunta
    public void Imprimir() {
        System.out.println("nome : " + nome);
        System.out.println("email : " + email);
        System.out.println("idade : " + idade);
        System.out.println("altura : " + altura);
    }

    public static void salvarUsuario(Usuario usuario) {
        String nomeDoArquivo = usuario.nome.toUpperCase().replaceAll("\\s", "");
        String caminho = Menu.caminho;
        File arquivo = new File(caminho + "\\usuarios\\" + (numeroDeUsuarios + 1) + " - " + nomeDoArquivo + ".txt");
        System.out.println(caminho + "\\usuarios\\" + numeroDeUsuarios + " - " + nomeDoArquivo + ".txt");

        if (!arquivo.exists()) {
            try {
                arquivo.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        FileWriter infoDoUsuario;

        try {
            infoDoUsuario = new FileWriter(arquivo);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        BufferedWriter buffInfo = new BufferedWriter(infoDoUsuario);

        try {
            buffInfo.write(usuario.nome + "\n");
            buffInfo.write(usuario.email + "\n");
            buffInfo.write(usuario.idade + "\n");
            buffInfo.write(usuario.altura + "\n");
            for (int i = 4; i < usuario.respostas.length - 1; i++) {
                buffInfo.write(usuario.respostas[i] + "\n");
            }
            buffInfo.write(usuario.respostas[usuario.respostas.length - 1]);
            buffInfo.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
