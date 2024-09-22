package Repository;

import Entidades.Receita;
import Interfaces.ReceitaRepository;
import java.util.ArrayList;
import java.util.List;

public class ReceitaRepositorio implements ReceitaRepository {
    private List<Receita> receitas = new ArrayList<>();

    @Override
    public void adicionar(Receita receita) {
        receitas.add(receita);
    }

    @Override
    public List<Receita> listar() {
        return receitas;
    }

    @Override
    public void atualizar(Receita receita) {
        for (int i = 0; i < receitas.size(); i++) {
            if (receitas.get(i).getId() == receita.getId()) {
                receitas.set(i, receita);
                break;
            }
        }
    }

    @Override
    public void deletar(int id) {
        receitas.removeIf(r -> r.getId() == id);
    }

    public List<Receita> getReceitas() {
        return receitas;
    }

    public void setReceitas(List<Receita> receitas) {
        this.receitas = receitas;
    }
}
