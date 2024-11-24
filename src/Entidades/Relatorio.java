package Entidades;

public class Relatorio {
    private double totalDespesas;
    private double totalReceitas;
    private double saldoTotal;

    // Construtor
    public Relatorio(double totalDespesas, double totalReceitas) {
        this.totalDespesas = totalDespesas;
        this.totalReceitas = totalReceitas;
        this.saldoTotal = calcularSaldo();  // Calcula o saldo automaticamente
    }

    // Método para calcular o saldo total (totalReceitas - totalDespesas)
    private double calcularSaldo() {
        return totalReceitas - totalDespesas;
    }

    // Getters e Setters
    public double getTotalDespesas() {
        return totalDespesas;
    }

    public void setTotalDespesas(double totalDespesas) {
        this.totalDespesas = totalDespesas;
        this.saldoTotal = calcularSaldo();  // Recalcula o saldo sempre que as despesas mudarem
    }

    public double getTotalReceitas() {
        return totalReceitas;
    }

    public void setTotalReceitas(double totalReceitas) {
        this.totalReceitas = totalReceitas;
        this.saldoTotal = calcularSaldo();  // Recalcula o saldo sempre que as receitas mudarem
    }

    public double getSaldoTotal() {
        return saldoTotal;
    }

    // Método toString para facilitar a visualização dos dados
    @Override
    public String toString() {
        return "Relatorio{totalDespesas=" + totalDespesas + ", totalReceitas=" + totalReceitas + ", saldoTotal=" + saldoTotal + "}";
    }
}
