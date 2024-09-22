package Interfaces;

import Entidades.Despesa;
import java.util.List;

public interface DespesaRepository {
    void adicionar(Despesa despesa);
    List<Despesa> listar();
    void atualizar(Despesa despesa);
    void deletar(int id);
}
