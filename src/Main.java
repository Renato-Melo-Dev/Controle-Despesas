import Entidades.Despesa;
import Entidades.Receita;
import Entidades.Usuario;
import Interfaces.DespesaRepository;
import Interfaces.ReceitaRepository;
import Interfaces.UsuarioRepository;
import Repository.DespesaRepositorio;
import Repository.ReceitaRepositorio;
import Repository.UsuarioRepositorio;
import Services.CalcularSaldoTotal;
import Services.DespesaService;
import Services.ReceitaService;
import Services.RelatorioService;
import Services.UsuarioService;
import Utils.GeradorId;
import Utils.InputUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Classe principal do sistema de gerenciamento de custos.
 */
public class Main {
    public static void main(String[] args) {
        // Inicializa os repositórios para despesas, receitas e usuários.
        DespesaRepository despesaRepository = new DespesaRepositorio();
        ReceitaRepository receitaRepository = new ReceitaRepositorio();
        UsuarioRepository usuarioRepository = new UsuarioRepositorio();

        // Inicializa os serviços correspondentes.
        DespesaService despesaService = new DespesaService(despesaRepository);
        ReceitaService receitaService = new ReceitaService(receitaRepository);
        UsuarioService usuarioService = new UsuarioService(usuarioRepository);
        RelatorioService relatorioService = new RelatorioService();

        List<Despesa> listaDespesas = new ArrayList<>();
        List<Receita> listaReceitas = new ArrayList<>();

        try (Scanner scanner = new Scanner(System.in)) {
            boolean continuarExecucao = true;

            System.out.println("Bem-vindo ao Sistema de Gerenciamento!");
            System.out.println("Escolha uma opção:");
            System.out.println("1. Cadastrar");
            System.out.println("2. Fazer login");
            System.out.print("Digite o número da opção desejada: ");

            int escolha = scanner.nextInt();
            scanner.nextLine(); 

            switch (escolha) {
                case 1 -> {
                    // Cadastro de novo usuário
                    System.out.println("Preencha os dados.");
                    System.out.print("Digite seu nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Digite seu email: ");
                    String email = scanner.nextLine();
                    System.out.print("Digite sua senha: ");
                    String senha = scanner.nextLine();
                    Usuario novoUsuario = new Usuario(GeradorId.gerarIdUsuario(), nome, email, senha);
                    usuarioService.criarUsuario(novoUsuario);
                    System.out.println("Usuário cadastrado com sucesso!");
                }
                case 2 -> {
                    // Login do usuário existente
                    System.out.println("Informe seus dados.");
                    System.out.print("Digite seu email: ");
                    String emailLogin = scanner.nextLine();
                    System.out.print("Digite sua senha: ");
                    String senhaLogin = scanner.nextLine();
                    if (usuarioService.autenticarUsuario(emailLogin, senhaLogin)) {
                        System.out.println("Login bem-sucedido!");
                    } else {
                        System.out.println("Email ou senha incorretos. Tente novamente.");
                    }
                }
                default -> System.out.println("Opção inválida. Tente novamente.");
            }

            while (continuarExecucao) {
                // Menu principal do sistema
                System.out.println("\n--- Sistema de Gerenciamento de Custos ---");
                System.out.println("1. Adicionar Despesa");
                System.out.println("2. Listar Despesas");
                System.out.println("3. Atualizar Despesa");
                System.out.println("4. Deletar Despesa");
                System.out.println("5. Consultar Saldo");
                System.out.println("6. Gerar Relatório");
                System.out.println("7. Sair");
                System.out.print("Escolha uma opção: ");

                int opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {
                    case 1 -> {
                        // Adiciona uma nova despesa
                        System.out.print("Digite a descrição da despesa: ");
                        String descricaoDespesa = scanner.nextLine();
                        double valorDespesa = InputUtils.obterValor(scanner);

                        Despesa novaDespesa = new Despesa(GeradorId.gerarIdDespesa(), descricaoDespesa, valorDespesa);
                        despesaService.adicionarDespesa(novaDespesa);
                        listaDespesas.add(novaDespesa);
                        System.out.println("Despesa adicionada com sucesso!");
                    }
                    case 2 -> {
                        // Lista todas as despesas
                        List<Despesa> despesas = despesaService.listarDespesas();
                        System.out.println("Lista de Despesas:");
                        for (Despesa d : despesas) {
                            System.out.println(d.getId() + ": " + d.getDescricao() + " - R$" + d.getValor());
                        }
                    }
                    case 3 -> {
                        // Atualiza uma despesa existente
                        System.out.print("Digite o ID da despesa a ser atualizada: ");
                        int id = scanner.nextInt();
                        scanner.nextLine(); 
                        System.out.print("Digite a nova descrição da despesa: ");
                        String novaDescricao = scanner.nextLine();
                        double novoValor = InputUtils.obterValor(scanner);

                        Despesa despesaAtualizada = new Despesa(id, novaDescricao, novoValor);
                        despesaService.atualizarDespesa(despesaAtualizada);
                        System.out.println("Despesa atualizada com sucesso!");
                    }
                    case 4 -> {
                        // Deleta uma despesa
                        System.out.print("Digite o ID da despesa a ser deletada: ");
                        int id = scanner.nextInt();
                        despesaService.deletarDespesa(id);
                        System.out.println("Despesa deletada com sucesso!");
                    }
                    case 5 -> {
                        // Consulta o saldo
                        CalcularSaldoTotal calculadora = new CalcularSaldoTotal();
                        double saldoTotal = calculadora.calcularSaldoTotal(despesaService, receitaService, listaDespesas, listaReceitas);
                        System.out.printf("Saldo: R$%.2f%n", saldoTotal);
                    }
                    case 6 -> {
                        // Gera um relatório
                        relatorioService.gerarRelatorio(listaDespesas, listaReceitas);
                    }
                    case 7 -> {
                        // Encerra o programa
                        System.out.println("Encerrando o programa. Até mais!");
                        continuarExecucao = false;
                    }
                    default -> System.out.println("Opção inválida. Tente novamente.");
                }
            }
        } catch (Exception e) {
            System.out.println("Ocorreu um erro: " + e.getMessage());
        }
    }
}
