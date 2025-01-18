package br.ufrn.imd;


//classe ESTATICA para fazer as leituras dos arquivos colocados
public class LeitorArquivos {


<<<<<<< Updated upstream
    public static Pessoa[] atualizarCadastros(){
        System.out.println("atualizando cadastros");
        return null;
    }
    public static Request[] atualizarPedidos(){
        System.out.println("atualizando pedidos");
=======
        try (BufferedReader br = new BufferedReader(new FileReader("Arquivos/Cadastro.txt"))) {
            String linha;

            while ((linha = br.readLine()) != null) {
                // Divide a linha em partes separadas por vírgulas (formato CSV)
                String[] dados = linha.split(",");

                if (dados.length == 6) {
                    String nomeCompleto = dados[0].trim();
                    int idade = Integer.parseInt(dados[1].trim());
                    String cpf = dados[2].trim();
                    String genero = dados[3].trim();
                    String profissao = dados[4].trim();
                    String dataDeChegada = dados[5].trim();

                    Pessoa pessoa = new Pessoa(nomeCompleto, idade, cpf, genero, profissao, dataDeChegada);
                    cadastros.add(pessoa);
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo de cadastro: " + e.getMessage());
        }

        return cadastros.toArray(new Pessoa[0]);
    }

    // Método que atualiza pedidos a partir do arquivo Pedidos
    public static Request[] atualizarPedidos() {
        System.out.println("Atualizando pedidos...");
        ArrayList<Request> pedidos = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("Arquivos/Pedidos.txt"))) {
            String linha;

            while ((linha = br.readLine()) != null) {
                // Divide a linha em partes separadas por vírgulas (formato CSV)
                String[] dados = linha.split(",");

                if (dados.length == 4) {
                    String cpf = dados[0].trim(); // CPF da pessoa associada ao pedido
                    String titulo = dados[1].trim();
                    String estilo = dados[2].trim();
                    String duracao = dados[3].trim();

                    // Encontra a pessoa associada ao CPF
                    /*Pessoa pessoaAssociada = encontrarPessoaPorCpf(pessoas, cpf);

                    if (pessoaAssociada != null) {
                        Request request = new Request(pessoaAssociada, titulo, estilo, duracao);
                        pedidos.add(request);
                    } else {
                        System.out.println("Pessoa com CPF " + cpf + " não encontrada. Pedido ignorado.");
                    }*/
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo de pedidos: " + e.getMessage());
        }

        return pedidos.toArray(new Request[0]);
    }

    // Método auxiliar para encontrar uma pessoa pelo CPF
    private static Pessoa encontrarPessoaPorCpf(Pessoa[] pessoas, String cpf) {
        for (Pessoa pessoa : pessoas) {
            if (pessoa != null && pessoa.getPrimeiroNome() != null && cpf.equals(pessoa.getCpf())) {
                return pessoa;
            }
        }
>>>>>>> Stashed changes
        return null;
    }
}
