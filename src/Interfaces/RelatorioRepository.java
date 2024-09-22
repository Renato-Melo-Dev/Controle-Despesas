package Interfaces;

import Entidades.Despesa;
import Entidades.Receita;
import java.util.List;

public interface RelatorioRepository {
    double obterTotalDespesas(List<Despesa> despesas);
    double obterTotalReceitas(List<Receita> receitas);
}

