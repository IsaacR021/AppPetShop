package aplicacao.animal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import aplicacao.UtilBD;
import entidades.Animal;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;

public class AnimalDAO {
   
    public static void cadastrarAnimal(Animal animal,Label infoLabel) {
        String sqlInsert = "INSERT INTO animais (nome, especie, raca, responsavel_cpf) VALUES (?, ?, ?, ?)";
        String sqlCheckResponsavel = "SELECT 1 FROM responsaveis WHERE cpf = ?";
    
        try {
            Connection conexao = UtilBD.obterConexao(); 
            
            
            PreparedStatement psCheck = conexao.prepareStatement(sqlCheckResponsavel);
            psCheck.setLong(1, animal.getResponsavel_cpf());
            ResultSet rs = psCheck.executeQuery();
    
            if (rs.next()) {
                
                PreparedStatement psInsert = conexao.prepareStatement(sqlInsert);
                psInsert.setString(1, animal.getNome());
                psInsert.setString(2, animal.getEspecie());
                psInsert.setString(3, animal.getRaca());
                psInsert.setLong(4, animal.getResponsavel_cpf());
                psInsert.executeUpdate();
                psInsert.close();
            } else {
                
                String texto = "CPF não Encontrado";
                infoLabel.setText(texto);
            }
    
            rs.close();
            psCheck.close();
            UtilBD.fecharConexao();
        } catch (SQLException e) {
            System.err.println("Erro ao inserir Animal no banco de dados: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    public static void excluirAnimal(Animal animal, Label infoLabel) {
        String sql = "DELETE FROM animais WHERE animal_id= ?";

        try {
            Connection conexao = UtilBD.obterConexao(); 
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setLong( 1, animal.getId());
            int linhasAfetadas = ps.executeUpdate();
            ps.close();
            UtilBD.fecharConexao();
            if (linhasAfetadas > 0) {
                
                

            } else {
                String texto = "Erro ao Excluir Animal ";
            infoLabel.setText(texto);
                
            }
        } catch (SQLException e) {
            String texto = "Erro ao cadastrar Animal ";
            infoLabel.setText(texto);
            
        }
    }

    public static void atualizarAnimal(Animal animal,Label infoLabel) {
        String sql = "UPDATE animais SET nome = ?, especie = ?, raca = ?, responsavel_cpf = ? WHERE animal_id = ?";

        try {
            Connection conexao = UtilBD.obterConexao(); 
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString( 1, animal.getNome());
            ps.setString( 2, animal.getEspecie());
            ps.setString( 3, animal.getRaca());
            ps.setLong( 4, animal.getResponsavel_cpf());
            ps.setInt( 5, animal.getId());

            int linhasAfetadas = ps.executeUpdate();
            ps.close();
            UtilBD.fecharConexao();
            if (linhasAfetadas > 0) {
                
                

            } else {
                String texto = "Erro ao Atualizar Animal ";
            infoLabel.setText(texto);
                
            }
        } catch (SQLException e) {
            String texto = "Erro ao Atualizar Animal ";
            infoLabel.setText(texto);
            
        }
    }

    public static ObservableList<Animal> listartodosaAnimals() {
    ObservableList<Animal> listaAnimais = FXCollections.observableArrayList();
    String query = "SELECT * FROM animais";
    
    try (Connection conexao = UtilBD.obterConexao();
         Statement statement = conexao.createStatement();
         ResultSet resultSet = statement.executeQuery(query)) {
        
        while (resultSet.next()) {
            Animal animal =new Animal(
                    resultSet.getInt("animal_id"),
                    resultSet.getString("nome"),
                    resultSet.getString("especie"),
                    resultSet.getString("raca"),
                    resultSet.getLong("responsavel_cpf"));
            listaAnimais.add(animal);
        }
    } catch (SQLException e) {
        
        e.printStackTrace();
    }
    UtilBD.fecharConexao();
    return listaAnimais;
}



















}
