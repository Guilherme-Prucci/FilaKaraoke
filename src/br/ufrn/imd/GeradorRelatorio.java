package br.ufrn.imd;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GeradorRelatorio {

    public static void GerarRelatorio(ArrayList<Request> lista) {
        int horasTotal = 0, minutosTotal = 0, segundosTotal = 0;
        Map<String, Integer> estilo = new HashMap<>();
        Map<String, Integer> tempoCantado = new HashMap<>();

        for (Request musica : lista) {
            // Coleta de tempo total das músicas cantadas
            String[] dados = musica.getDuracao().split(":");
            int minutosMusica = Integer.parseInt(dados[0]);
            int segundosMusica = Integer.parseInt(dados[1]);
            minutosTotal += minutosMusica;
            segundosTotal += segundosMusica;

            if (segundosTotal >= 60) {
                minutosTotal++;
                segundosTotal -= 60;
            }

            if (minutosTotal >= 60) {
                horasTotal++;
                minutosTotal -= 60;
            }

            // Coleta de estilos cantados
            estilo.put(musica.getEstilo(), estilo.getOrDefault(musica.getEstilo(), 0) + 1);

            // Coleta de tempo cantado por cada pessoa
            String cpf = musica.getPessoa().getCpf();
            int tempoAtual = (minutosMusica * 60) + segundosMusica;
            tempoCantado.put(cpf, tempoCantado.getOrDefault(cpf, 0) + tempoAtual);
        }

        // Escrita do relatório no arquivo
        try (BufferedWriter saida = new BufferedWriter(new FileWriter("Arquivos/Relatorio.txt"))) {
            saida.write("O tempo total de música é " + horasTotal + ":" + minutosTotal + ":" + segundosTotal + "\n\n");

            saida.write("Estilos de música escolhidos:\n");
            for (Map.Entry<String, Integer> tipoMusica : estilo.entrySet()) {
                saida.write(tipoMusica.getKey() + ": " + tipoMusica.getValue() + " vezes\n");
            }

            saida.write("\nTempo cantado por cada pessoa (CPF):\n");
            for (Map.Entry<String, Integer> tempo : tempoCantado.entrySet()) {
                int totalSegundos = tempo.getValue();
                int minutos = totalSegundos / 60;
                int segundos = totalSegundos % 60;
                saida.write(tempo.getKey() + " - " + minutos + " minutos e " + segundos + " segundos\n");
            }

            System.out.println("Relatório gerado com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao salvar o relatório: " + e.getMessage());
        }
    }
}
