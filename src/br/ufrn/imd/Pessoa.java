package br.ufrn.imd;

//classe de PESSOA para cadastrar e peremtir repetição de nome mas nao de cpf;
public class Pessoa {
    private String nome;
    private int idade;
    private String cpf;

    public Pessoa(String nome, int idade, String cpf) {
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }
}
