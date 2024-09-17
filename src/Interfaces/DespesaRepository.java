package Interfaces;

import Entidades.Despesa;

public interface DespesaRepository {
    Despesa buscarPorId(int id);
    void salvar(Despesa despesa);
    void adicionarDespesa(Despesa despesa);
}

