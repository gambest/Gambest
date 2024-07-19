package Desafio1;

import java.io.File;
import java.util.Objects;

public class LerUsuarios {
    public static void main(String[] args) {
        File pasta = new File("C:\\Users\\DELL\\IdeaProjects\\Java\\challenges\\devmagro");
        for (String i: Objects.requireNonNull(pasta.list())) {
            System.out.println(i);
        }
        System.out.println(numeroDeUsuarios());
    }
    public static int numeroDeUsuarios() {
        File pasta = new File("C:\\Users\\DELL\\IdeaProjects\\Java\\challenges\\devmagro");
        return Objects.requireNonNull(pasta.listFiles()).length;
    }
}
