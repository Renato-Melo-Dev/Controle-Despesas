package Interfaces;

import Entidades.Categoria;
import java.util.List;

public interface CategoriaRepository {

    void adicionar(Categoria categoria);

    List<Categoria> listar();
}
