package Repository;

import Entidades.Despesa;
import Interfaces.DespesaRepository;
import java.util.ArrayList;
import java.util.List;

public class DespesaRepositorio implements DespesaRepository {
    public List<Despesa> despesas;

    public DespesaRepositorio() {
        this.despesas = new ArrayList<>();
    }

    @Override
    public void salvar(Despesa despesa) {
        despesas.add(despesa);
    }

    @Override
    public Despesa buscarPorId(int id) {
        for (Despesa d : despesas) {
            if (d.getId() == id) {
                return d;
            }
        }
        return null;
    }
    @Override
    public void adicionarDespesa(Despesa despesa) {
        despesas.add(despesa);
}
    @Override
    public void obterTotalDespesas(Despesa despesa) {
        double total = 0.0;
        for (Despesa d : despesas) {
            total += d.getValor();
        }
        System.out.println("Total de despesas: " + total);
}
}

