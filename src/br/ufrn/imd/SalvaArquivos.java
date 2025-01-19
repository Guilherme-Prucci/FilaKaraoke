package br.ufrn.imd;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class SalvaArquivos {

    public static void salvarCadastros(ArrayList<Pessoa> pessoas) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Arquivos/Cadastro.txt", false))) {
            for (Pessoa pessoa : pessoas) {
                writer.write(pessoa.getNome() + "," +
                             pessoa.getIdade() + "," +
                             pessoa.getCpf() + "," +
                             pessoa.getGenero() + "," +
                             pessoa.getProfissao());
                writer.newLine();
            }
            System.out.println("Cadastros salvos com sucesso no arquivo Cadastro.txt!");
        } catch (IOException e) {
            System.err.println("Erro ao salvar cadastros: " + e.getMessage());
        }
    }

    public static void salvarPedidos(ArrayList<Request> requests, ArrayList<Pessoa> pessoas) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Arquivos/Pedidos.txt", false))) {
            for (Request request : requests) {
                Pessoa pessoa = buscarPessoaPorCpf(request.getPessoa().getCpf(), pessoas);
    
                if (pessoa == null) {
                    System.err.println("Erro: Pessoa com CPF " + request.getPessoa().getCpf() + " não encontrada!");
                    continue;
                }
    
                writer.write(pessoa.getCpf() + "," +
                             pessoa.getNome() + "," +
                             pessoa.getGenero() + "," +
                             pessoa.getProfissao() + "," +
                             request.getTitulo() + "," +
                             request.getEstilo() + "," +
                             request.getDuracao());
                writer.newLine();
            }
            System.out.println("Pedidos salvos com sucesso no arquivo Pedidos.txt!");
        } catch (IOException e) {
            System.err.println("Erro ao salvar pedidos: " + e.getMessage());
        }
    }
    

    private static Pessoa buscarPessoaPorCpf(String cpf, ArrayList<Pessoa> pessoas) {
        for (Pessoa pessoa : pessoas) {
            if (pessoa.getCpf().equals(cpf)) {
                return pessoa;
            }
        }
        return null;
    }
}
