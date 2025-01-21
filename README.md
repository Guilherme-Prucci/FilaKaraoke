Projeto de Sistema de Gerenciamento de Karaokê

Propósito do Projeto:
  O propósito deste projeto é desenvolver um sistema completo para gerenciar cadastros de usuários, processar pedidos de músicas e gerar relatórios detalhados com base em registros 
  armazenados em arquivos. Este sistema é projetado para atender às necessidades de ambientes de karaokê, oferecendo funcionalidades como controle de músicas pedidas, registro de 
  músicas tocadas e geração de estatísticas de uso. Este projeto foi realizado como parte das atividades da disciplina Linguagem de Programação 2 e tem como objetivo principal 
  a consolidação de conceitos de programação orientada a objetos e manipulação de arquivos.

Participantes:
  Victor Costa Medeiros Ribeiro
  Guilherme Prucci Souza Rocha

Link da Gravação do Vídeo:
 https://youtu.be/28WCMM2JdjY

Organização do Projeto:

O projeto está organizado nos seguintes pacotes e classes:

Pacote br.ufrn.imd
  Pessoa: Representa uma pessoa cadastrada no sistema.
    Atributos: nome, idade, cpf, genero, profissao
    Métodos: getters e setters
  Request: Representa um pedido de música feito por uma pessoa.
    Atributos: pessoa, estilo, duracao, titulo
    Métodos: getters e setters
  OrganizadorListas: Classe responsável por gerenciar listas de pessoas e pedidos de músicas.
    Métodos:
      VerificacaoCadastro: Realiza o cadastro de novas pessoas.
      AdicionarMusicas: Adiciona novas músicas à lista de pedidos.
  SalvaArquivos: Responsável por gerenciar as operações de leitura e escrita nos arquivos do sistema.
    Métodos:
      salvarCadastros: Salva as pessoas cadastradas no arquivo Cadastro.txt.
      salvarPedidos: Salva os pedidos de músicas no arquivo Pedidos.txt.
      salvarTocadas: Salva músicas tocadas no arquivo Tocadas.txt.
      getProximaMusica: Obtém o próximo pedido de música a ser tocado.
  LeitorArquivos: Responsável por carregar dados dos arquivos do sistema.
    Métodos:
      atualizarCadastros: Carrega os cadastros do arquivo Cadastro.txt.
      VerTocadas: Carrega as músicas tocadas do arquivo Tocadas.txt.
  GeradorRelatorio: Gera relatórios com base nas músicas tocadas e nos registros do sistema.
    Métodos:
      GerarRelatorio: Processa e escreve um relatório detalhado no arquivo Relatorio.txt.
  Main: Classe principal que orquestra a execução do sistema.
    Funcionalidades:
      Atualização de cadastros.
      Atualização de pedidos de músicas.
      Execução de músicas e registro de tocadas.
      Geração de relatórios.



Instruções de Build
  1: Certifique-se de que você possui o JDK 8 (ou superior) instalado no seu sistema.
  2: Clone o repositório do projeto:
    git clone <https://github.com/Guilherme-Prucci/FilaKaraoke.git>
  3: Navegue até o diretório do projeto:
    cd <.../FilaKaraoke>
  4: Compile o projeto utilizando o seguinte comando:
    <javac -d bin src/br/ufrn/imd/*.java>


Instruções de Como Executar:
  Após compilar e rodar o programa, será possível interagir com as funcionalidades do projeto via terminal.
  O programa apresentará um menu com as seguintes opções:
  
  1: Atualizar os cadastros de pessoas.
      O sistema solicitará que você insira os dados da pessoa a ser cadastrada, como nome, idade, CPF, gênero e profissão.
      Os dados inseridos serão validados e adicionados à lista de cadastros.
    
  2: Atualizar os pedidos de músicas.
      O sistema exibirá a lista de pessoas cadastradas, permitindo que você escolha quem fará o pedido.
      Você será solicitado a inserir os dados da música, como título, estilo e duração.
      
  3: Ver a próxima música a ser tocada.
      O sistema exibirá o próximo pedido de música na lista de execução.
      Após a exibição, o pedido será removido da lista de pendentes e adicionado à lista de músicas tocadas.
      
  4: Gerar relatório e encerrar o programa.
      O sistema processará os dados das músicas tocadas e gerará um relatório detalhado no arquivo Relatorio.txt
      O relatório incluirá informações como quantidade de músicas tocadas por estilo, total de pedidos realizados, e usuários mais frequentes.
      
  *Obs: Os arquivos gerados pelo sistema (Cadastro.txt, Pedidos.txt, Tocadas.txt e Relatorio.txt) serão armazenados na pasta Arquivos/ do projeto, 
  podendo ser consultados para análise posterior.
      
      
