package Services;

import Entidades.Despesa;
import Entidades.Receita;
import java.util.List;

public class CalcularSaldoTotal {
    public  double calcularSaldoTotal(DespesaService despesaService, ReceitaService receitaService, List<Despesa> listaDespesas, List<Receita> listaReceitas) {
        double totalDespesas = despesaService.obterTotalDespesas(listaDespesas);
        double totalReceitas = receitaService.obterTotalReceitas(listaReceitas);
        return totalReceitas - totalDespesas;
    }
    
}
