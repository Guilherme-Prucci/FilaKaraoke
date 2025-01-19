package br.ufrn.imd;

import java.util.ArrayList;
import java.util.Scanner;

public class OrganizadorListas {

    public static ArrayList<Pessoa> VerificacaoCadastro(ArrayList<Pessoa> lista) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Deseja adicionar uma nova pessoa? (s/n)");
        String resposta = scanner.nextLine();

        while (resposta.equalsIgnoreCase("s")) {
            System.out.println("Digite o CPF da pessoa:");
            String cpf = scanner.nextLine();

            boolean CPFrepetido = false;
            for (Pessoa pessoa : lista) {
                if (pessoa.getCpf().equals(cpf)) {
                    CPFrepetido = true;
                    break;
                }
            }

            if (!CPFrepetido) {
                System.out.println("Digite o nome da pessoa:");
                String nome = scanner.nextLine();

                System.out.println("Digite a idade da pessoa:");
                int idade = Integer.parseInt(scanner.nextLine());

                System.out.println("Digite o gênero da pessoa:");
                String genero = scanner.nextLine();

                System.out.println("Digite a profissão da pessoa:");
                String profissao = scanner.nextLine();

                lista.add(new Pessoa(nome, idade, cpf, genero, profissao));
                System.out.println("Pessoa adicionada com sucesso!");
            } else {
                System.out.println("CPF já cadastrado. Pessoa não foi adicionada.");
            }

            System.out.println("Deseja adicionar outra pessoa? (s/n)");
            resposta = scanner.nextLine();
        }

        return lista;
    }

    public static ArrayList<Request> AdicionarMusicas(ArrayList<Request> lista, ArrayList<Pessoa> pessoas) {
        Scanner scanner = new Scanner(System.in);
    
        System.out.println("Deseja adicionar uma nova música? (s/n)");
        String resposta = scanner.nextLine();
    
        while (resposta.equalsIgnoreCase("s")) {
            System.out.println("Digite o CPF da pessoa que solicitou:");
            String cpf = scanner.nextLine();
    
            Pessoa pessoa = buscarPessoaPorCpf(cpf, pessoas);
            if (pessoa == null) {
                System.out.println("CPF não encontrado no cadastro. Cadastre a pessoa primeiro.");
                break;
            }
    
            System.out.println("Digite o nome da música:");
            String nomeMusica = scanner.nextLine();
    
            System.out.println("Digite o estilo da música:");
            String estilo = scanner.nextLine();
    
            System.out.println("Digite a duração da música (formato mm:ss):");
            String duracao = scanner.nextLine();
    
            lista.add(new Request(pessoa, estilo, duracao, nomeMusica));
            System.out.println("Música adicionada com sucesso!");
    
            System.out.println("Deseja adicionar outra música? (s/n)");
            resposta = scanner.nextLine();
        }
    
        return lista;
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
