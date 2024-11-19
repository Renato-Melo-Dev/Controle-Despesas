package Entidades;

public class Relatorio {
    private double totalDespesas;
    private double totalReceitas;
    private double saldoTotal;

    public Relatorio(double totalDespesas, double totalReceitas, double saldoTotal) {
        this.totalDespesas = totalDespesas;
        this.totalReceitas = totalReceitas;
        this.saldoTotal = saldoTotal;
    }

    public double getTotalDespesas() {
        return totalDespesas;
    }

    public void setTotalDespesas(double totalDespesas) {
        this.totalDespesas = totalDespesas;
    }

    public double getTotalReceitas() {
        return totalReceitas;
    }

    public void setTotalReceitas(double totalReceitas) {
        this.totalReceitas = totalReceitas;
    }

    public double getSaldoTotal() {
        return saldoTotal;
    }

    public void setSaldoTotal(double saldoTotal) {
        this.saldoTotal = saldoTotal;
    }

    
}
