package Utils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    public static Connection obterConexao() throws SQLException {
        // URL de conexão com o banco de dados
        String url = "jdbc:mysql://localhost:3306/controle_despesas?useSSL=false&serverTimezone=UTC";
        String usuario = "root";  // Usuário do banco de dados
        String senha = "kaka0822";  // Senha do banco de dados

        // Estabelecendo a conexão
        try {
            // Carrega o driver JDBC do MySQL (apenas necessário se não estiver sendo carregado automaticamente)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Retorna a conexão
            return DriverManager.getConnection(url, usuario, senha);
        } catch (ClassNotFoundException e) {
            System.out.println("Driver JDBC não encontrado.");
            throw new SQLException("Não foi possível carregar o driver JDBC.", e);
        } catch (SQLException e) {
            System.out.println("Erro ao conectar com o banco de dados.");
            throw e;
        }
    }
}
