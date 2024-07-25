package Desafio1;

import java.io.IOException;
import java.util.Scanner;

public class ResponderPerguntas {
    public static Usuario responderPerguntas() {
        do {
            Scanner scanner = new Scanner(System.in);
            Usuario usuario = new Usuario();
            String resposta;
            String[] arg = {"0"};

            do {
                LerPerguntas.main(arg);
                resposta = scanner.nextLine();
                usuario.setNome(resposta);
            } while (resposta.length() < 10);

            do {
                arg[0] = "1";
                LerPerguntas.main(arg);
                resposta = scanner.nextLine();
                usuario.setEmail(resposta);
            } while (!resposta.contains("@"));

            do {
                arg[0] = "2";
                LerPerguntas.main(arg);
                resposta = scanner.nextLine();
                usuario.setIdade(Integer.parseInt(resposta));
            } while (Integer.parseInt(resposta) < 18);

            do {
                arg[0] = "3";
                LerPerguntas.main(arg);
                resposta = scanner.nextLine();
                resposta = resposta.replace(",",".");
                usuario.setAltura(Float.parseFloat(resposta));
            } while (!resposta.contains("."));

            System.out.println("Confirma as informações abaixo?");
            usuario.Imprimir();
            System.out.println("1 - Sim");
            System.out.println("2 - Não");

            if (scanner.nextInt() == 1) {
                return usuario;
            }
        } while (true);

    }

    public static void aperteParaContinuar() {
        System.out.println("Aperte enter para continuar.");
        try {
            System.in.read();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
