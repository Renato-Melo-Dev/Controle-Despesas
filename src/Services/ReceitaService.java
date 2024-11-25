package Services;

import Entidades.Receita;
import Interfaces.iReceitaRepositorio;
import java.util.List;

public class ReceitaService {
    private iReceitaRepositorio receitaRepository;
    private int contadorReceita = 1;

    public ReceitaService(iReceitaRepositorio receitaRepository) {
        this.receitaRepository = receitaRepository;
    }

    // Adiciona uma receita
    public void adicionarReceita(Receita receita) {
        receitaRepository.adicionar(receita);  // Inserir receita na árvore binária
    }

    // Lista todas as receitas
    public List<Receita> listarReceitas() {
        return receitaRepository.listar();  // Listar receitas da árvore binária
    }

    // Remove uma receita
    public boolean removerReceita(int id) {
        return receitaRepository.remover(id);  // Remove receita pelo ID
    }

    // Gerar ID único para as receitas
    public int gerarIdReceita() {
        return contadorReceita++;  // Gerar ID único e incrementar
    }

    // Calcular o total de receitas
    public double calcularTotalReceitas() {
        double total = 0;
        List<Receita> receitas = receitaRepository.listar();
        for (Receita receita : receitas) {
            total += receita.getValor();  // Soma o valor de cada receita
        }
        return total;
    }

    // Calcular o saldo (considerando receitas e despesas)
    public double calcularSaldo(DespesaService despesaService) {
        // Total de receitas
        double totalReceitas = calcularTotalReceitas();
        // Total de despesas (provém do serviço de despesas)
        double totalDespesas = despesaService.calcularTotalDespesas();
        
        // Saldo final (receitas - despesas)
        return totalReceitas - totalDespesas;
    }

    // Getters e Setters
    public iReceitaRepositorio getReceitaRepository() {
        return receitaRepository;
    }

    public void setReceitaRepository(iReceitaRepositorio receitaRepository) {
        this.receitaRepository = receitaRepository;
    }
}
