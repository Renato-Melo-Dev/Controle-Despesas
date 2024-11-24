package Interfaces;

import java.util.List;

import Entidades.Despesa;

public interface DespesaRepository {
    void salvar(Despesa despesa);
    List<Despesa> listar();
    double calcularTotal();
    void adicionar(Despesa despesa);
    void atualizar(Despesa despesa);
    boolean deletar(int id);
}
