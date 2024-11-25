package EstruturaDados;

public class ArvoreBinary<T extends Comparable<T>> {

    private Nodo<T> raiz;

    public ArvoreBinary() {
        raiz = null;
    }

    // Método de inserção na árvore binária
    public void inserir(T dado) {
        raiz = inserirRecursivo(raiz, dado);
    }

    private Nodo<T> inserirRecursivo(Nodo<T> nodo, T dado) {
        if (nodo == null) {
            return new Nodo<>(dado);
        }

        if (dado.compareTo(nodo.getDado()) < 0) {
            nodo.setEsquerda(inserirRecursivo(nodo.getEsquerda(), dado));
        } else if (dado.compareTo(nodo.getDado()) > 0) {
            nodo.setDireita(inserirRecursivo(nodo.getDireita(), dado));
        }

        return nodo;
    }

    // Método de deleção com retorno booleano
    public boolean deletar(T dado) {
        Nodo<T> novoRaiz = deletarRecursivo(raiz, dado);
        if (novoRaiz == null) {
            return false; // Não encontrou o dado para deletar
        }
        raiz = novoRaiz; // Atualiza a raiz, se necessário
        return true; // Deleção bem-sucedida
    }

    private Nodo<T> deletarRecursivo(Nodo<T> nodo, T dado) {
        if (nodo == null) {
            return null;  // Caso base: árvore vazia, nada para deletar
        }

        if (dado.compareTo(nodo.getDado()) < 0) {
            nodo.setEsquerda(deletarRecursivo(nodo.getEsquerda(), dado));
        } else if (dado.compareTo(nodo.getDado()) > 0) {
            nodo.setDireita(deletarRecursivo(nodo.getDireita(), dado));
        } else {
            // Caso encontrado (nó a ser deletado)
            
            // Caso 1: O nó não tem filhos (é uma folha)
            if (nodo.getEsquerda() == null && nodo.getDireita() == null) {
                return null;
            }
            
            // Caso 2: O nó tem apenas um filho
            if (nodo.getEsquerda() == null) {
                return nodo.getDireita();
            } else if (nodo.getDireita() == null) {
                return nodo.getEsquerda();
            }
            
            // Caso 3: O nó tem dois filhos
            // Encontrar o menor valor no subárvore direita (sucessor)
            T sucessorValor = encontrarMenorValor(nodo.getDireita());
            nodo.setDado(sucessorValor);  // Substitui o dado do nó
            nodo.setDireita(deletarRecursivo(nodo.getDireita(), sucessorValor));  // Deleta o sucessor
        }

        return nodo;
    }

    // Método auxiliar para encontrar o menor valor da subárvore direita
    private T encontrarMenorValor(Nodo<T> nodo) {
        return nodo.getEsquerda() == null ? nodo.getDado() : encontrarMenorValor(nodo.getEsquerda());
    }

    // Método de listagem em ordem (in-order)
    public void listarEmOrdem() {
        listarEmOrdemRecursivo(raiz);
    }

    private void listarEmOrdemRecursivo(Nodo<T> nodo) {
        if (nodo != null) {
            listarEmOrdemRecursivo(nodo.getEsquerda());
            System.out.println(nodo.getDado());
            listarEmOrdemRecursivo(nodo.getDireita());
        }
    }

    // Buscar um elemento na árvore
    public T buscar(T dado) {
        return buscarRecursivo(raiz, dado);
    }

    private T buscarRecursivo(Nodo<T> nodo, T dado) {
        if (nodo == null) {
            return null;  // Caso base: não encontrado
        }

        if (dado.compareTo(nodo.getDado()) < 0) {
            return buscarRecursivo(nodo.getEsquerda(), dado);
        } else if (dado.compareTo(nodo.getDado()) > 0) {
            return buscarRecursivo(nodo.getDireita(), dado);
        } else {
            return nodo.getDado();  // Encontrado
        }
    }

    public Nodo<T> getRaiz() {
        return raiz;
    }

    // Método in-order (semelhante ao listar, apenas um nome diferente)
    public void inOrder() {
        listarEmOrdem();
    }
}