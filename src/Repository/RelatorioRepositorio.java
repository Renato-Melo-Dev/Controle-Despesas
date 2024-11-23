package Repository;

import Config.ConexaoDB;
import Interfaces.RelatorioRepository;
import java.sql.*;

public class RelatorioRepositorio implements RelatorioRepository {

    // Método para obter o total das despesas diretamente do banco de dados
    public double obterTotalDespesas() {
        double totalDespesas = 0.0;
        try (Connection conn = ConexaoDB.conectar()) {
            String sql = "SELECT SUM(valor) AS total FROM despesas";
            try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
                if (rs.next()) {
                    totalDespesas = rs.getDouble("total");
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao obter total de despesas: " + e.getMessage());
        }
        return totalDespesas;
    }

    // Método para obter o total das receitas diretamente do banco de dados
    public double obterTotalReceitas() {
        double totalReceitas = 0.0;
        try (Connection conn = ConexaoDB.conectar()) {
            String sql = "SELECT SUM(valor) AS total FROM receitas";
            try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
                if (rs.next()) {
                    totalReceitas = rs.getDouble("total");
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao obter total de receitas: " + e.getMessage());
        }
        return totalReceitas;
    }

    public double calcularSaldoTotal() {
        double totalReceitas = obterTotalReceitas();
        double totalDespesas = obterTotalDespesas();
        return totalReceitas - totalDespesas;
    }
}
