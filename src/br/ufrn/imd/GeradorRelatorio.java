package br.ufrn.imd;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.*;

public class GeradorRelatorio {


    public static void GerarRelatorio(ArrayList<String> lista) {
        int horasTotal =0, minutosTotal =0, segundosTotal =0;
        Map<String, Integer> tempoCantadoPorCPF = new HashMap<>();
        Map<String, Integer> estilosCantadosPorTempo = new HashMap<>();
        Map<String, Integer> musicasPedidas = new HashMap<>();
        HashSet<String> pessoasUnicas = new HashSet<>();
        DecimalFormat df = new DecimalFormat("00");


        for(int i = 0; i < lista.size(); i++) {
           String[] dados =  lista.get(i).split(",");
           String CPF = dados[0];
           String nome = dados[1];
           String sexo = dados[2];
           String profissao = dados[3];
           String estilo = dados[4].toUpperCase();
           String[] duracao = dados[5].split(":");
           String titulo = dados[6].toUpperCase();

           segundosTotal += Integer.parseInt(duracao[1]);
           if(segundosTotal >=60){
               segundosTotal -= 60;
               minutosTotal++;
           }

           minutosTotal += Integer.parseInt(duracao[0]);
           if(minutosTotal >= 60){
               minutosTotal -= 60;
               horasTotal++;
           }


           if(!tempoCantadoPorCPF.containsKey(CPF)){
                tempoCantadoPorCPF.put(CPF, Integer.parseInt(duracao[0])*60+Integer.parseInt(duracao[1]));
           }else tempoCantadoPorCPF.put(CPF, tempoCantadoPorCPF.get(CPF) + Integer.parseInt(duracao[0])*60+Integer.parseInt(duracao[1]));

           if(!estilosCantadosPorTempo.containsKey(estilo)){
                estilosCantadosPorTempo.put(estilo, Integer.parseInt(duracao[0])*60+Integer.parseInt(duracao[1]));
           }else estilosCantadosPorTempo.put(estilo, estilosCantadosPorTempo.get(estilo)+Integer.parseInt(duracao[0])*60+Integer.parseInt(duracao[1]));

           if(!musicasPedidas.containsKey(titulo)){
                musicasPedidas.put(titulo,1);
           }else musicasPedidas.put(titulo, musicasPedidas.get(titulo) + 1);

           pessoasUnicas.add(CPF);

        }


        try{
                BufferedWriter saida = new BufferedWriter(new FileWriter("Arquivos/Relatorio.txt"));
                saida.write("O tempo total de musica é " +horasTotal + ":" + df.format(minutosTotal) + ":" + df.format(segundosTotal) + "\n" );

                saida.write("\n"+"Os estilos de musica escolhida e o tempo cantado:" + "\n");

                    for(Map.Entry<String, Integer> tipoMusica : estilosCantadosPorTempo.entrySet()){
                        saida.write(tipoMusica.getKey() + " -> " + tipoMusica.getValue()/60 + ":" + df.format(tipoMusica.getValue()%60) + "\n");
                }

                saida.write("\n"+"Tempo cantado por CPF:" + "\n");
                    for(Map.Entry<String, Integer> cantado : tempoCantadoPorCPF.entrySet()){
                        saida.write(cantado.getKey() + " -> " + cantado.getValue()/60 + ":" + df.format(cantado.getValue()%60) + "\n");
                }
                saida.write("\n"+"musicas escolhida:" + "\n");
                    for(Map.Entry<String, Integer> musicaPedida : musicasPedidas.entrySet()){
                        saida.write(musicaPedida.getKey() + " -> " + musicaPedida.getValue()+"\n");
            }

                saida.close();

            }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
        }

    }
