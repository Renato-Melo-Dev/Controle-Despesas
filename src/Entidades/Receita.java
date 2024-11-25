package Entidades;

public class Receita implements Comparable<Receita> {
    private int id;
    private String descricao;
    private double valor;

    // Construtores
    public Receita(int id, String descricao, double valor) {
        this.id = id;
        this.descricao = descricao;
        this.valor = valor;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    // Implementação do compareTo para ordenar pela id
    @Override
    public int compareTo(Receita outraReceita) {
        // Comparar receitas com base no ID
        return Integer.compare(this.id, outraReceita.getId());
    }
}
