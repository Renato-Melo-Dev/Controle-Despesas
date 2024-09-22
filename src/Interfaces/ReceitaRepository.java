package Interfaces;

import Entidades.Receita;

public interface ReceitaRepository {
    void salvarReceita(Receita receita);
    Receita buscarReceitaPorId(long id);
    double obterTotalReceitas(Receita receita);
}
