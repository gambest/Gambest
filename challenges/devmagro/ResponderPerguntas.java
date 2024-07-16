package Desafio1;

import java.util.Scanner;

public class ResponderPerguntas {
    public static Usuario responderPerguntas() {
        do {
            Scanner scanner = new Scanner(System.in);
            Usuario usuario = new Usuario();
            String[] arg = {"0"};

            LerPerguntas.main(arg);
            usuario.setNome(scanner.nextLine());
            arg[0] = "1";
            LerPerguntas.main(arg);
            usuario.setEmail(scanner.nextLine());
            arg[0] = "2";
            LerPerguntas.main(arg);
            usuario.setIdade(scanner.nextInt());
            arg[0] = "3";
            LerPerguntas.main(arg);
            usuario.setAltura(scanner.nextFloat());
            System.out.println("Confirma as informações abaixo?");
            usuario.Imprimir();
            System.out.println("1 - Sim");
            System.out.println("2 - Não");
            if (scanner.nextInt()==1){
                return usuario;
            }
        } while (true);

    }
}
