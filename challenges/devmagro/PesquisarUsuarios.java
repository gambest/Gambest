package Desafio1;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PesquisarUsuarios {
    public static void main(String[] args){
        String regex = "^\\d+.+txt$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher("12 - asdasdsad.txt");
        boolean b = m.matches();
        System.out.println(m);
        System.out.println(b);
    }

    public static String[] pesquisarUsuarios(){
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        return null;
    }
}