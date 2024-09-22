package Services;

import Interfaces.RelatorioRepository;
import Entidades.Despesa;
import Entidades.Receita;

import java.util.List;

public class RelatorioService {
    private final RelatorioRepository relatorioRepository;

    public RelatorioService(RelatorioRepository relatorioRepository) {
        this.relatorioRepository = relatorioRepository;
    }

    public double calcularTotalDespesas(List<Despesa> despesas) {
        return relatorioRepository.obterTotalDespesas(despesas);
    }

    public double calcularTotalReceitas(List<Receita> receitas) {
        return relatorioRepository.obterTotalReceitas(receitas);
    }

    public void gerarRelatorio(List<Despesa> despesas, List<Receita> receitas) {
        double totalDespesas = calcularTotalDespesas(despesas);
        double totalReceitas = calcularTotalReceitas(receitas);
        System.out.println("\n--- Relatório Financeiro ---");
        System.out.printf("Total de Despesas: R$%.2f%n", totalDespesas);
        System.out.printf("Total de Receitas: R$%.2f%n", totalReceitas);
        System.out.printf("Saldo Total: R$%.2f%n", totalReceitas - totalDespesas);
    }
}

