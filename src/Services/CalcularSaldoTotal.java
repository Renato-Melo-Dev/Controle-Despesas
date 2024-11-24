package Services;

public class CalcularSaldoTotal {
    private final DespesaService despesaService;
    private final ReceitaService receitaService;

    // Construtor que recebe os serviços de despesa e receita
    public CalcularSaldoTotal(DespesaService despesaService, ReceitaService receitaService) {
        this.despesaService = despesaService;
        this.receitaService = receitaService;
    }

    // Método para calcular o saldo total (total de receitas - total de despesas)
    public double calcular() {
        try {
            double totalDespesas = despesaService.calcularTotalDespesas();  // Soma total de despesas
            double totalReceitas = receitaService.calcularTotalReceitas();  // Soma total de receitas

            // Retorna a diferença entre receitas e despesas
            return totalReceitas - totalDespesas;
        } catch (Exception e) {
            // Em caso de erro, podemos imprimir a stack trace ou lançar uma exceção personalizada
            System.out.println("Erro ao calcular o saldo total: " + e.getMessage());
            return 0.0;  // Retorna 0 em caso de erro (você pode ajustar isso conforme necessário)
        }
    }

    // Métodos de acesso (getters)
    public ReceitaService getReceitaService() {
        return receitaService;
    }

    public DespesaService getDespesaService() {
        return despesaService;
    }

    public double calcularSaldoTotal() {
        throw new UnsupportedOperationException("Unimplemented method 'calcularSaldoTotal'");
    }
}
