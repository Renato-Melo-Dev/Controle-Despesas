package Services;

import Entidades.Despesa;
import Entidades.Receita;
import java.util.List;

public class RelatorioService {
    public void gerarRelatorio(List<Despesa> despesas, List<Receita> receitas) {
        System.out.println("\n--- Relatório de Gastos e Receitas ---");
        
        double totalDespesas = 0;
        double totalReceitas = 0;

        System.out.println("Despesas:");
        for (Despesa despesa : despesas) {
            System.out.printf("ID: %d, Descrição: %s, Valor: R$%.2f%n", despesa.getId(), despesa.getDescricao(), despesa.getValor());
            totalDespesas += despesa.getValor();
        }

        System.out.println("\nReceitas:");
        for (Receita receita : receitas) {
            System.out.printf("ID: %d, Descrição: %s, Valor: R$%.2f%n", receita.getId(), receita.getDescricao(), receita.getValor());
            totalReceitas += receita.getValor();
        }

        System.out.printf("\nTotal de Despesas: R$%.2f%n", totalDespesas);
        System.out.printf("Total de Receitas: R$%.2f%n", totalReceitas);
        System.out.printf("Saldo Total: R$%.2f%n", totalReceitas - totalDespesas);
    }
}
