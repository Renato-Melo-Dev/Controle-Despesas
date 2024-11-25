package EstruturaDados;

public class Nodo<T extends Comparable<T>> {
    private T dado;
    private Nodo<T> esquerda;
    private Nodo<T> direita;

    public Nodo(T dado) {
        this.dado = dado;
        this.esquerda = null;
        this.direita = null;
    }

    public T getDado() {
        return dado;
    }

    public void setDado(T dado) {
        this.dado = dado;
    }

    public Nodo<T> getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(Nodo<T> esquerda) {
        this.esquerda = esquerda;
    }

    public Nodo<T> getDireita() {
        return direita;
    }

    public void setDireita(Nodo<T> direita) {
        this.direita = direita;
    }
}