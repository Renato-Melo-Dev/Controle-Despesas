package Entidades;

public class Despesa implements Comparable<Despesa> {
    private int id;
    private String descricao;
    private double valor;
    private Categoria categoria;

    public Despesa(int id, String descricao, double valor, Categoria categoria) {
        this.id = id;
        this.descricao = descricao;
        this.valor = valor;
        this.categoria = categoria;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    // Implementação do método compareTo para comparação de despesas com base no ID
    @Override
    public int compareTo(Despesa outraDespesa) {
        return Integer.compare(this.id, outraDespesa.getId());  // Ordenação pelo ID da despesa
    }

    @Override
    public String toString() {
        return String.format("Despesa{id=%d, descricao='%s', valor=%.2f, categoria=%s}",
                             id, descricao, valor, categoria.getNome());
    }
}
