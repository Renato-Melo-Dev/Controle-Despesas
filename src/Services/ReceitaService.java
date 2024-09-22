package Services;

import Entidades.Receita;
import Interfaces.ReceitaRepository;
import java.util.List;

public class ReceitaService {
    private ReceitaRepository receitaRepository;

    public ReceitaService(ReceitaRepository receitaRepository) {
        this.receitaRepository = receitaRepository;
    }

    public void adicionarReceita(Receita receita) {
        receitaRepository.adicionar(receita);
    }

    public List<Receita> listarReceitas() {
        return receitaRepository.listar();
    }

    public void atualizarReceita(Receita receita) {
        receitaRepository.atualizar(receita);
    }

    public void deletarReceita(int id) {
        receitaRepository.deletar(id);
    }

    public ReceitaRepository getReceitaRepository() {
        return receitaRepository;
    }

    public void setReceitaRepository(ReceitaRepository receitaRepository) {
        this.receitaRepository = receitaRepository;
    }
}
