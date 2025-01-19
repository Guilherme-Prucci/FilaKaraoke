package br.ufrn.imd;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class GeradorRelatorio {


    public static void GerarRelatorio(ArrayList<Request> lista) {
        int horasTotal = 0, minutosTotal = 0, segundosTotal = 0;
        Map<String, Integer> estilo = new HashMap<>();
        Map<String, Integer> tempoCantado = new HashMap<>();



        for(Request musica : lista){
            //Começo da coleta de tempo total das musicas cantadas
            String dados [] = musica.getDuracao().split(":");
            int minutosMusica = Integer.parseInt(dados[0]);
            int segundosMusica = Integer.parseInt(dados[1]);
            minutosTotal += minutosMusica;
            segundosTotal += segundosMusica;

            if(segundosTotal >= 60){
                minutosTotal++;
                segundosTotal -=60;
            }

            if(minutosTotal >=60){
                horasTotal++;
                minutosTotal -= 60;
            }
            //fim da coleta de tempo total das musicas cantadas

            //inicio coleta estilos cantados
            if(!estilo.containsKey(musica.getEstilo())){
                estilo.put(musica.getEstilo(), 1);
            }else{
                estilo.put(musica.getEstilo(), estilo.get(musica.getEstilo()) + 1);
            }
            //fim coleta de estilos cantados

            //inicio de coleta de tempo por cada pessoa
            if(!tempoCantado.containsKey(musica.getPessoa().getCpf())){
                tempoCantado.put(musica.getPessoa().getCpf(), (minutosMusica*60)+segundosMusica);
            }else{
                tempoCantado.put(musica.getPessoa().getCpf(), tempoCantado.get(musica.getPessoa().getCpf())+ minutosMusica*60+segundosMusica);
            }
            //fim de coleta de tempo cantado por pessoa




        }
        try{
                BufferedWriter saida = new BufferedWriter(new FileWriter("Arquivos/Relatorio.txt"));
                saida.write("O tempo total de musica é " +horasTotal + ":" + minutosTotal + ":" + segundosTotal + "\n" );

                saida.write("Os estilos de musica escolhida");

                    for(Map<String, Integer> tipoMusica : estilo){
                        saida.write(tipoMusica.keySet().toString() + "\n");
                    }

                saida.write("tempo cantado por cada pessoa CPF");
                    for (Map<String, Integer> tipoMusica : tempoCantado){
                        saida.write(tipoMusica.keySet().toString() + "\n");
                    }

                saida.close();

            }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
        }

    }
