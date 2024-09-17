


import Entidades.Despesa;
import Entidades.Receita;
import Entidades.Usuario;
import Interfaces.DespesaRepository;
import Interfaces.ReceitaRepository;
import Interfaces.UsuarioRepository;
import Repository.DespesaRepositorio;
import Repository.ReceitaRepositorio;
import Repository.UsuarioRepositorio;
import Services.DespesaService;
import Services.ReceitaService;
import Services.UsuarioService;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DespesaRepository despesaRepository = new DespesaRepositorio();
        ReceitaRepository receitaRepository = new ReceitaRepositorio();
        UsuarioRepository usuarioRepository = new UsuarioRepositorio();

        DespesaService despesaService = new DespesaService(despesaRepository);
        ReceitaService receitaService = new ReceitaService(receitaRepository);
        UsuarioService usuarioService = new UsuarioService(usuarioRepository);

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
                    System.out.println("Preencha os dados.");
                    System.out.print("Digite seu nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Digite seu email: ");
                    String email = scanner.nextLine();
                    System.out.print("Digite sua senha: ");
                    String senha = scanner.nextLine();
                    Usuario novoUsuario = new Usuario(1, nome, email, senha);
                    usuarioService.criarUsuario(novoUsuario);
                    System.out.println("Usuário cadastrado com sucesso!");
                }
                case 2 -> {
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

            while (continuarExecucao) { {
                System.out.println("\n--- Sistema de Gerenciamento de Custos ---");
                System.out.println("1. Adicionar Despesa");
                System.out.println("2. Adicionar Receita");
                System.out.println("3. Consultar Saldo Total");
                System.out.println("4. Sair");
                System.out.print("Escolha uma opção: ");
                int opcao = scanner.nextInt();
                scanner.nextLine(); // Consumir a quebra de linha

                switch (opcao) {
                    case 1 -> {
                        System.out.print("Digite a descrição da despesa: ");
                        String descricaoDespesa = scanner.nextLine();
                        System.out.print("Digite o valor da despesa: ");
                        double valorDespesa = scanner.nextDouble();
                        scanner.nextLine(); // Consumir a quebra de linha

                        Despesa novaDespesa = new Despesa(1, descricaoDespesa, valorDespesa);
                        despesaService.adicionarDespesa(novaDespesa);
                        System.out.println("Despesa adicionada com sucesso!");
                        break;
                    }

                    case 2 -> {
                        System.out.print("Digite a descrição da receita: ");
                        String descricaoReceita = scanner.nextLine();
                        System.out.print("Digite o valor da receita: ");
                        double valorReceita = scanner.nextDouble();
                        scanner.nextLine();
                        
                        Receita novaReceita = new Receita(1, descricaoReceita, valorReceita);
                        receitaService.adicionarReceita(novaReceita);
                        System.out.println("Receita adicionada com sucesso!");
                        break;
                    }

                    case 3 -> {
                    }

                    case 4 -> {
                        System.out.println("Encerrando o programa. Até mais!");
                        scanner.close();
                        continuarExecucao = false;
                        break;
                    }
                    default -> System.out.println("Opção inválida. Tente novamente.");
                }
            }
   }
        }
    }
}