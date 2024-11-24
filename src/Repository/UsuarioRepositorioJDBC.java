package Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import Entidades.Usuario;
import Interfaces.UsuarioRepository;

public class UsuarioRepositorioJDBC implements UsuarioRepository {
    private static final Logger logger = Logger.getLogger(UsuarioRepositorioJDBC.class.getName()); // Inicializando o Logger
    private final Connection connection;

    // Construtor que recebe a conexão com o banco de dados
    public UsuarioRepositorioJDBC(Connection connection) {
        this.connection = connection;
    }

    // Método para salvar um usuário no banco de dados
    @Override
    public void salvar(Usuario usuario) {
        String sql = "INSERT INTO usuarios (nome, email, senha) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, usuario.getSenha());
            stmt.executeUpdate();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Erro ao salvar usuário no banco de dados", e); // Usando Logger para registrar o erro
        }
    }

    // Método para autenticar um usuário com email e senha
    @Override
    public boolean autenticar(String email, String senha) {
        String sql = "SELECT COUNT(*) FROM usuarios WHERE email = ? AND senha = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, email);
            stmt.setString(2, senha);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Erro ao autenticar o usuário", e); // Usando Logger para registrar o erro
        }
        return false;
    }

    // Método para verificar se existe um usuário com o email fornecido
    @Override
    public boolean existePorEmail(String email) {
        String sql = "SELECT COUNT(*) FROM usuarios WHERE email = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Erro ao verificar a existência do email", e); // Usando Logger para registrar o erro
        }
        return false;
    }
}
