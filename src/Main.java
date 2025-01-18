package br.ufrn.imd;

import br.ufrn.imd.LeitorArquivos;
import java.util.Scanner;




public class Main {
    public static void main(String[] args) {
        int digitado = 0;
        Scanner scanner = new Scanner(System.in);
        while(digitado != 3) {
            System.out.println("Digite 1 para atualizar os cadastros,");
            System.out.println("Digite 2 para atualizar os pedidos,");
            System.out.println("Digite 3 para sair.");

            digitado = scanner.nextInt();


            switch (digitado) {
                case 1:
                    LeitorArquivos.atualizarCadastros();
                    break;
                case 2:
                    LeitorArquivos.atualizarPedidos();

                    break;
                case 3:
                    System.out.println("Saindo");
                    break;
                default:
                    System.out.println("Digite um valor valido");
                    break;
            }
        }
    }

}

