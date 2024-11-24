package Services;

import Entidades.Usuario;
import Interfaces.UsuarioRepository;

public class UsuarioService {
    private UsuarioRepository usuarioRepository;

    // Construtor que recebe o UsuarioRepository
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    // Método para criar um novo usuário
    public void criarUsuario(Usuario usuario) {
        usuarioRepository.salvar(usuario);
    }

    // Método para autenticar um usuário
    public boolean autenticarUsuario(String email, String senha) {
        return usuarioRepository.autenticar(email, senha);
    }

    // Método para verificar se já existe um usuário com o email fornecido
    public boolean existeUsuarioPorEmail(String email) {
        return usuarioRepository.existePorEmail(email);
    }

    public UsuarioRepository getUsuarioRepository() {
        return usuarioRepository;
    }

    public void setUsuarioRepository(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }
}
