package Repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import Entidades.Despesa;
import Interfaces.DespesaRepository;

public class DespesaRepositorioJDBC implements DespesaRepository {
    private final Connection connection;
    private static final Logger logger = Logger.getLogger(DespesaRepositorioJDBC.class.getName());

    public DespesaRepositorioJDBC(Connection connection) {
        this.connection = connection;
    }

    public void adicionarDespesa(Despesa despesa) {
        String sql = "INSERT INTO despesas (id, descricao, valor, data) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, despesa.getId());
            stmt.setString(2, despesa.getDescricao());
            stmt.setDouble(3, despesa.getValor());
            stmt.setDate(4, Date.valueOf(despesa.getData()));
            stmt.executeUpdate();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Erro ao adicionar despesa no banco de dados", e);
        }
    }

    public List<Despesa> listarDespesas() {
        List<Despesa> despesas = new ArrayList<>();
        String sql = "SELECT * FROM despesas";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Despesa despesa = new Despesa(
                        rs.getInt("id"),
                        rs.getString("descricao"),
                        rs.getDouble("valor"),
                        rs.getDate("data").toLocalDate(), null
                );
                despesas.add(despesa);
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Erro ao listar despesas", e);
        }
        return despesas;
    }

    public void deletarDespesa(int id) {
        String sql = "DELETE FROM despesas WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Erro ao deletar despesa com ID: " + id, e);
        }
    }

    @Override
    public void salvar(Despesa despesa) {
        // Método não implementado, lançar UnsupportedOperationException
        throw new UnsupportedOperationException("Método salvar não implementado.");
    }

    @Override
    public List<Despesa> listar() {
        // Método não implementado, lançar UnsupportedOperationException
        throw new UnsupportedOperationException("Método listar não implementado.");
    }

    @Override
    public double calcularTotal() {
        // Método não implementado, lançar UnsupportedOperationException
        throw new UnsupportedOperationException("Método calcularTotal não implementado.");
    }

    @Override
    public void adicionar(Despesa despesa) {
        // Método não implementado, lançar UnsupportedOperationException
        throw new UnsupportedOperationException("Método adicionar não implementado.");
    }

    @Override
    public void atualizar(Despesa despesa) {
        // Método não implementado, lançar UnsupportedOperationException
        throw new UnsupportedOperationException("Método atualizar não implementado.");
    }

    @Override
    public boolean deletar(int id) {
        // Método não implementado, lançar UnsupportedOperationException
        throw new UnsupportedOperationException("Método deletar não implementado.");
    }
}
