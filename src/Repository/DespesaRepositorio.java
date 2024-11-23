package Repository;

import Config.ConexaoDB;
import Entidades.Despesa;
import Interfaces.DespesaRepository;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DespesaRepositorio implements DespesaRepository {

    @Override
    public void adicionar(Despesa despesa) {
        String sql = "INSERT INTO despesas (descricao, valor) VALUES (?, ?)";
        try (Connection conn = ConexaoDB.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, despesa.getDescricao());
            stmt.setDouble(2, despesa.getValor());
            stmt.executeUpdate();
            System.out.println("Despesa adicionada com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao adicionar despesa: " + e.getMessage());
        }
    }

    @Override
    public List<Despesa> listar() {
        List<Despesa> despesas = new ArrayList<>();
        String sql = "SELECT * FROM despesas";
        try (Connection conn = ConexaoDB.conectar(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Despesa despesa = new Despesa(rs.getInt("id"), rs.getString("descricao"), rs.getDouble("valor"), null);
                despesas.add(despesa);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar despesas: " + e.getMessage());
        }
        return despesas;
    }

    @Override
    public void atualizar(Despesa despesa) {
        String sql = "UPDATE despesas SET descricao = ?, valor = ? WHERE id = ?";
        try (Connection conn = ConexaoDB.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, despesa.getDescricao());
            stmt.setDouble(2, despesa.getValor());
            stmt.setInt(3, despesa.getId());
            stmt.executeUpdate();
            System.out.println("Despesa atualizada com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar despesa: " + e.getMessage());
        }
    }

    @Override
    public void deletar(int id) {
        String sql = "DELETE FROM despesas WHERE id = ?";
        try (Connection conn = ConexaoDB.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Despesa deletada com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao deletar despesa: " + e.getMessage());
        }
    }
}
