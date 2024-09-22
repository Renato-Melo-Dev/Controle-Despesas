package Repository;

import Entidades.Usuario;
import Interfaces.UsuarioRepository;
import java.util.ArrayList;
import java.util.List;

public class UsuarioRepositorio implements UsuarioRepository {
    private List<Usuario> usuarios = new ArrayList<>();

    @Override
    public void criar(Usuario usuario) {
        usuarios.add(usuario);
    }

    @Override
    public boolean autenticar(String email, String senha) {
        return usuarios.stream()
                .anyMatch(u -> u.getEmail().equals(email) && u.getSenha().equals(senha));
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
}
