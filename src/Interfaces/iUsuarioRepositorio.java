package Interfaces;

import Entidades.Usuario;

public interface iUsuarioRepositorio {
    void criar(Usuario usuario);
    boolean autenticar(String email, String senha);
    Usuario buscarPorEmail(String email);
}
