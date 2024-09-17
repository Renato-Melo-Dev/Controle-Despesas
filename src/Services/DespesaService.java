package Services;

import Entidades.Despesa;
import Interfaces.DespesaRepository;

public class DespesaService {
    public DespesaRepository despesaRepository;

    public DespesaService(DespesaRepository despesaRepository) {
        this.despesaRepository = despesaRepository;
    }

    
    public void salvarDespesa(Despesa despesa) {
        despesaRepository.salvar(despesa);
    }

   
    public Despesa buscarDespesaPorId(int id) {
        return despesaRepository.buscarPorId(id);
    }
    public String gerarRelatorioMensal() {
        return "Relatório mensal em construção...";
    }

    public void adicionarDespesa(Despesa despesa) {
        despesaRepository.adicionarDespesa(despesa);
    }

    
}