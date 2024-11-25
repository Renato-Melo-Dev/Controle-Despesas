package Repository;

import Entidades.Receita;
import EstruturaDados.ArvoreBinary;
import EstruturaDados.Nodo;
import Interfaces.iReceitaRepositorio;
import java.util.ArrayList;
import java.util.List;

public class ReceitaRepositorio implements iReceitaRepositorio {
    private ArvoreBinary<Receita> arvoreReceitas;

    public ReceitaRepositorio() {
        this.arvoreReceitas = new ArvoreBinary<>();
    }

    @Override
    public void adicionar(Receita receita) {
        arvoreReceitas.inserir(receita);  // Inserir receita na árvore binária
    }

    @Override
    public List<Receita> listar() {
        List<Receita> receitas = new ArrayList<>();
        listarEmOrdem(arvoreReceitas.getRaiz(), receitas);  // Listar receitas em ordem
        return receitas;
    }

    // Método recursivo para listar receitas em ordem
    private void listarEmOrdem(Nodo<Receita> nodo, List<Receita> receitas) {
        if (nodo != null) {
            listarEmOrdem(nodo.getEsquerda(), receitas);  // Percorre a subárvore esquerda
            receitas.add(nodo.getDado());  // Adiciona o dado do nó à lista
            listarEmOrdem(nodo.getDireita(), receitas);  // Percorre a subárvore direita
        }
    }

    @Override
    public boolean remover(int id) {
        // Buscar a receita pelo ID
        Receita receita = buscar(id);
        if (receita != null) {
            // Se a receita for encontrada, remover da árvore
            return arvoreReceitas.deletar(receita);
        }
        return false;  // Não encontrou a receita para remover
    }

    @Override
    public boolean deletar(Receita receita) {
        return arvoreReceitas.deletar(receita);  // Deletar receita da árvore binária
    }

    @Override
    public Receita buscar(int id) {
        return buscarRecursivo(arvoreReceitas.getRaiz(), id);  // Buscar receita pelo ID
    }

    // Método recursivo para buscar a receita pelo ID
    private Receita buscarRecursivo(Nodo<Receita> nodo, int id) {
        if (nodo == null) {
            return null;  // Não encontrou a receita
        }

        // Comparar ID para procurar a receita
        if (id == nodo.getDado().getId()) {
            return nodo.getDado();  // Encontrou a receita
        } else if (id < nodo.getDado().getId()) {
            return buscarRecursivo(nodo.getEsquerda(), id);  // Buscar na subárvore esquerda
        } else {
            return buscarRecursivo(nodo.getDireita(), id);  // Buscar na subárvore direita
        }
    }

    // Getters e Setters
    public ArvoreBinary<Receita> getArvoreReceitas() {
        return arvoreReceitas;
    }

    public void setArvoreReceitas(ArvoreBinary<Receita> arvoreReceitas) {
        this.arvoreReceitas = arvoreReceitas;
    }
}
