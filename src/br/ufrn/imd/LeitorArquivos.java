package br.ufrn.imd;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LeitorArquivos {

    // Método que atualiza cadastros a partir do arquivo Cadastro
    public static ArrayList<Pessoa> atualizarCadastros() {
    ArrayList<Pessoa> pessoas = new ArrayList<>();
    try (BufferedReader reader = new BufferedReader(new FileReader("Arquivos/Cadastro.txt"))) {
        String linha;
        while ((linha = reader.readLine()) != null) {
            String[] dados = linha.split(",");
            Pessoa pessoa = new Pessoa(dados[0], Integer.parseInt(dados[1]), dados[2], dados[3], dados[4]);
            pessoas.add(pessoa);
        }
    } catch (IOException e) {
        System.err.println("Erro ao ler o arquivo Cadastro.txt: " + e.getMessage());
    }
    return pessoas;
    }

    public static ArrayList<String> VerTocadas() {
        ArrayList<String> tocadas = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("Arquivos/Tocadas.txt"))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                tocadas.add(linha);
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo Pedidos.txt: " + e.getMessage());
        }
        return tocadas;
    }

    public static ArrayList<String> VerPedidos() {
        ArrayList<String> pedidos = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("Arquivos/Pedidos.txt"))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                pedidos.add(linha);
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo Pedidos.txt: " + e.getMessage());
        }
        return pedidos;
    }
    
}
