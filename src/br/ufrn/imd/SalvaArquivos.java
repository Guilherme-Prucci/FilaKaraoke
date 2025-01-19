package br.ufrn.imd;

import java.io.*;
import java.util.ArrayList;

public class SalvaArquivos {

    // Método para salvar a lista de pessoas no arquivo Cadastro.txt
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

    // Método para salvar a lista de pedidos no arquivo Pedidos.txt
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

    // Método para salvar a primeira linha de Cadastro.txt em Tocadas.txt e remover a primeira linha de Pedidos.txt
    public static void salvarTocadas(ArrayList<Request> requests, ArrayList<Pessoa> pessoas) {
        try {
            // Verifica se há pedidos na lista
            if (requests.isEmpty()) {
                System.out.println("Nenhum pedido disponível para processar.");
                return;
            }
    
            // Pega o primeiro pedido da lista
            Request primeiroPedido = requests.get(0);
    
            // Busca a pessoa correspondente ao CPF no pedido
            Pessoa pessoa = buscarPessoaPorCpf(primeiroPedido.getPessoa().getCpf(), pessoas);
    
            if (pessoa == null) {
                System.out.println("Pessoa com CPF " + primeiroPedido.getPessoa().getCpf() + " não encontrada.");
                return;
            }
    
            // Monta a linha a ser salva com os dados de Pessoa e Request
            String linha = pessoa.getCpf() + "," +
                           pessoa.getNome() + "," +
                           pessoa.getGenero() + "," +
                           pessoa.getProfissao() + "," +
                           primeiroPedido.getTitulo() + "," +
                           primeiroPedido.getEstilo() + "," +
                           primeiroPedido.getDuracao();
    
            // Escreve no arquivo Tocadas.txt
            BufferedWriter tocadasWriter = new BufferedWriter(new FileWriter("Arquivos/Tocadas.txt", true));
            tocadasWriter.write(linha);
            tocadasWriter.newLine();
            tocadasWriter.close();
            System.out.println("Primeiro pedido salvo em Tocadas.txt: " + linha);
    
            // Remove a primeira linha da lista de pedidos e atualiza o arquivo Pedidos.txt
            requests.remove(0);
            atualizarPedidos(requests);
    
        } catch (IOException e) {
            System.err.println("Erro ao salvar tocadas: " + e.getMessage());
        }
    }
    
    // Atualiza o arquivo Pedidos.txt após remover o primeiro pedido
    private static void atualizarPedidos(ArrayList<Request> requests) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Arquivos/Pedidos.txt", false))) {
            for (Request request : requests) {
                writer.write(request.getPessoa().getCpf() + "," +
                             request.getPessoa().getNome() + "," +
                             request.getPessoa().getGenero() + "," +
                             request.getPessoa().getProfissao() + "," +
                             request.getTitulo() + "," +
                             request.getEstilo() + "," +
                             request.getDuracao());
                writer.newLine();
            }
            System.out.println("Arquivo Pedidos.txt atualizado.");
        } catch (IOException e) {
            System.err.println("Erro ao atualizar Pedidos.txt: " + e.getMessage());
        }
    }
    

    // Método auxiliar para buscar pessoa pelo CPF
    private static Pessoa buscarPessoaPorCpf(String cpf, ArrayList<Pessoa> pessoas) {
        for (Pessoa pessoa : pessoas) {
            if (pessoa.getCpf().equals(cpf)) {
                return pessoa;
            }
        }
        return null;
    }
}
