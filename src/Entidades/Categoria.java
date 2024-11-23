package Entidades;

public class Categoria {
    private int idCategoria;  // ID da categoria
    private String nome;      // Nome da categoria

    // Construtor
    public Categoria(int idCategoria, String nome) {
        this.idCategoria = idCategoria;
        this.nome = nome;
    }

    // Getters e Setters
    public int getId() {
        return idCategoria;  // Retorna o ID da categoria
    }

    public void setId(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
