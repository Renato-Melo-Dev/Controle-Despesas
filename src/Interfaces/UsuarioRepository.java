package Interfaces;

import Entidades.Usuario;

public interface UsuarioRepository {
    // Método para salvar o usuário
    void salvar(Usuario usuario);

    // Método para autenticar o usuário
    boolean autenticar(String email, String senha);

    // Método para verificar se um usuário existe por email
    boolean existePorEmail(String email);
}
