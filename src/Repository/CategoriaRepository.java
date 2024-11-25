package Repository;

import Entidades.Categoria;
import Interfaces.iCategoriaRepositorio;
import java.util.ArrayList;
import java.util.List;

public class CategoriaRepository implements iCategoriaRepositorio {
    private List<Categoria> categorias;

    public CategoriaRepository() {
        this.categorias = new ArrayList<>();
        // Exemplos de categorias
        categorias.add(new Categoria(1, "Alimentação", null));
        categorias.add(new Categoria(2, "Transporte", null));
        categorias.add(new Categoria(3, "Saúde", null));
    }

    @Override
    public void adicionar(Categoria categoria) {
        categorias.add(categoria);
    }

    @Override
    public Categoria buscar(int id) {
        for (Categoria categoria : categorias) {
            if (categoria.getId() == id) {
                return categoria;
            }
        }
        return null;
    }

    @Override
    public List<Categoria> listar() {
        return new ArrayList<>(categorias);  // Retorna uma cópia para evitar modificações diretas
    }

    @Override
    public List<Categoria> listarCategoriasPorTipo(String tipo) {
        // Retorna as categorias baseadas no tipo
        List<Categoria> categoriasFiltradas = new ArrayList<>();
        for (Categoria categoria : categorias) {
            if (categoria.getTipo() != null && categoria.getTipo().equalsIgnoreCase(tipo)) {
                categoriasFiltradas.add(categoria);
            }
        }
        return categoriasFiltradas;
    }

    @Override
    public boolean deletar(Categoria categoria) {
        return categorias.remove(categoria);
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }
}
