package Interfaces;

import Entidades.Despesa;
import java.util.List;

public interface iDespesaRepositorio {
    void adicionar(Despesa despesa);
    Despesa buscar(int id);
    List<Despesa> listar();
    boolean deletar(Despesa despesa);
}
