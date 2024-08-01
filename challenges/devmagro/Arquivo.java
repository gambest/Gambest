package Desafio1;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Arquivo {
    public static int contarPerguntas() {
        int numeroDePerguntas = 0;
        File arquivo = new File(Menu.caminho + "\\perguntas.txt");

        if (arquivo.exists()) {
            try (FileReader leitor = new FileReader(arquivo)) {
                BufferedReader buffLeitor = new BufferedReader(leitor);

                while (buffLeitor.readLine() != null) {
                    numeroDePerguntas++;
                }

                buffLeitor.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return numeroDePerguntas;
        } else {
            return 4;
        }
    }

    public static void inicializarPasta() {
        String caminhoDaPasta = Menu.caminho + "\\usuarios";
        String caminhoDasPerguntas = Menu.caminho + "\\perguntas.txt";

        File pasta = new File(caminhoDaPasta);
        if (!pasta.exists()) {
            pasta.mkdir();
        }

        File arquivoDasPerguntas = new File(caminhoDasPerguntas);
        if (!arquivoDasPerguntas.exists()) {
            try {
                arquivoDasPerguntas.createNewFile();
                FileWriter escritor = new FileWriter(arquivoDasPerguntas);
                BufferedWriter buffEscritor = new BufferedWriter(escritor);
                buffEscritor.write("1 - Qual o seu nome completo?\n");
                buffEscritor.write("2 - Qual o seu email?\n");
                buffEscritor.write("3 - Qual a sua idade?\n");
                buffEscritor.write("4 - Qual a sua altura?");
                buffEscritor.close();
                escritor.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static int contarUsuarios() {
        File usuarios = new File(Menu.caminho + "\\usuarios");
        if (usuarios.listFiles() == null) return 0;

        return usuarios.listFiles().length;
    }

    public static void listarUsuarios() {
        String caminho = Menu.caminho + "\\usuarios";
        File pasta = new File(caminho);
        File[] usuarios = pasta.listFiles();

        if (usuarios == null) return;

        for (int i = 0; i < usuarios.length; i++) {
            try (FileReader leitor = new FileReader(usuarios[i])) {
                BufferedReader buffLeitor = new BufferedReader(leitor);
                System.out.println((i + 1) + " - " + buffLeitor.readLine());
                buffLeitor.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static String[] pesquisarUsuarios(){
        Scanner scanner = new Scanner(System.in);
        String caminho = Menu.caminho + "\\usuarios";
        File pastaDeUsuarios = new File(caminho);
        File[] listaDeUsuarios = pastaDeUsuarios.listFiles();

        System.out.println("Digite a opção desejada:");
        System.out.println("1 - Pesquisar por nome.");
        System.out.println("2 - Pesquisar por idade.");
        System.out.println("3 - Pesquisar por email.");

        int opcao;
        String pesquisa;
        String caminhoDoUsuario;
        String[] dadosCorrespondentes = new String[listaDeUsuarios.length];

        do {
            opcao = scanner.nextInt();
            scanner.nextLine();
        } while (opcao < 0 || opcao > 3);

        switch (opcao) {
            case 1:
                System.out.println("Digite o nome que deseja buscar:");
                pesquisa = scanner.nextLine();

                System.out.println("Essa é a lista de usuários correspondentes à pesquisa:");
                for (int i=0;i<dadosCorrespondentes.length;i++) {
                    caminhoDoUsuario = listaDeUsuarios[i].getAbsolutePath();
                    String nomeDoArquivo = lerLinhaN(caminhoDoUsuario,1);

                    String regex = ".*" + pesquisa.toLowerCase() + ".*";
                    Pattern p = Pattern.compile(regex);
                    Matcher m = p.matcher(nomeDoArquivo.toLowerCase());
                    boolean b = m.matches();

                    if (b){
                        dadosCorrespondentes[i] = nomeDoArquivo;
                        System.out.println(dadosCorrespondentes[i]);
                    }
                }
                return dadosCorrespondentes;
            case 2:
                System.out.println("Digite a idade que deseja buscar:");
                pesquisa = scanner.nextLine();

                System.out.println("Essa é a lista de usuários com " + pesquisa + "anos:");
                for (int i=0;i<dadosCorrespondentes.length;i++) {
                    caminhoDoUsuario = listaDeUsuarios[i].getAbsolutePath();
                    String idadeDoUsuario = lerLinhaN(caminhoDoUsuario,3);

                    Pattern p = Pattern.compile(pesquisa);
                    Matcher m = p.matcher(idadeDoUsuario.toLowerCase());
                    boolean b = m.matches();

                    if (b){
                        dadosCorrespondentes[i] = lerLinhaN(caminhoDoUsuario,1);
                        System.out.println((i + 1) + " - " + dadosCorrespondentes[i]);
                    }
                }
                return dadosCorrespondentes;
            case 3:
                System.out.println("Digite o email que deseja buscar:");
                pesquisa = scanner.nextLine();

                System.out.println("Essa é a lista de usuários com " + pesquisa + " em seu email:");
                for (int i=0;i<dadosCorrespondentes.length;i++) {
                    caminhoDoUsuario = listaDeUsuarios[i].getAbsolutePath();
                    String emailDoUsuario = lerLinhaN(caminhoDoUsuario,2);

                    String regex = ".*" + pesquisa.toLowerCase() + ".*";
                    Pattern p = Pattern.compile(regex);
                    Matcher m = p.matcher(emailDoUsuario.toLowerCase());
                    boolean b = m.matches();

                    if (b){
                        dadosCorrespondentes[i] = emailDoUsuario;
                        System.out.println(dadosCorrespondentes[i]);
                    }
                }
                return dadosCorrespondentes;
        }
        return null;
    }

    public static boolean verificarEmailDuplicado(String email){
        String caminho = Menu.caminho + "\\usuarios";
        File arquivo = new File(caminho);
        File[] usuarios = arquivo.listFiles();

        for (File usuario : usuarios) {
            caminho = Menu.caminho + "\\usuarios\\" + usuario.getName();
            String emailDoUsuario = Arquivo.lerLinhaN(caminho, 2);

            Pattern p = Pattern.compile(email);
            Matcher m = p.matcher(emailDoUsuario.toLowerCase());
            boolean b = m.matches();

            if (b) {
                return true;
            }
        }
        return false;
    }

    public static String lerLinhaN(String caminho, int numeroDaLinha){
        File arquivo = new File(caminho);
        String conteudoDaLinha;
        try (FileReader leitor = new FileReader(arquivo)) {
            BufferedReader buffLeitor = new BufferedReader(leitor);
            for (int i = 1; i < numeroDaLinha; i++) {
                buffLeitor.readLine();
            }
            conteudoDaLinha = buffLeitor.readLine();
            buffLeitor.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return conteudoDaLinha;
    }

    public static String[] arquivoParaPerguntas(String caminho) {
        String[] perguntas = new String[Menu.numeroDePerguntas];

        File arquivo = new File(caminho + "\\perguntas.txt");
        try (FileReader leitor = new FileReader(arquivo)) {
            BufferedReader buffLeitor = new BufferedReader(leitor);

            for (int i = 0; i < perguntas.length; i++) {
                perguntas[i] = buffLeitor.readLine();
            }

            buffLeitor.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return perguntas;
    }

    public static void perguntasParaArquivo(String caminho, String[] perguntas) {
        File arquivo = new File(caminho + "\\perguntas.txt");
        String pergunta;

        try (FileWriter escritor = new FileWriter(arquivo)) {
            BufferedWriter buffEscritor = new BufferedWriter(escritor);
            for (int i = 0; i < perguntas.length - 1; i++) {
                pergunta = perguntas[i].replaceAll("^\\d*","");
                pergunta = pergunta.replaceAll(" - ","");
                buffEscritor.write((i + 1) + " - " + pergunta + "\n");
            }
            int i = perguntas.length;
            pergunta = perguntas[i-1].replaceAll("^\\d*","");
            pergunta = pergunta.replaceAll(" - ","");
            buffEscritor.write(i + " - " + pergunta);
            buffEscritor.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
