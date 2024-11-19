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

        // Agora instanciamos o RelatorioService com as dependências necessárias
        RelatorioService relatorioService = new RelatorioService(despesaService, receitaService);

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
            scanner.nextLine(); // Limpar buffer

            switch (escolha) {
                case 1 -> // Cadastro de novo usuário
                    cadastrarUsuario(scanner, usuarioService);
                case 2 -> // Login do usuário existente
                    loginUsuario(scanner, usuarioService);
                default -> System.out.println("Opção inválida. Tente novamente.");
            }

            while (continuarExecucao) {
                // Menu principal do sistema
                System.out.println("\n--- Sistema de Gerenciamento de Custos ---");
                System.out.println("1. Receitas");
                System.out.println("2. Despesas");
                System.out.println("3. Consultar Saldo");
                System.out.println("4. Gerar Relatório");
                System.out.println("5. Sair");
                System.out.print("Escolha uma opção: ");

                int opcao = scanner.nextInt();
                scanner.nextLine(); // Limpar buffer

                switch (opcao) {
                    case 1 -> // Menu de Receitas
                        menuReceitas(scanner, receitaService, listaReceitas);
                    case 2 -> // Menu de Despesas
                        menuDespesas(scanner, despesaService, listaDespesas);
                    case 3 -> // Consultar Saldo
                        consultarSaldo(despesaService, receitaService);
                    case 4 -> // Gerar Relatório
                        gerarRelatorio(relatorioService, listaDespesas, listaReceitas);
                    case 5 -> {
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

    private static void menuReceitas(Scanner scanner, ReceitaService receitaService, List<Receita> listaReceitas) {
        boolean continuarReceitas = true;
        while (continuarReceitas) {
            System.out.println("\n--- Menu de Receitas ---");
            System.out.println("1. Adicionar Receita");
            System.out.println("2. Ver Receitas");
            System.out.println("3. Deletar Receita");
            System.out.println("4. Voltar");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            switch (opcao) {
                case 1 -> // Adiciona uma nova receita
                    adicionarReceita(scanner, receitaService, listaReceitas);
                case 2 -> // Ver receitas
                    verReceitas(listaReceitas);
                case 3 -> // Deletar receita
                    deletarReceita(scanner, receitaService);
                case 4 -> continuarReceitas = false; // Voltar para o menu principal
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void menuDespesas(Scanner scanner, DespesaService despesaService, List<Despesa> listaDespesas) {
        boolean continuarDespesas = true;
        while (continuarDespesas) {
            System.out.println("\n--- Menu de Despesas ---");
            System.out.println("1. Adicionar Despesa");
            System.out.println("2. Ver Despesas");
            System.out.println("3. Deletar Despesa");
            System.out.println("4. Voltar");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            switch (opcao) {
                case 1 -> // Adiciona uma nova despesa
                    adicionarDespesa(scanner, despesaService, listaDespesas);
                case 2 -> // Ver despesas
                    verDespesas(listaDespesas);
                case 3 -> // Deletar despesa
                    deletarDespesa(scanner, despesaService);
                case 4 -> continuarDespesas = false; // Voltar para o menu principal
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void consultarSaldo(DespesaService despesaService, ReceitaService receitaService) {
        CalcularSaldoTotal calculadora = new CalcularSaldoTotal(despesaService, receitaService);
        double saldoTotal = calculadora.calcularSaldoTotal();
        System.out.printf("Saldo total: R$ %.2f%n", saldoTotal);
    }

    private static void gerarRelatorio(RelatorioService relatorioService, List<Despesa> listaDespesas, List<Receita> listaReceitas) {
        relatorioService.gerarRelatorio(listaDespesas, listaReceitas);
    }

    private static void cadastrarUsuario(Scanner scanner, UsuarioService usuarioService) {
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

    private static void loginUsuario(Scanner scanner, UsuarioService usuarioService) {
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

    private static void adicionarReceita(Scanner scanner, ReceitaService receitaService, List<Receita> listaReceitas) {
        System.out.print("Digite a descrição da receita: ");
        String descricaoReceita = scanner.nextLine();
        double valorReceita = InputUtils.obterValor(scanner);

        Receita novaReceita = new Receita(GeradorId.gerarIdReceita(), descricaoReceita, valorReceita);
        receitaService.adicionarReceita(novaReceita);
        listaReceitas.add(novaReceita); // Adiciona à lista de receitas
        System.out.println("Receita adicionada com sucesso!");
    }

    private static void adicionarDespesa(Scanner scanner, DespesaService despesaService, List<Despesa> listaDespesas) {
        System.out.print("Digite a descrição da despesa: ");
        String descricaoDespesa = scanner.nextLine();
        double valorDespesa = InputUtils.obterValor(scanner);

        Despesa novaDespesa = new Despesa(GeradorId.gerarIdDespesa(), descricaoDespesa, valorDespesa);
        despesaService.adicionarDespesa(novaDespesa);
        listaDespesas.add(novaDespesa); // Adiciona à lista de despesas
        System.out.println("Despesa adicionada com sucesso!");
    }

    private static void verReceitas(List<Receita> listaReceitas) {
        System.out.println("\n--- Lista de Receitas ---");
        for (Receita receita : listaReceitas) {
            System.out.printf("ID: %d | Descrição: %s | Valor: R$%.2f%n", receita.getId(), receita.getDescricao(), receita.getValor());
        }
    }

    private static void verDespesas(List<Despesa> listaDespesas) {
        System.out.println("\n--- Lista de Despesas ---");
        for (Despesa despesa : listaDespesas) {
            System.out.printf("ID: %d | Descrição: %s | Valor: R$%.2f%n", despesa.getId(), despesa.getDescricao(), despesa.getValor());
        }
    }

    private static void deletarReceita(Scanner scanner, ReceitaService receitaService) {
        System.out.print("Digite o ID da receita que deseja deletar: ");
        int idReceita = scanner.nextInt();
        scanner.nextLine(); // Limpar buffer
        receitaService.deletarReceita(idReceita);
        System.out.println("Receita deletada com sucesso!");
    }

    private static void deletarDespesa(Scanner scanner, DespesaService despesaService) {
        System.out.print("Digite o ID da despesa que deseja deletar: ");
        int idDespesa = scanner.nextInt();
        scanner.nextLine(); // Limpar buffer
        despesaService.deletarDespesa(idDespesa);
        System.out.println("Despesa deletada com sucesso!");
    }
}
