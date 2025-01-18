package br.ufrn.imd;

// Classe para representar um pedido de música ou algo similar
public class Request {
    private Pessoa pessoa;     // Associação com a classe Pessoa
    private String titulo;     // Título da música ou item solicitado
    private String estilo;     // Estilo ou gênero da música/item
    private String duracao;    // Duração do pedido em formato de tempo (ex.: "03:45")

    // Construtor da classe Request
    public Request(Pessoa pessoa, String titulo, String estilo, String duracao) {
        this.pessoa = pessoa;
        this.titulo = titulo;
        this.estilo = estilo;
        this.duracao = duracao;
    }

    // Getters e Setters
    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEstilo() {
        return estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    // Método toString para facilitar a exibição de informações
    @Override
    public String toString() {
        return "Request [Pessoa: " + pessoa.getNomeCompleto() + 
               ", Título: " + titulo + 
               ", Estilo: " + estilo + 
               ", Duração: " + duracao + "]";
    }
}
