package Repository;

import Entidades.Usuario;
import Interfaces.UsuarioRepository;
import java.util.ArrayList;
import java.util.List;

public class UsuarioRepositorio implements UsuarioRepository {
    private final  List<Usuario> usuarios = new ArrayList<>();

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> novosUsuarios) {
        this.usuarios.clear();
        this.usuarios.addAll(novosUsuarios);
    }
    @Override
    public void salvarUsuario(Usuario usuario) {
        if (!usuarios.contains(usuario)) {
            usuarios.add(usuario);
        }
    }

    @Override
    public Usuario buscarUsuarioPorId(long id) {
        for (Usuario u : usuarios) {
            if (u.getId() == id) {
                return u;
            }
        }
        return null;
    }
    @Override
    public Usuario buscarUsuarioPorEmail(String email) {
        for (Usuario u : usuarios) {
            if (u.getEmail().equals(email)) {
                return u;
            }
        }
        return null;
    }
  
}

