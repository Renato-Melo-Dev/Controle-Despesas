package Interfaces;

import java.util.List;

import Entidades.Categoria;

public interface CategoriaRepository {
    void salvar(Categoria categoria);
    List<Categoria> listar();
}
