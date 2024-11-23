package Entidades;

public class Receita {
    private int id;
    private String descricao;
    private double valor;
    private Categoria categoria;  // Atributo que representa a categoria da receita

    // Construtor
    public Receita(int id, String descricao, double valor, Categoria categoria) {
        this.id = id;
        this.descricao = descricao;
        this.valor = valor;
        this.categoria = categoria;  // Inicializando a categoria
    }

    // Getters e setters
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

    // Getter para a categoria (agora retorna um objeto Categoria)
    public Categoria getCategoria() {
        return categoria;
    }

    // Setter para a categoria (agora aceita um objeto Categoria)
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
