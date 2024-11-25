package Repository;

import Entidades.Despesa;
import Entidades.Receita;
import Interfaces.iRelatorioRepositorio;
import java.util.List;

public class RelatorioRepositorio implements iRelatorioRepositorio {

    // Método para calcular o total de despesas
    @Override
    public double obterTotalDespesas(List<Despesa> despesas) {
        if (despesas == null || despesas.isEmpty()) {
            return 0.0;  // Retorna 0 se a lista de despesas estiver vazia ou for nula
        }
        // Utiliza Stream para somar os valores das despesas
        return despesas.stream().mapToDouble(Despesa::getValor).sum();
    }

    // Método para calcular o total de receitas
    @Override
    public double obterTotalReceitas(List<Receita> receitas) {
        if (receitas == null || receitas.isEmpty()) {
            return 0.0;  // Retorna 0 se a lista de receitas estiver vazia ou for nula
        }
        // Utiliza Stream para somar os valores das receitas
        return receitas.stream().mapToDouble(Receita::getValor).sum();
    }
}
