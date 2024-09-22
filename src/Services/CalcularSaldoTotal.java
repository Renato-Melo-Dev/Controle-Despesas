package Services;

import Entidades.Despesa;
import Entidades.Receita;
import java.util.List;

public class CalcularSaldoTotal {
    public double calcularSaldoTotal(DespesaService despesaService, ReceitaService receitaService, List<Despesa> despesas, List<Receita> receitas) {
        double totalDespesas = despesas.stream().mapToDouble(Despesa::getValor).sum();
        double totalReceitas = receitas.stream().mapToDouble(Receita::getValor).sum();
        return totalReceitas - totalDespesas;
    }
}
