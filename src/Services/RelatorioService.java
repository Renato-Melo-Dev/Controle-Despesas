package Services;

import Entidades.Despesa;
import Entidades.Receita;
import java.util.List;

public class RelatorioService {
    private final DespesaService despesaService;
    private final ReceitaService receitaService;

    public RelatorioService(DespesaService despesaService, ReceitaService receitaService) {
        this.despesaService = despesaService;
        this.receitaService = receitaService;
    }

    public String gerarRelatorio() {
        double totalDespesas = calcularTotalDespesas(despesaService.listarDespesas());
        double totalReceitas = calcularTotalReceitas(receitaService.listarReceitas());
        double saldoTotal = totalReceitas - totalDespesas;

        // Criando o relatório em StringBuilder
        StringBuilder relatorio = new StringBuilder();
        relatorio.append("\n--- Relatório de Custos ---\n");
        relatorio.append("Total de Despesas: R$ ").append(String.format("%.2f", totalDespesas)).append("\n");
        relatorio.append("Total de Receitas: R$ ").append(String.format("%.2f", totalReceitas)).append("\n");
        relatorio.append("Saldo Total: R$ ").append(String.format("%.2f", saldoTotal)).append("\n");

        // Detalhes de despesas
        relatorio.append("\n--- Detalhamento das Despesas ---\n");
        exibirDetalhesDespesas(despesaService.listarDespesas(), relatorio);

        // Detalhes de receitas
        relatorio.append("\n--- Detalhamento das Receitas ---\n");
        exibirDetalhesReceitas(receitaService.listarReceitas(), relatorio);

        return relatorio.toString();
    }

    // Método para calcular o total de despesas
    private double calcularTotalDespesas(List<Despesa> despesas) {
        double total = 0;
        for (Despesa despesa : despesas) {
            total += despesa.getValor();
        }
        return total;
    }

    // Método para calcular o total de receitas
    private double calcularTotalReceitas(List<Receita> receitas) {
        double total = 0;
        for (Receita receita : receitas) {
            total += receita.getValor();
        }
        return total;
    }

    // Método para exibir detalhes de despesas
    private void exibirDetalhesDespesas(List<Despesa> despesas, StringBuilder relatorio) {
        if (despesas.isEmpty()) {
            relatorio.append("Nenhuma despesa registrada.\n");
        } else {
            for (Despesa despesa : despesas) {
                relatorio.append(String.format("ID: %d | Descrição: %s | Valor: R$ %.2f%n",
                        despesa.getId(), despesa.getDescricao(), despesa.getValor()));
            }
        }
    }

    // Método para exibir detalhes de receitas
    private void exibirDetalhesReceitas(List<Receita> receitas, StringBuilder relatorio) {
        if (receitas.isEmpty()) {
            relatorio.append("Nenhuma receita registrada.\n");
        } else {
            for (Receita receita : receitas) {
                relatorio.append(String.format("ID: %d | Descrição: %s | Valor: R$ %.2f%n",
                        receita.getId(), receita.getDescricao(), receita.getValor()));
            }
        }
    }
}
