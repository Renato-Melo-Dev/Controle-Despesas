package Interfaces;

import Entidades.Categoria;
import java.util.List;

public interface iCategoriaRepositorio {
    void adicionar(Categoria categoria);
    Categoria buscar(int id);
    List<Categoria> listar();
    List<Categoria> listarCategoriasPorTipo(String tipo);
    boolean deletar(Categoria categoria);
}
