package Services;

import Entidades.Categoria;
import Interfaces.iCategoriaRepositorio;
import java.util.List;

public class CategoriaService {
    private iCategoriaRepositorio categoriaRepository;

    public CategoriaService(iCategoriaRepositorio categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public List<Categoria> obterCategoriasPorTipo(String tipo) {
        return categoriaRepository.listarCategoriasPorTipo(tipo);
    }

    public List<Categoria> listarCategorias() {
        return categoriaRepository.listar();
    }

    public Categoria buscarCategoriaPorId(int id) {
        return categoriaRepository.buscar(id);
    }

    public iCategoriaRepositorio getCategoriaRepository() {
        return categoriaRepository;
    }

    public void setCategoriaRepository(iCategoriaRepositorio categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }
}
