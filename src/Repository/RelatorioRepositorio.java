package Repository;

import Interfaces.RelatorioRepository;
import Entidades.Despesa;
import Entidades.Receita;

import java.util.List;

public class RelatorioRepositorio implements RelatorioRepository {
    @Override
    public double obterTotalDespesas(List<Despesa> despesas) {
        return despesas.stream().mapToDouble(Despesa::getValor).sum();
    }

    @Override
    public double obterTotalReceitas(List<Receita> receitas) {
        return receitas.stream().mapToDouble(Receita::getValor).sum();
    }
}

    
