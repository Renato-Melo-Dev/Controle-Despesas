package Interfaces;

import Entidades.Receita;
import java.util.List;

public interface ReceitaRepository {

    // Método para adicionar uma nova receita
    void adicionar(Receita receita);

    // Método para listar todas as receitas
    List<Receita> listar();

    // Método para atualizar uma receita existente
    void atualizar(Receita receita);

    // Método para deletar uma receita por ID
    void deletar(int id);
}
