package Desafio1;

import java.io.*;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ListarUsuarios {
    public static String[] extrairNomes(File[] usuarios){
        if (usuarios == null) return null;

        String[] nomesDosUsuarios = new String[usuarios.length];
        int numeroDeArquivos = 0;

        for (File arquivo:usuarios){
            try {
                FileReader leitor = new FileReader(arquivo);
                BufferedReader buffLeitor = new BufferedReader(leitor);
                try {
                    nomesDosUsuarios[numeroDeArquivos] = buffLeitor.readLine();
                    System.out.println(nomesDosUsuarios[numeroDeArquivos]);
                    buffLeitor.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            numeroDeArquivos++;
        }
        return nomesDosUsuarios;
    }

    public static File[] listarArquivosTXT(){
        File pasta = new File("C:\\Users\\DELL\\IdeaProjects\\Java\\challenges\\devmagro");

        String regex = "^\\d+.+txt$";
        Pattern p = Pattern.compile(regex);
        int numeroDeUsuarios = 0;

        File[] arquivos = new File[7];

        for (File i: Objects.requireNonNull(pasta.listFiles())) {
            Matcher m = p.matcher(i.getName());
            boolean b = m.matches();
            if (b) {
                arquivos[numeroDeUsuarios] = i;
                numeroDeUsuarios++;
            }
        }
        if (numeroDeUsuarios == 0){
            System.out.println("Não há usuários cadastrados.");
            return null;
        }
        return arquivos;
    }
}
