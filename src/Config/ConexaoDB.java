package Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDB {

    private static final String URL = "jdbc:mysql://localhost:3306/controle_despesas";  // URL do banco de dados
    private static final String USER = "root"; // Seu usuário do MySQL
    private static final String PASSWORD = "kaka0822"; // Sua senha do MySQL

    public static Connection conectar() {
        try {
            // Registrar o driver MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Estabelecendo a conexão com o banco de dados
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexão estabelecida com sucesso!");
            return conn;
        } catch (SQLException | ClassNotFoundException e) {
            System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
            return null;
        }
    }

    public static void fecharConexao(Connection conn) {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
                System.out.println("Conexão fechada com sucesso!");
            }
        } catch (SQLException e) {
            System.err.println("Erro ao fechar a conexão: " + e.getMessage());
        }
    }
}
