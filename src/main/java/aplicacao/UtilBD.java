package aplicacao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UtilBD {
    private static Connection conexao;

    @SuppressWarnings("exports")
    public static Connection obterConexao() throws SQLException {
        if (conexao == null || conexao.isClosed()) {
            conexao = DriverManager.getConnection("jdbc:sqlite:banco2.sqlite");
        }
        return conexao;
    }

    public static void fecharConexao() {
        if (conexao != null) {
            try {
                conexao.close();
            } catch (SQLException e) {
                System.err.println("Erro ao fechar a conexão com o banco: " + e.getMessage());
            }
        }
    }

    public static void criarbanco() {
        try {
            Connection conexao = obterConexao();
            Statement stm = conexao.createStatement();
            

            stm.executeUpdate("CREATE TABLE IF NOT EXISTS responsaveis (" +
                    "responsavel_id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                    "nome TEXT NOT NULL," +
                    "telefone TEXT NOT NULL," +
                    "cpf TEXT NOT NULL," +
                    "endereco TEXT NOT NULL)");

            
            stm.executeUpdate("CREATE TABLE IF NOT EXISTS animais (" +
                    "animal_id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                    "nome TEXT NOT NULL," +
                    "especie TEXT NOT NULL," +
                    "raca TEXT," +
                    "idade INT," +
                    "responsavel_id INTEGER," +
                    "FOREIGN KEY (responsavel_id) REFERENCES responsaveis(responsavel_id))");




            stm.close();
        } catch (SQLException e) {
            System.err.println("Erro ao inicializar o banco de dados: " + e.getMessage());
        }
    }

    public static void executarQuery(String query) {
        try (Connection conexao = obterConexao();
             Statement stm = conexao.createStatement()) {
            stm.executeUpdate(query);
        } catch (SQLException e) {
            System.err.println("Erro ao executar a query: " + e.getMessage());
        }
    }
}
