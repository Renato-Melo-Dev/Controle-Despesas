package Services;

import Entidades.Despesa;
import Interfaces.DespesaRepository;
import java.util.List;

public class DespesaService {
    private final DespesaRepository despesaRepository;

    public DespesaService(DespesaRepository despesaRepository) {
        this.despesaRepository = despesaRepository;
    }

    public void adicionarDespesa(Despesa despesa) {
        despesaRepository.adicionar(despesa);
    }

    public List<Despesa> listarDespesas() {
        return despesaRepository.listar();
    }

    public void atualizarDespesa(Despesa despesa) {
        despesaRepository.atualizar(despesa);
    }

    public void deletarDespesa(int id) {
        despesaRepository.deletar(id);
    }
}
