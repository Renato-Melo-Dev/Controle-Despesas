package Services;

import java.sql.SQLException;

import Repository.RelatorioRepositorio;

public class RelatorioService {

    private RelatorioRepositorio relatorioRepositorio;

    public RelatorioService() {
        this.relatorioRepositorio = new RelatorioRepositorio(null);
    }

    public void gerarRelatorio() throws SQLException {
        double totalDespesas = relatorioRepositorio.calcularTotalDespesas();
        double totalReceitas = relatorioRepositorio.calcularTotalReceitas();
        double saldoTotal = relatorioRepositorio.calcularSaldoTotal();

        System.out.println("Relatório de Despesas e Receitas");
        System.out.println("Total Despesas: " + totalDespesas);
        System.out.println("Total Receitas: " + totalReceitas);
        System.out.println("Saldo Total: " + saldoTotal);
    }

    public RelatorioRepositorio getRelatorioRepositorio() {
        return relatorioRepositorio;
    }

    public void setRelatorioRepositorio(RelatorioRepositorio relatorioRepositorio) {
        this.relatorioRepositorio = relatorioRepositorio;
    }
}
