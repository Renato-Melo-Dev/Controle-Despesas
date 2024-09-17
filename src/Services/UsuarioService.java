package Services;

import Entidades.Usuario;
import Interfaces.UsuarioRepository;
public class UsuarioService {
    public UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public void criarUsuario(Usuario usuario) {
        usuarioRepository.salvarUsuario(usuario);
    }

    public Usuario buscarUsuarioPorId(int id) {
        return usuarioRepository.buscarUsuarioPorId(id);
    }

    public boolean autenticarUsuario(String email, String senha) {
        
        Usuario usuario = usuarioRepository.buscarUsuarioPorEmail(email);
        return usuario != null && usuario.getSenha().equals(senha);
    }

}
