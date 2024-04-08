package aplicacao.animal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import aplicacao.UtilBD;
import entidades.Animal;

public class AnimalDAO {
   
    public static void cadastroAnimal(Animal animal) {
        String sql = "INSERT INTO animais (nome, especie, raca, idade) VALUES (?, ?, ?, ?)";

        try {
            Connection conexao = UtilBD.obterConexao(); 
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, animal.getNome());
            ps.setString(2, animal.getEspecie());
            ps.setString(3, animal.getRaca());
            ps.setInt(4, animal.getIdade());
            System.out.println(animal.getIdade());
            ps.executeUpdate();
            ps.close();
            UtilBD.fecharConexao();
        } catch (SQLException e) {
            System.err.println("Erro ao inserir responsável no banco de dados: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
