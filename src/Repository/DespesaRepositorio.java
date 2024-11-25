package Repository;

import Entidades.Despesa;
import EstruturaDados.ArvoreBinary;
import EstruturaDados.Nodo;  // Importando a classe Nodo
import Interfaces.iDespesaRepositorio;
import java.util.ArrayList;
import java.util.List;

public class DespesaRepositorio implements iDespesaRepositorio {

    private ArvoreBinary<Despesa> arvoreDespesa;

    public DespesaRepositorio() {
        // Inicializando a árvore binária
        arvoreDespesa = new ArvoreBinary<>();
    }

    @Override
    public void adicionar(Despesa despesa) {
        arvoreDespesa.inserir(despesa);  // Inserindo a despesa na árvore binária
    }

    @Override
    public Despesa buscar(int id) {
        // Buscando a despesa pelo id (passamos uma despesa com o id desejado para buscar)
        return arvoreDespesa.buscar(new Despesa(id, null, 0, null));
    }

    @Override
    public List<Despesa> listar() {
        // Para listar as despesas, fazemos uma travessia em ordem (in-order traversal)
        // e coletamos as despesas em uma lista
        List<Despesa> despesas = new ArrayList<>();
        listarEmOrdemRecursivo(arvoreDespesa.getRaiz(), despesas);
        return despesas;
    }

    private void listarEmOrdemRecursivo(Nodo<Despesa> nodo, List<Despesa> despesas) {
        if (nodo != null) {
            listarEmOrdemRecursivo(nodo.getEsquerda(), despesas);
            despesas.add(nodo.getDado());  // Adicionando a despesa na lista
            listarEmOrdemRecursivo(nodo.getDireita(), despesas);
        }
    }

    @Override
    public boolean deletar(Despesa despesa) {
        // Remover a despesa usando a árvore binária
        return arvoreDespesa.deletar(despesa);
    }

    public ArvoreBinary<Despesa> getArvoreDespesa() {
        return arvoreDespesa;
    }

    public void setArvoreDespesa(ArvoreBinary<Despesa> arvoreDespesa) {
        this.arvoreDespesa = arvoreDespesa;
    }
}
