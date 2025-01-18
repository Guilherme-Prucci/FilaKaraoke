package br.ufrn.imd;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class GeradorRelatorio {


    public static void GerarRelatorio(ArrayList<Request> lista) {
        int horas, minutos, segundos;
        String minutoString, segundoString;
        for(Request musica : lista){
            musica.getDuracao();
        }
        try{
                BufferedWriter saida = new BufferedWriter(new FileWriter("Arquivos/Relatorio.txt"));
                saida.write("alo mundo");
                saida.close();

            }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
        }

    }
