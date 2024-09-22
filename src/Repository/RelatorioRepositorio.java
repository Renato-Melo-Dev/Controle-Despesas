package Repository;

import Entidades.Despesa;
import Entidades.Receita;
import Interfaces.RelatorioRepository;
import java.util.List;

public class RelatorioRepositorio implements RelatorioRepository {
    public double obterTotalDespesas(List<Despesa> despesas) {
        return despesas.stream().mapToDouble(Despesa::getValor).sum();
    }

    public double obterTotalReceitas(List<Receita> receitas) {
        return receitas.stream().mapToDouble(Receita::getValor).sum();
    }
}

    
