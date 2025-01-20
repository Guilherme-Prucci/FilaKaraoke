package br.ufrn.imd;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class SalvaArquivos {

    private static LinkedHashMap<String, Request> firstRequestsByCpf = new LinkedHashMap<>(); // LinkedHashMap para pedidos únicos

    // Método para salvar a lista de pessoas no arquivo Cadastro.txt
    public static void salvarCadastros(ArrayList<Pessoa> pessoas) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Arquivos/Cadastro.txt", true))) {
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
        ArrayList<Request> excedentes = new ArrayList<>(); // Lista para armazenar pedidos excedentes

            for (Request request : requests) {
                Pessoa pessoa = buscarPessoaPorCpf(request.getPessoa().getCpf(), pessoas);

                if (pessoa == null) {
                    System.err.println("Erro: Pessoa com CPF " + request.getPessoa().getCpf() + " não encontrada!");
                    continue;
                }

                if (!firstRequestsByCpf.containsKey(pessoa.getCpf())) {
                    // Adiciona o primeiro pedido no LinkedHashMap
                    System.out.println("Adicionado no pedido unico");
                    firstRequestsByCpf.put(pessoa.getCpf(), request);
                } else {
                    System.out.println("adicionado em excedentes");
                    // Adiciona pedidos excedentes
                    excedentes.add(request);
                }
            }
    }

    // Método para salvar a música tocada em Tocadas.txt e atualizar a LinkedHashMap
    public static void salvarTocadas(Request salvar) {
        try {
            // Pega o primeiro pedido da LinkedHashMap

            // Busca a pessoa correspondente ao CPF

            if (salvar.getPessoa() == null) {
                System.out.println("Pessoa com CPF " + salvar.getPessoa().getCpf() + " não encontrada.");
                return;
            }

            // Monta a linha para salvar no arquivo Tocadas.txt
            String linha = salvar.getPessoa().getCpf() + "," +
                    salvar.getPessoa().getNome() + "," +
                    salvar.getPessoa().getGenero() + "," +
                    salvar.getPessoa().getProfissao() + "," +
                    salvar.getTitulo() + "," +
                    salvar.getEstilo() + "," +
                    salvar.getDuracao();

            // Escreve no arquivo Tocadas.txt
            try (BufferedWriter tocadasWriter = new BufferedWriter(new FileWriter("Arquivos/Tocadas.txt", true))) {
                tocadasWriter.write(linha);
                tocadasWriter.newLine();
            }
            System.out.println("Música tocada salva em Tocadas.txt: " + linha);

        } catch (IOException e) {
            System.err.println("Erro ao salvar tocadas: " + e.getMessage());
        }
    }

    // Atualiza o arquivo Pedidos.txt após remoção
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

    // Busca o próximo pedido de um CPF específico no arquivo Pedidos.txt
    private static Request reporPedido(String cpf, ArrayList<Request> requests) {
            Request retorna = null;
            for(Request request : requests) {
                if (request.getPessoa().getCpf().equals(cpf)) {
                    retorna = request;
                    requests.remove(request);
                    return retorna;
                }
            }
            return retorna;
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

    // Método para obter a próxima música da LinkedHashMap (a primeira)
    public static Request getProximaMusica(ArrayList<Request> requests) {
        Request retorna;
        if (!firstRequestsByCpf.isEmpty()) {
            String cpf = firstRequestsByCpf.keySet().iterator().next();
            retorna = firstRequestsByCpf.get(cpf);
            firstRequestsByCpf.remove(cpf);
            Request repor = reporPedido(cpf, requests);
            if(repor != null) {
                firstRequestsByCpf.put(cpf, repor);
            }
            return retorna; // Retorna o primeiro pedido da LinkedHashMap
        }
        return null; // Retorna null se não houver músicas disponíveis
    }
}