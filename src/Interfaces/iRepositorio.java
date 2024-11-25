package Interfaces;

import java.util.List;

public interface iRepositorio<T> {
    void adicionar(T t);
    T buscar(int id);
    boolean deletar(T t);  // Este método recebe um objeto do tipo T
    List<T> listar();  // Método listar que retorna uma lista
}