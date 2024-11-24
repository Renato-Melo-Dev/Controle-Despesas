package Interfaces;

import java.util.List;

import Entidades.Receita;

public interface ReceitaRepository {
    void adicionar(Receita receita);
    void deletar(int id);
    double calcularTotal();
    List<Receita> listar();
}
