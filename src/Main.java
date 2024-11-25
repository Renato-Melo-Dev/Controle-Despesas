import Entidades.Categoria;
import Entidades.Despesa;
import Repository.CategoriaRepository;
import Repository.DespesaRepositorio;
import Services.CategoriaService;
import Services.DespesaService;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            // Criar instâncias dos repositórios e serviços
            CategoriaRepository categoriaRepository = new CategoriaRepository();
            CategoriaService categoriaService = new CategoriaService(categoriaRepository);
            DespesaRepositorio despesaRepositorio = new DespesaRepositorio();
            DespesaService despesaService = new DespesaService(despesaRepositorio, categoriaService);

            // Adicionar algumas categorias para o teste
            categoriaRepository.adicionar(new Categoria(1, "Alimentação", null));
            categoriaRepository.adicionar(new Categoria(2, "Transporte", null));
            categoriaRepository.adicionar(new Categoria(3, "Saúde", null));
            categoriaRepository.adicionar(new Categoria(4, "Lazer", null));

            boolean continuar = true;

            while (continuar) {
                System.out.println("\nMenu Principal:");
                System.out.println("1. Gerenciar Despesas");
                System.out.println("2. Calcular Saldo");
                System.out.println("3. Listar Despesas");
                System.out.println("4. Sair");

                System.out.print("Escolha uma opção: ");
                int opcao = scanner.nextInt();
                scanner.nextLine();  // Limpar buffer

                switch (opcao) {
                    case 1 -> gerenciarDespesas(scanner, despesaService); // Gerenciar despesas
                    case 2 -> calcularSaldo(despesaService);  // Calcular saldo considerando despesas
                    case 3 -> listarDespesas(despesaService);  // Listar despesas
                    case 4 -> continuar = false;
                    default -> System.out.println("Opção inválida! Tente novamente.");
                }
            }
        }
    }

    // Método para gerenciar despesas
    private static void gerenciarDespesas(Scanner scanner, DespesaService despesaService) {
        boolean continuar = true;
        while (continuar) {
            System.out.println("\nGerenciar Despesas:");
            System.out.println("1. Adicionar Despesa");
            System.out.println("2. Remover Despesa");
            System.out.println("3. Voltar");

            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();  // Limpar buffer

            switch (opcao) {
                case 1 -> adicionarDespesa(scanner, despesaService);  // Adicionar nova despesa
                case 2 -> removerDespesa(scanner, despesaService);  // Remover despesa existente
                case 3 -> continuar = false;
                default -> System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }

    // Método para adicionar uma despesa
    private static void adicionarDespesa(Scanner scanner, DespesaService despesaService) {
        System.out.print("Digite a descrição da despesa: ");
        String descricao = scanner.nextLine();
        System.out.print("Digite o valor da despesa: ");
        double valor = scanner.nextDouble();
        scanner.nextLine();  // Limpar buffer

        // Obter a categoria a partir das opções disponíveis
        System.out.println("\nEscolha a categoria:");
        List<Categoria> categorias = despesaService.getCategoriaService().listarCategorias();
        for (Categoria categoria : categorias) {
            System.out.println(categoria.getId() + ". " + categoria.getNome());
        }
        System.out.print("Digite o ID da categoria: ");
        int categoriaId = scanner.nextInt();
        scanner.nextLine();  // Limpar buffer

        Categoria categoriaEscolhida = despesaService.getCategoriaService().buscarCategoriaPorId(categoriaId);
        if (categoriaEscolhida != null) {
            // Gerar ID automático para a despesa
            Despesa despesa = new Despesa(despesaService.gerarIdDespesa(), descricao, valor, categoriaEscolhida);
            despesaService.adicionarDespesa(despesa);
            System.out.println("Despesa adicionada com sucesso!");
        } else {
            System.out.println("Categoria inválida.");
        }
    }

    // Método para remover uma despesa
    private static void removerDespesa(Scanner scanner, DespesaService despesaService) {
        System.out.print("Digite o ID da despesa a ser removida: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Limpar buffer
        boolean sucesso = despesaService.removerDespesa(id);
        if (sucesso) {
            System.out.println("Despesa removida com sucesso!");
        } else {
            System.out.println("Despesa não encontrada.");
        }
    }

    // Método para calcular o saldo de despesas
    private static void calcularSaldo(DespesaService despesaService) {
        double saldo = despesaService.calcularSaldo();
        System.out.println("Saldo total de despesas: R$ " + saldo);
    }

    // Método para listar as despesas
    private static void listarDespesas(DespesaService despesaService) {
        List<Despesa> despesas = despesaService.listarDespesas();
        System.out.println("\nLista de Despesas:");
        if (despesas.isEmpty()) {
            System.out.println("Nenhuma despesa registrada.");
        } else {
            for (Despesa despesa : despesas) {
                System.out.println(despesa);
            }
        }
    }
}
