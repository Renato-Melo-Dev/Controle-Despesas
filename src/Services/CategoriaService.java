package Services;

import java.util.List;

import Entidades.Categoria;

public interface CategoriaService {
    void salvar(Categoria categoria);
    List<Categoria> listar();
}
