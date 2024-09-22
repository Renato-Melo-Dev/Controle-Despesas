package Services;

import Entidades.Despesa;
import Interfaces.DespesaRepository;
import java.util.List;

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
    public double obterTotalDespesas(List<Despesa> listaDespesas) {
        double total = 0.0;
        for (Despesa despesa : listaDespesas) {
            total += despesa.getValor();
        }
        return total;
    
}
}