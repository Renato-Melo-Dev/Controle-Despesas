package Interfaces;

import Entidades.Receita;
import java.util.List;

public interface ReceitaRepository {
    void adicionar(Receita receita);
    List<Receita> listar();
    void atualizar(Receita receita);
    void deletar(int id);
}
