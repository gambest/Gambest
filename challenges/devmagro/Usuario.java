package Desafio1;

public class Usuario {
    private String nome;
    private String email;
    private int idade;
    private float altura;

    public void Imprimir() {
        System.out.println("nome : " + nome);
        System.out.println("email : " + email);
        System.out.println("idade : " + idade);
        System.out.println("altura : " + altura);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }
}
