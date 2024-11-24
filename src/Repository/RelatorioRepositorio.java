package Repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RelatorioRepositorio {

    private final Connection connection;

    // Construtor
    public RelatorioRepositorio(Connection connection) {
        this.connection = connection;
    }

    // Método para calcular o total de despesas
    public double calcularTotalDespesas() throws SQLException {
        String query = "SELECT SUM(valor) AS total FROM despesas";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            if (rs.next()) {
                return rs.getDouble("total");
            }
        }
        return 0.0;
    }

    // Método para calcular o total de receitas
    public double calcularTotalReceitas() throws SQLException {
        String query = "SELECT SUM(valor) AS total FROM receitas";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            if (rs.next()) {
                return rs.getDouble("total");
            }
        }
        return 0.0;
    }

    // Método para calcular o saldo total (receitas - despesas)
    public double calcularSaldoTotal() throws SQLException {
        double totalReceitas = calcularTotalReceitas();
        double totalDespesas = calcularTotalDespesas();
        return totalReceitas - totalDespesas;
    }
}
