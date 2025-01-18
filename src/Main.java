package br.ufrn.imd;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;




public class Main {
    public static void main(String[] args) {
        int digitado = 0;
        Scanner scanner = new Scanner(System.in);

        //a lista que iremos iterar para chamar a proxima musica ou procurar CPF;
        ArrayList<Pessoa> pessoas = new ArrayList<>();
        ArrayList<Request> requests = new ArrayList<>();

        while(digitado != 3) {
            System.out.println("Digite 1 para atualizar os cadastros,");
            System.out.println("Digite 2 para atualizar os pedidos,");
            System.out.println("Digite 3 para sair.");

            digitado = scanner.nextInt();


            switch (digitado) {
                case 1:
                    //adiciona pessoas apenas se o cpf não é repetido
                   pessoas =  OrganizadorListas.VerificacaoCadastro(pessoas);
                    break;
                case 2:
<<<<<<< Updated upstream
                    LeitorArquivos.atualizarPedidos();

=======
                    //adiciona todas as musicas independente de repetição
                    requests = OrganizadorListas.AdicionarMusicas(requests);
>>>>>>> Stashed changes
                    break;
                case 3:
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

