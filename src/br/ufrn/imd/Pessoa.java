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
<<<<<<< Updated upstream
=======

    //Setters dos nomes
    public String getPrimeiroNome(){
        return primeiroNome;
    }
    public String getSegundoNome(){
        return segundoNome;
    }
    public String getTerceiroNome(){
        return terceiroNome;
    }

    //Método que trata e seta o cpf 
    public void setCpf(String cpf) {
        // Remove caracteres não numéricos (incluindo letras, espaços, etc.)
        cpf = cpf.replaceAll("[^0-9]", "");
        
        // Verificação se o CPF tem 11 dígitos para setar no objeto
        if (cpf.length() == 11) {
            this.cpf = cpf;
        } else {
            System.out.println("Erro: CPF deve ter exatamente 11 dígitos.");
        }
    }
    
    public String getCpf() {
        return cpf;
    }

    //Método para tratar o nome
    public void setNome(String nomeCompleto) {
        // Separa o nome em 3 partes
        String[] partes = nomeCompleto.trim().split(" ");  // Divide por espaços em branco

        // checa se existem 3 partes 
        if (partes.length >= 3) {
            this.primeiroNome = partes[0];
            this.segundoNome = partes[1];
            this.terceiroNome = partes[2];
        } else {
            System.out.println("Erro: O nome deve conter pelo menos três partes.");
        }
    }
    @Override
    public String toString() {
        return "Pessoa [Nome: " + getNomeCompleto() + ", Idade: " + idade + ", CPF: " + cpf + ", Gênero: " + genero + ", Profissão: " + profissao + ", Data de Chegada: " + data_de_chegada + "]";
    }
>>>>>>> Stashed changes
}
