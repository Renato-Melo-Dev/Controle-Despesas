package Repository;

import Config.ConexaoDB;
import Entidades.Categoria;
import Interfaces.CategoriaRepository;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoriaRepositorio implements CategoriaRepository {

    // Método para adicionar uma nova categoria no banco de dados
    @Override
    public void adicionar(Categoria categoria) {
        String sql = "INSERT INTO categorias (categoria) VALUES (?)";

        try (Connection conn = ConexaoDB.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, categoria.getNome());
            stmt.executeUpdate();
            System.out.println("Categoria adicionada com sucesso!");

        } catch (SQLException e) {
            System.err.println("Erro ao adicionar a categoria: " + e.getMessage());
        }
    }

    // Método para listar todas as categorias no banco de dados
    @Override
    public List<Categoria> listar() {
        List<Categoria> categorias = new ArrayList<>();
        String sql = "SELECT * FROM categorias";

        try (Connection conn = ConexaoDB.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int idCategoria = rs.getInt("idCategoria");
                String nome = rs.getString("categoria");

                Categoria categoria = new Categoria(idCategoria, nome);
                categorias.add(categoria);
            }

        } catch (SQLException e) {
            System.err.println("Erro ao listar as categorias: " + e.getMessage());
        }
        return categorias;
    }
}

