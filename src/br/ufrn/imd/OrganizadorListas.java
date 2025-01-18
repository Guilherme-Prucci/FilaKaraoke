package br.ufrn.imd;

import java.util.ArrayList;
import java.util.Arrays;

public class OrganizadorListas {
    public static ArrayList<Pessoa> VerificacaoCadastro(ArrayList<Pessoa> lista){
        //faz uma lista do cadastros em TXT
        Pessoa[] pessoas= LeitorArquivos.atualizarCadastros();

        //O boleano serve para verificar se encontramos um cpf repetido
        boolean CPFrepetido = false;

        //vamos iterar pela lista de pessoas para verificar se encontramos CPF da pessoa do TXT
        for (Pessoa verificar : pessoas) {
            for (Pessoa cadastro : lista){
                if (verificar.getCpf().equals(cadastro.getCpf())) {
                    CPFrepetido = true;
                    break;
                }
            }
            //Se nao encontramos adicionamos a lista
            if (!CPFrepetido){
                lista.add(verificar);
            }
            CPFrepetido = false;
        }

        //retornamos a lista completa com os cpf nao repetidos do txt adicionados
        return lista;
    }

    public static ArrayList<Request> AdicionarMusicas(ArrayList<Request> lista){
        lista.addAll(Arrays.asList(LeitorArquivos.atualizarPedidos()));
        return lista;
    }
}
