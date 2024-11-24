package Repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import Entidades.Categoria;
import Entidades.Receita;
import Interfaces.ReceitaRepository;

public class ReceitaRepositorioJDBC implements ReceitaRepository {
    private final Connection connection;
    private static final Logger logger = Logger.getLogger(ReceitaRepositorioJDBC.class.getName());

    public ReceitaRepositorioJDBC(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void adicionar(Receita receita) {
        String sql = "INSERT INTO receitas (id, descricao, valor, data, categoria_id) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, receita.getId());
            stmt.setString(2, receita.getDescricao());
            stmt.setDouble(3, receita.getValor());
            stmt.setDate(4, Date.valueOf(receita.getData()));
            stmt.setInt(5, receita.getCategoria().getId());  // Associando o ID da categoria
            stmt.executeUpdate();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Erro ao adicionar a receita no banco de dados", e);
        }
    }

    @Override
    public void deletar(int id) {
        String sql = "DELETE FROM receitas WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Erro ao deletar a receita com ID: " + id, e);
        }
    }

    @Override
    public double calcularTotal() {
        String sql = "SELECT SUM(valor) FROM receitas";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getDouble(1);
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Erro ao calcular o total das receitas", e);
        }
        return 0.0;
    }

    @Override
    public List<Receita> listar() {
        List<Receita> receitas = new ArrayList<>();
        String sql = "SELECT id, descricao, valor, data, categoria_id FROM receitas";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                // Criando a categoria placeholder para associar a receita
                int categoriaId = rs.getInt("categoria_id");
                Categoria categoria = new Categoria(categoriaId, "Categoria Placeholder");

                Receita receita = new Receita(
                        rs.getInt("id"),
                        rs.getString("descricao"),
                        rs.getDouble("valor"),
                        rs.getDate("data").toLocalDate(),
                        categoriaId, categoria // Associando a categoria
                );
                receitas.add(receita);
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Erro ao listar as receitas", e);
        }
        return receitas;
    }
}
