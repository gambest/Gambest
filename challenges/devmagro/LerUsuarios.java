package Desafio1;

import java.io.File;
//fixme preciso corrigir a numeração dos arquivos
public class LerUsuarios {
    public static int numeroDeUsuarios() {
        File pasta = new File("devmagro");
        return pasta.listFiles().length;
    }
}
