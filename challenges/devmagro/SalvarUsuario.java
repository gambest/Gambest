package Desafio1;

import java.io.*;

public class SalvarUsuario {
    public static String concatenarNome(String nome) {
        nome = nome.toUpperCase();
        nome = nome.replaceAll("\\s","");
        return nome;
    }

    public static void salvarUsuario(Usuario usuario){
        String nomeDoArquivo = concatenarNome(usuario.getNome());
        int numeroDoArquivo = LerUsuarios.numeroDeUsuarios();
        File arquivo = new File("challenges/devmagro/" + (numeroDoArquivo - 7) + " - " + nomeDoArquivo + ".txt");

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
            buffInfo.write(usuario.getNome() + "\n");
            buffInfo.write(usuario.getEmail() + "\n");
            buffInfo.write(usuario.getIdade() + "\n");
            buffInfo.write(usuario.getAltura() + "\n");
            buffInfo.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
