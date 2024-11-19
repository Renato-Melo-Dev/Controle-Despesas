package Services;

import Entidades.Usuario;
import Interfaces.UsuarioRepository;

public class UsuarioService {
    private UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public void criarUsuario(Usuario usuario) {
        usuarioRepository.criar(usuario);
    }

    public boolean autenticarUsuario(String email, String senha) {
        return usuarioRepository.autenticar(email, senha);
    }

    public UsuarioRepository getUsuarioRepository() {
        return usuarioRepository;
    }

    public void setUsuarioRepository(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario loginUsuario(String email, String senha) {
        throw new UnsupportedOperationException("Unimplemented method 'loginUsuario'");
    }

    public void cadastrarUsuario(Usuario usuario) {
        throw new UnsupportedOperationException("Unimplemented method 'cadastrarUsuario'");
    }
}
