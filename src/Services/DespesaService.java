package Services;

import Entidades.Despesa;
import Interfaces.iDespesaRepositorio;
import java.util.List;

public class DespesaService {
    private iDespesaRepositorio despesaRepository;
    private CategoriaService categoriaService;
    private int contadorDespesa = 1;

    public DespesaService(iDespesaRepositorio despesaRepository, CategoriaService categoriaService) {
        this.despesaRepository = despesaRepository;
        this.categoriaService = categoriaService;
    }

    // Método para adicionar uma despesa
    public void adicionarDespesa(Despesa despesa) {
        despesaRepository.adicionar(despesa); // Inserir despesa na árvore binária
    }

    // Método para listar todas as despesas
    public List<Despesa> listarDespesas() {
        return despesaRepository.listar(); // Listar despesas da árvore binária
    }

    // Método para remover uma despesa por ID
    public boolean removerDespesa(int id) {
        Despesa despesa = despesaRepository.buscar(id);  // Buscar a despesa com o id fornecido
        if (despesa != null) {
            despesaRepository.deletar(despesa); // Remover despesa da árvore binária
            return true;
        }
        return false;
    }

    // Método para gerar um ID incremental para as despesas
    public int gerarIdDespesa() {
        return contadorDespesa++;  // Gerar ID incremental
    }

    // Método para calcular o saldo total (considerando apenas as despesas)
    public double calcularSaldo() {
        double saldo = 0;
        List<Despesa> despesas = despesaRepository.listar();  // Obter todas as despesas
        for (Despesa despesa : despesas) {
            saldo -= despesa.getValor(); // Subtrair as despesas para calcular o saldo
        }
        return saldo;
    }

    // Método para calcular o total de todas as despesas
    public double calcularTotalDespesas() {
        double total = 0;
        List<Despesa> despesas = despesaRepository.listar();  // Obter todas as despesas
        for (Despesa despesa : despesas) {
            total += despesa.getValor();  // Somar os valores das despesas
        }
        return total;
    }

    // Getters e Setters para o repositório de despesas e o serviço de categoria
    public iDespesaRepositorio getDespesaRepository() {
        return despesaRepository;
    }

    public void setDespesaRepository(iDespesaRepositorio despesaRepository) {
        this.despesaRepository = despesaRepository;
    }

    public CategoriaService getCategoriaService() {
        return categoriaService;
    }

    public void setCategoriaService(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }
}
