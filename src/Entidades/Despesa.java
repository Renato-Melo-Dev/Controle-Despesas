package Entidades;

import java.time.LocalDate;

public class Despesa {
    private int id;
    private String descricao;
    private double valor;
    private LocalDate data;
    private Categoria categoria;  // Mudando de 'idCategoria' para 'categoria' como objeto

    // Construtor com categoria como objeto
    public Despesa(int id, String descricao, double valor, LocalDate data, Categoria categoria) {
        this.id = id;
        this.descricao = descricao;
        this.valor = valor;
        this.data = data;
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

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Despesa{id=" + id + ", descricao='" + descricao + "', valor=" + valor + ", data=" + data + ", categoria=" + categoria + "}";
    }
}
