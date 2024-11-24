import java.sql.Connection;
import java.util.Scanner;

import Entidades.Usuario;
import Interfaces.UsuarioRepository;
import Repository.UsuarioRepositorioJDBC;
import Services.UsuarioService;
import Utils.Conexao;

public class Main {
    public static void main(String[] args) {
        try (Connection connection = Conexao.obterConexao()) {
            // Inicializa o repositório de usuários com a conexão com o banco de dados
            UsuarioRepository usuarioRepository = new UsuarioRepositorioJDBC(connection);

            // Inicializa o serviço de usuários, passando o repositório
            UsuarioService usuarioService = new UsuarioService(usuarioRepository);

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
                    case 1 -> cadastrarUsuario(scanner, usuarioService);
                    case 2 -> loginUsuario(scanner, usuarioService);
                    default -> System.out.println("Opção inválida. Tente novamente.");
                }

                while (continuarExecucao) {
                    // Menu principal do sistema
                    System.out.println("\n--- Menu Principal ---");
                    System.out.println("1. Sair");
                    System.out.print("Escolha uma opção: ");
                    
                    int opcao = scanner.nextInt();
                    scanner.nextLine(); // Limpar buffer
                    
                    switch (opcao) {
                        case 1 -> {
                            System.out.println("Saindo...");
                            continuarExecucao = false;
                        }
                        default -> System.out.println("Opção inválida. Tente novamente.");
                    }
                }
            } catch (Exception e) {
                System.out.println("Erro ao executar o sistema: " + e.getMessage());
            }

        } catch (Exception e) {
            System.out.println("Erro ao conectar com o banco de dados: " + e.getMessage());
        }
    }

    // Método para cadastrar um novo usuário
    private static void cadastrarUsuario(Scanner scanner, UsuarioService usuarioService) {
        System.out.println("Preencha os dados.");
        System.out.print("Digite seu nome: ");
        String nome = scanner.nextLine();
        System.out.print("Digite seu email: ");
        String email = scanner.nextLine();

        if (usuarioService.existeUsuarioPorEmail(email)) {
            System.out.println("Este email já está cadastrado.");
            return;
        }

        System.out.print("Digite sua senha: ");
        String senha = scanner.nextLine();

        // Cria um novo usuário e passa para o serviço salvar no banco
        Usuario novoUsuario = new Usuario(0, nome, email, senha);
        usuarioService.criarUsuario(novoUsuario);
        System.out.println("Usuário cadastrado com sucesso!");
    }

    // Método para fazer o login do usuário
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
}
