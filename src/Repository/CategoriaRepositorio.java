package Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Entidades.Categoria;

public class CategoriaRepositorio {

    private final Connection connection;

    // Construtor
    public CategoriaRepositorio(Connection connection) {
        this.connection = connection;
    }

    // Método para salvar uma nova categoria
    public void salvar(Categoria categoria) throws SQLException {
        String query = "INSERT INTO categorias (nome, descricao) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, categoria.getNome());
            stmt.executeUpdate();
        }
    }

    // Método para listar todas as categorias
    public List<Categoria> listar() throws SQLException {
        String query = "SELECT * FROM categorias";
        List<Categoria> categorias = new ArrayList<>();
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Categoria categoria = new Categoria(
                        rs.getInt("id"),
                        rs.getString("nome")
                );
                categorias.add(categoria);
            }
        }
        return categorias;
    }
    
    // Método para buscar uma categoria pelo ID
    public Categoria buscarPorId(int id) throws SQLException {
        String query = "SELECT * FROM categorias WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Categoria(
                            rs.getInt("id"),
                            rs.getString("nome")
                    );
                }
            }
        }
        return null;
    }
}
