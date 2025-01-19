import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import br.ufrn.imd.GeradorRelatorio;
import br.ufrn.imd.OrganizadorListas;
import br.ufrn.imd.Pessoa;
import br.ufrn.imd.Request;
import br.ufrn.imd.SalvaArquivos;




public class Main {
    public static void main(String[] args) {
        int digitado = 0;
        Scanner scanner = new Scanner(System.in);

        //a lista que iremos iterar para chamar a próxima música ou procurar CPF;
        ArrayList<Pessoa> pessoas = new ArrayList<>();
        ArrayList<Request> cantadas = new ArrayList<>();
        ArrayList<Request> requests = new ArrayList<>();

        while(digitado != 4) {
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
                    System.out.println("Cadastros atualizados com sucesso!");
                    break;
                //case 3: 
                case 4:
                    GeradorRelatorio.GerarRelatorio(requests);
                    System.out.println("Saindo");
                    break;
                default:
                    System.out.println("Digite um valor valido");
                    break;
            }
        }
    }

}

