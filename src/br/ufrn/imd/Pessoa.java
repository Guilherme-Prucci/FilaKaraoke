package br.ufrn.imd;

public class Pessoa {
    private String nome;
    private int idade;
    private String cpf;
    private String genero;
    private String profissao;

    public Pessoa(String nome, int idade, String cpf, String genero, String profissao) {
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
        this.genero = genero;
        this.profissao = profissao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }
}
