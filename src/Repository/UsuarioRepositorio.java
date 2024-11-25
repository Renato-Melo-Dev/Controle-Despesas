package Repository;

import Entidades.Usuario;
import Interfaces.iUsuarioRepositorio;
import java.util.HashMap;
import java.util.Map;

public class UsuarioRepositorio implements iUsuarioRepositorio {
    private Map<String, Usuario> usuarios = new HashMap<>(); // Usando um Map para armazenar os usuários em memória (usando o email como chave)

    @Override
    public void criar(Usuario usuario) {
        usuarios.put(usuario.getEmail(), usuario);
    }

    @Override
    public boolean autenticar(String email, String senha) {
        Usuario usuario = usuarios.get(email);
        if (usuario != null) {
            return usuario.getSenha().equals(senha); // Verifica se a senha informada é igual à senha do usuário
        }
        return false;
    }

    @Override
    public Usuario buscarPorEmail(String email) {
        return usuarios.get(email); // Retorna o usuário associado ao email, ou null se não encontrado
    }

    public Map<String, Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Map<String, Usuario> usuarios) {
        this.usuarios = usuarios;
    }
}
