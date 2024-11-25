package Services;

import Entidades.Usuario;
import Interfaces.iUsuarioRepositorio;

public class UsuarioService {
    // Mudando para o tipo correto da interface
    private iUsuarioRepositorio usuarioRepository;

    // Construtor que recebe o repositório de usuário
    public UsuarioService(iUsuarioRepositorio usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    // Método para criar um novo usuário
    public void criarUsuario(Usuario usuario) {
        usuarioRepository.criar(usuario);
    }

    // Método para autenticar o usuário
    public boolean autenticarUsuario(String email, String senha) {
        return usuarioRepository.autenticar(email, senha);
    }

    // Método para buscar um usuário por email
    public Usuario buscarUsuarioPorEmail(String email) {
        return usuarioRepository.buscarPorEmail(email);
    }

    // Getter e Setter para o repositório de usuário
    public iUsuarioRepositorio getUsuarioRepository() {
        return usuarioRepository;
    }

    public void setUsuarioRepository(iUsuarioRepositorio usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }
}
