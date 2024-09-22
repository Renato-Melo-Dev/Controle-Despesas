package Repository;

import Entidades.Despesa;
import Interfaces.DespesaRepository;
import java.util.ArrayList;
import java.util.List;

public class DespesaRepositorio implements DespesaRepository {
    private List<Despesa> despesas = new ArrayList<>();

    @Override
    public void adicionar(Despesa despesa) {
        despesas.add(despesa);
    }

    @Override
    public List<Despesa> listar() {
        return despesas;
    }

    @Override
    public void atualizar(Despesa despesa) {
        for (int i = 0; i < despesas.size(); i++) {
            if (despesas.get(i).getId() == despesa.getId()) {
                despesas.set(i, despesa);
                break;
            }
        }
    }

    @Override
    public void deletar(int id) {
        despesas.removeIf(d -> d.getId() == id);
    }

    public List<Despesa> getDespesas() {
        return despesas;
    }

    public void setDespesas(List<Despesa> despesas) {
        this.despesas = despesas;
    }
}
