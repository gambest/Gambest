package Desafio1;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PesquisarUsuarios {
    public static void main(String[] args) {
        /*String regex = "^\\d+.+txt$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher("12 - asdasdsad.txt");
        boolean b = m.matches();*/
        pesquisarUsuarios();
    }

    public static String[] pesquisarUsuarios() {
        Scanner scanner = new Scanner(System.in);
        File[] listaDeArquivos = ListarUsuarios.listarArquivosTXT();
        System.out.println("Digite a opção desejada:");
        System.out.println("1 - Pesquisar por nome.");
        System.out.println("2 - Pesquisar por idade.");
        System.out.println("3 - Pesquisar por email.");
        int opcao;
        String pesquisa;
        String[] dadosCorrespondentes = new String[listaDeArquivos.length];

        do {
            opcao = scanner.nextInt();
            scanner.nextLine();
        } while (opcao < 0 || opcao > 3);

        switch (opcao) {
            case 1:
                System.out.println("Digite o nome que deseja buscar:");
                pesquisa = scanner.nextLine();
                for (int i=0;i<dadosCorrespondentes.length;i++) {
                    String nomeDoArquivo = lerLinhaN(listaDeArquivos[i].getAbsolutePath(),1);

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
                for (int i=0;i<dadosCorrespondentes.length;i++) {
                    String idadeDoUsuario = lerLinhaN(listaDeArquivos[i].getAbsolutePath(),3);
                    String regex = pesquisa;
                    Pattern p = Pattern.compile(regex);
                    Matcher m = p.matcher(idadeDoUsuario.toLowerCase());
                    boolean b = m.matches();

                    if (b){
                        dadosCorrespondentes[i] = idadeDoUsuario;
                        System.out.println(dadosCorrespondentes[i]);
                    }
                }
                return dadosCorrespondentes;
            case 3:
                System.out.println("Digite o email que deseja buscar:");
                pesquisa = scanner.nextLine();
                for (int i=0;i<dadosCorrespondentes.length;i++) {
                    String emailDoUsuario = lerLinhaN(listaDeArquivos[i].getAbsolutePath(),2);
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
}