package Interfaces;

import Entidades.Usuario;

public interface UsuarioRepository {
    void salvarUsuario(Usuario usuario);
    Usuario buscarUsuarioPorId(long id);
    Usuario buscarUsuarioPorEmail(String email);
}
