package Services;

import java.util.List;

import Entidades.Despesa;
import Interfaces.DespesaRepository;

public class DespesaService {
    private final DespesaRepository despesaRepository;

    // Construtor
    public DespesaService(DespesaRepository despesaRepository) {
        this.despesaRepository = despesaRepository;
    }

    // Método que retorna a soma total de todas as despesas no banco de dados
    public double calcularTotalDespesas() {
        return despesaRepository.calcularTotal();  // Método no repositório que retorna a soma total das despesas
    }

    // Adicionar uma nova despesa
    public void adicionarDespesa(Despesa despesa) {
        despesaRepository.adicionar(despesa);
    }

    // Atualizar uma despesa existente
    public void atualizarDespesa(Despesa despesa) {
        despesaRepository.atualizar(despesa);
    }

    // Deletar uma despesa pelo ID
    public boolean deletarDespesa(int id) {
        // Verifica se a operação de deleção foi bem-sucedida e retorna o resultado
        return despesaRepository.deletar(id);
    }

    // Listar todas as despesas
    public List<Despesa> listarDespesas() {
        return despesaRepository.listar();  // Recupera todas as despesas
    }
}
