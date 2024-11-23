package Services;

import Repository.RelatorioRepositorio;

public class RelatorioService {

    private RelatorioRepositorio relatorioRepositorio;

    public RelatorioService() {
        this.relatorioRepositorio = new RelatorioRepositorio();
    }

    public void gerarRelatorio() {
        double totalDespesas = relatorioRepositorio.obterTotalDespesas();
        double totalReceitas = relatorioRepositorio.obterTotalReceitas();
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
