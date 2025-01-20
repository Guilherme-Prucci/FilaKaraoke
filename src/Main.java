import java.util.ArrayList;
import java.util.Scanner;

import br.ufrn.imd.*;

public class Main {
    public static void main(String[] args) {
        int digitado = 0;
        Scanner scanner = new Scanner(System.in);

        // Listas que iremos iterar para chamar a próxima música ou procurar CPF;
        ArrayList<Pessoa> pessoas = LeitorArquivos.atualizarCadastros();
        ArrayList<Request> cantadas = new ArrayList<>();
        ArrayList<Request> requests = new ArrayList<>();

        while (digitado != 4) {
            System.out.println("Digite 1 para atualizar os cadastros,");
            System.out.println("Digite 2 para atualizar os pedidos,");
            System.out.println("Digite 3 para ver próxima música,");
            System.out.println("Digite 4 para gerar relatório e sair.");

            try {
                digitado = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Por favor, digite um número válido.");
                digitado = 0; // Reinicia a variável para não sair do loop.
            }

            switch (digitado) {
                case 1:
                    // Atualiza os cadastros e salva no arquivo
                    pessoas = OrganizadorListas.VerificacaoCadastro(pessoas);
                    SalvaArquivos.salvarCadastros(pessoas);
                    System.out.println("Cadastros atualizados com sucesso!");
                    break;

                case 2:
                    // Atualiza os pedidos e salva no arquivo
                    requests = OrganizadorListas.AdicionarMusicas(requests, pessoas);  // Passando a lista de pessoas
                    SalvaArquivos.salvarPedidos(requests, pessoas);  // Passando a lista de pessoas
                    System.out.println("Pedidos atualizados com sucesso!");
                    break;

                case 3:
                    // Exibe a próxima música e realiza as operações relacionadas
                    Request proximaMusica = SalvaArquivos.getProximaMusica(requests);

                    if (proximaMusica != null) {
                        System.out.println("Tocando agora: " +
                                proximaMusica.getTitulo() + " (" +
                                proximaMusica.getEstilo() + ") - " +
                                proximaMusica.getDuracao());

                        // Salva a música tocada e realiza as operações necessárias
                        SalvaArquivos.salvarTocadas(proximaMusica);
                    } else {
                        System.out.println("Nenhuma música disponível para tocar.");
                    }
                    break;

                case 4:
                    // Gera o relatório e encerra o programa
                    GeradorRelatorio.GerarRelatorio(LeitorArquivos.VerTocadas());
                    System.out.println("Relatório gerado. Saindo...");
                    break;

                default:
                    System.out.println("Digite um valor válido.");
                    break;
            }
        }
        scanner.close();
}
}