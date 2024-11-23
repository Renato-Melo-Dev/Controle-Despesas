package Repository;

import Config.ConexaoDB;
import Entidades.Categoria;
import Entidades.Receita;
import Interfaces.ReceitaRepository;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReceitaRepositorio implements ReceitaRepository {

    @Override
    public void adicionar(Receita receita) {
        try (Connection conn = ConexaoDB.conectar()) {
            String sql = "INSERT INTO receitas (descricao, valor, idCategoria) VALUES (?, ?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, receita.getDescricao());
                stmt.setDouble(2, receita.getValor());
                stmt.setInt(3, receita.getCategoria().getId()); // Inserir o ID da categoria
                stmt.executeUpdate();
                System.out.println("Receita adicionada com sucesso!");
            }
        } catch (SQLException e) {
            System.err.println("Erro ao adicionar receita: " + e.getMessage());
        }
    }

    @Override
    public List<Receita> listar() {
        List<Receita> receitas = new ArrayList<>();
        try (Connection conn = ConexaoDB.conectar()) {
            String sql = "SELECT * FROM receitas";
            try (Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(sql)) {
                while (rs.next()) {
                    int idCategoria = rs.getInt("idCategoria");
                    Categoria categoria = buscarCategoriaPorId(idCategoria); // Buscar a categoria associada

                    Receita receita = new Receita(
                        rs.getInt("idReceita"),
                        rs.getString("descricao"),
                        rs.getDouble("valor"),
                        categoria
                    );
                    receitas.add(receita);
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar receitas: " + e.getMessage());
        }
        return receitas;
    }

    @Override
    public void atualizar(Receita receita) {
        try (Connection conn = ConexaoDB.conectar()) {
            String sql = "UPDATE receitas SET descricao = ?, valor = ?, idCategoria = ? WHERE idReceita = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, receita.getDescricao());
                stmt.setDouble(2, receita.getValor());
                stmt.setInt(3, receita.getCategoria().getId()); // Atualiza o ID da categoria
                stmt.setInt(4, receita.getId()); // Atualiza a receita pelo seu ID
                stmt.executeUpdate();
                System.out.println("Receita atualizada com sucesso!");
            }
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar receita: " + e.getMessage());
        }
    }

    @Override
    public void deletar(int id) {
        try (Connection conn = ConexaoDB.conectar()) {
            String sql = "DELETE FROM receitas WHERE idReceita = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, id);
                stmt.executeUpdate();
                System.out.println("Receita deletada com sucesso!");
            }
        } catch (SQLException e) {
            System.err.println("Erro ao deletar receita: " + e.getMessage());
        }
    }

    // Método auxiliar para buscar a categoria pelo ID
    private Categoria buscarCategoriaPorId(int idCategoria) {
        Categoria categoria = null;
        try (Connection conn = ConexaoDB.conectar()) {
            String sql = "SELECT * FROM categorias WHERE idCategoria = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, idCategoria);
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        categoria = new Categoria(
                            rs.getInt("idCategoria"),
                            rs.getString("nome")
                        );
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar categoria: " + e.getMessage());
        }
        return categoria;
    }
}
