package Interfaces;

import Entidades.Usuario;

public interface UsuarioRepository {
    void criar(Usuario usuario);
    boolean autenticar(String email, String senha);
}
