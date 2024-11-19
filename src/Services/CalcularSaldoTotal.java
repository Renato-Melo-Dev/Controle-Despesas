package Services;

import Entidades.Despesa;
import Entidades.Receita;
import java.util.List;

public class CalcularSaldoTotal {
    private final DespesaService despesaService;
    private final ReceitaService receitaService;

    public CalcularSaldoTotal(DespesaService despesaService, ReceitaService receitaService) {
        this.despesaService = despesaService;
        this.receitaService = receitaService;
    }

    public double calcularSaldoTotal() {
        double totalDespesas = 0.0;
        double totalReceitas = 0.0;

        // Obtemos as listas de despesas e receitas através dos serviços
        List<Despesa> listaDespesas = despesaService.listarDespesas();
        List<Receita> listaReceitas = receitaService.listarReceitas();

        // Soma das despesas
        for (Despesa despesa : listaDespesas) {
            totalDespesas += despesa.getValor();
        }

        // Soma das receitas
        for (Receita receita : listaReceitas) {
            totalReceitas += receita.getValor();
        }

        // Retorna a diferença entre receitas e despesas
        return totalReceitas - totalDespesas;
    }

    public ReceitaService getReceitaService() {
        return receitaService;
    }

    public DespesaService getDespesaService() {
        return despesaService;
    }
}
