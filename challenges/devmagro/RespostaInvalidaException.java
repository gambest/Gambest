package Desafio1;

public class RespostaInvalidaException extends RuntimeException{
    public RespostaInvalidaException(String mensagem){
        super(mensagem);
        System.out.println(mensagem);
        System.out.println("Retornando ao menu.");
        String[] args = {"0"};
        Menu.aperteParaContinuar(args);
    }
}
