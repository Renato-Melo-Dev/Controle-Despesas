package Services;

import Entidades.Receita;
import Interfaces.ReceitaRepository;
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

    public double calcularTotalReceitas() {
        return receitaRepository.calcularTotalReceitas();
               
    }

    public ReceitaRepository getReceitaRepository() {
        return receitaRepository;
    }

    public void setReceitaRepository(ReceitaRepository receitaRepository) {
        this.receitaRepository = receitaRepository;
    }

  
}
