package br.ufrn.imd;

<<<<<<< Updated upstream
import java.io.*;
=======
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
>>>>>>> Stashed changes
import java.util.ArrayList;

public class LeitorArquivos {

    // Método que atualiza cadastros a partir do arquivo Cadastro
    public static Pessoa[] atualizarCadastros() {
        System.out.println("Atualizando cadastros...");
        ArrayList<Pessoa> cadastros = new ArrayList<>();

<<<<<<< Updated upstream
        try (BufferedReader br = new BufferedReader(new FileReader("FilaKaraoke/Arquivos/Cadastro.txt"))) {
            String linha;

            while ((linha = br.readLine()) != null) {
                // Divide a linha em partes separadas por vírgulas (formato CSV)
                String[] dados = linha.split(",");

                if (dados.length == 6) {
                    String nomeCompleto = dados[0].trim();
                    int idade = Integer.parseInt(dados[1].trim());
                    String cpf = dados[2].trim();
                    String genero = dados[3].trim();
                    String profissao = dados[4].trim();
                    String dataDeChegada = dados[5].trim();

                    Pessoa pessoa = new Pessoa(nomeCompleto, idade, cpf, genero, profissao, dataDeChegada);
                    cadastros.add(pessoa);
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo de cadastro: " + e.getMessage());
        }

        return cadastros.toArray(new Pessoa[0]);
    }

    // Método que atualiza pedidos a partir do arquivo Pedidos
    public static Request[] atualizarPedidos(Pessoa[] pessoas) {
        System.out.println("Atualizando pedidos...");
        ArrayList<Request> pedidos = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("FilaKaraoke/Arquivos/Pedidos.txt"))) {
            String linha;

            while ((linha = br.readLine()) != null) {
                // Divide a linha em partes separadas por vírgulas (formato CSV)
                String[] dados = linha.split(",");

                if (dados.length == 4) {
                    String cpf = dados[0].trim(); // CPF da pessoa associada ao pedido
                    String titulo = dados[1].trim();
                    String estilo = dados[2].trim();
                    String duracao = dados[3].trim();

                    // Encontra a pessoa associada ao CPF
                    Pessoa pessoaAssociada = encontrarPessoaPorCpf(pessoas, cpf);

                    if (pessoaAssociada != null) {
                        Request request = new Request(pessoaAssociada, titulo, estilo, duracao);
                        pedidos.add(request);
                    } else {
                        System.out.println("Pessoa com CPF " + cpf + " não encontrada. Pedido ignorado.");
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo de pedidos: " + e.getMessage());
        }

        return pedidos.toArray(new Request[0]);
    }

    // Método auxiliar para encontrar uma pessoa pelo CPF
    private static Pessoa encontrarPessoaPorCpf(Pessoa[] pessoas, String cpf) {
        for (Pessoa pessoa : pessoas) {
            if (pessoa != null && pessoa.getPrimeiroNome() != null && cpf.equals(pessoa.getCpf())) {
                return pessoa;
            }
        }
        return null;
=======
    public static Pessoa[] atualizarCadastros() {
    ArrayList<Pessoa> pessoas = new ArrayList<>();
    try (BufferedReader reader = new BufferedReader(new FileReader("Arquivos/Cadastro.txt"))) {
        String linha;
        while ((linha = reader.readLine()) != null) {
            String[] dados = linha.split(",");
            Pessoa pessoa = new Pessoa(dados[0], Integer.parseInt(dados[1]), dados[2], linha, linha);
            pessoas.add(pessoa);
        }
    } catch (IOException e) {
        System.err.println("Erro ao ler o arquivo Cadastro.txt: " + e.getMessage());
    }
    return pessoas.toArray(new Pessoa[0]);
>>>>>>> Stashed changes
    }

    public static Request[] atualizarPedidos() {
        ArrayList<Request> requests = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("Arquivos/Pedidos.txt"))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(",");
                Pessoa pessoa = new Pessoa("", 0, dados[0], linha, linha); // Cria uma pessoa apenas com o CPF
                Request request = new Request(pessoa, dados[1], dados[2], dados[3]);
                requests.add(request);
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo Pedidos.txt: " + e.getMessage());
        }
        return requests.toArray(new Request[0]);
    }
    
}
