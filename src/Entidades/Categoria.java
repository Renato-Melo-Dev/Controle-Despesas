package Entidades;

public class Categoria {
    private int id;
    private String nome;
    private String tipo;  // Tipo: essencial, não essencial, etc.

    public Categoria(int id, String nome, String tipo) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
    }

    // Getters e setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    // Sobrescrevendo o método toString() para uma exibição melhorada
    @Override
    public String toString() {
        return String.format("Categoria{id=%d, nome='%s', tipo='%s'}", id, nome, tipo != null ? tipo : "Não definido");
    }
}
