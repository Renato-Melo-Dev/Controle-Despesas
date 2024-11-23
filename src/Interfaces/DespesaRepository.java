package Interfaces;

import Entidades.Despesa;
import java.util.List;

public interface DespesaRepository {

    // Método para adicionar uma nova despesa
    void adicionar(Despesa despesa);

    // Método para listar todas as despesas
    List<Despesa> listar();

    // Método para atualizar uma despesa existente
    void atualizar(Despesa despesa);

    // Método para deletar uma despesa por ID
    void deletar(int id);
}
