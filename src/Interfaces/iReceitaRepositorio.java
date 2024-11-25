package Interfaces;

import Entidades.Receita;
import java.util.List;

public interface iReceitaRepositorio {
    void adicionar(Receita receita);
    Receita buscar(int id);
    List<Receita> listar();
    boolean remover(int id);  // Corrigido para aceitar o ID
    boolean deletar(Receita receita);  // Corrigido para a interface
}
