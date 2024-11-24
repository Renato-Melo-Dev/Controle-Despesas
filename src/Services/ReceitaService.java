package Services;

import Entidades.Receita;
import Interfaces.ReceitaRepository;

import java.util.List;

public class ReceitaService {
    private final ReceitaRepository receitaRepository;

    // Construtor
    public ReceitaService(ReceitaRepository receitaRepository) {
        this.receitaRepository = receitaRepository;
    }

    // Método para adicionar receita
    public void adicionarReceita(Receita receita) {
        receitaRepository.adicionar(receita);  // Chama o repositório para adicionar no banco
    }

    // Método para calcular o total de todas as receitas
    public double calcularTotalReceitas() {
        return receitaRepository.calcularTotal();  // Método no repositório que retorna a soma total das receitas
    }

    // Método para listar todas as receitas
    public List<Receita> listarReceitas() {
        return receitaRepository.listar();  // Método que retorna todas as receitas
    }

    // Método para deletar receita
    public void deletarReceita(int id) {
        receitaRepository.deletar(id);  // Chama o repositório para deletar a receita com o id
    }
}
