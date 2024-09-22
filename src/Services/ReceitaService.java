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
        receitaRepository.salvarReceita(receita);
    }

    public Receita buscarReceitaPorId(int id) {
        return receitaRepository.buscarReceitaPorId(id);
    }


    public ReceitaRepository getReceitaRepository() {
        return receitaRepository;
    }

    public void setReceitaRepository(ReceitaRepository receitaRepository) {
        this.receitaRepository = receitaRepository;
    }
    
    public double obterTotalReceitas(List<Receita> listaReceitas) {
        double total = 0.0;
        for (Receita receita : listaReceitas) {
            total += receita.getValor();
        }
        return total;
  
}
}