package br.ufrn.imd;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LeitorArquivos {

    // Método que atualiza cadastros a partir do arquivo Cadastro
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
