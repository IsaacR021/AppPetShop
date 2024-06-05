package aplicacao.responsavel;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import aplicacao.UtilBD;
import entidades.Responsavel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
public class ResponsavelDAO {
   
    public static void cadastrarResponsavel(Responsavel responsavel) {
        String sql = "INSERT INTO responsaveis (nome, telefone, cpf, endereco) VALUES (?, ?, ?, ?)";

        try {
            Connection conexao = UtilBD.obterConexao(); 
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, responsavel.getNome());
            ps.setString(2, responsavel.getTelefone());
            ps.setString(3, responsavel.getCpf());
            ps.setString(4, responsavel.getEndereco());
            ps.executeUpdate();
            ps.close();
            UtilBD.fecharConexao();
            System.err.println("deu certo: " );
        } catch (SQLException e) {
            System.err.println("Erro ao inserir responsável no banco de dados: " + e.getMessage());
            e.printStackTrace();
        }
    }
    public static void excluirResponsavel(Responsavel responsavel, Label infoLabel) {
        String sql = "DELETE FROM responsaveis WHERE cpf = ?";

        try {
            Connection conexao = UtilBD.obterConexao(); 
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString( 1, responsavel.getCpf());
            int linhasAfetadas = ps.executeUpdate();
            ps.close();
            UtilBD.fecharConexao();
            if (linhasAfetadas > 0) {
                
                

            } else {
                String texto = "Erro ao Excluir Responsável ";
            infoLabel.setText(texto);
                
            }
        } catch (SQLException e) {
            String texto = "Erro ao cadastrar Responsável ";
            infoLabel.setText(texto);
            
        }
    }





    public static void atualizarResponsavel(Responsavel responsavel,Label infoLabel) {
        String sql = "UPDATE responsaveis SET nome = ?, telefone = ?, cpf = ?, endereco = ? WHERE responsavel_id = ?";

        try {
            Connection conexao = UtilBD.obterConexao(); 
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString( 1, responsavel.getNome());
            ps.setString( 2, responsavel.getTelefone());
            ps.setString( 3, responsavel.getCpf());
            ps.setString( 4, responsavel.getEndereco());
            ps.setInt( 5, responsavel.getId());

            int linhasAfetadas = ps.executeUpdate();
            ps.close();
            UtilBD.fecharConexao();
            if (linhasAfetadas > 0) {
                
                

            } else {
                String texto = "Erro ao Atualizar Responsável ";
            infoLabel.setText(texto);
                
            }
        } catch (SQLException e) {
            String texto = "Erro ao Atualizar Responsável ";
            infoLabel.setText(texto);
            
        }
    }
    




public static ObservableList<Responsavel> listartodosresponsaveis() {
    ObservableList<Responsavel> listaResponsaveis = FXCollections.observableArrayList();
    String query = "SELECT * FROM responsaveis";
    
    try (Connection conexao = UtilBD.obterConexao();
         Statement statement = conexao.createStatement();
         ResultSet resultSet = statement.executeQuery(query)) {
        
        while (resultSet.next()) {
            Responsavel banco_responsavel =new Responsavel(
                    resultSet.getInt("responsavel_id"),
                    resultSet.getString("nome"),
                    resultSet.getString("telefone"),
                    resultSet.getString("cpf"),
                    resultSet.getString("endereco"));
            listaResponsaveis.add(banco_responsavel);
        }
    } catch (SQLException e) {
        
        e.printStackTrace();
    }
    UtilBD.fecharConexao();
    return listaResponsaveis;
}


public static ObservableList<Responsavel> listarpesquisaresponsaveis(String input_pesquisa) {
    ObservableList<Responsavel> listaResponsaveis = FXCollections.observableArrayList();
    String query = "SELECT * FROM responsaveis WHERE responsavel_id = ? OR cpf = ?";
    
    try (Connection conexao = UtilBD.obterConexao();
         PreparedStatement statement = conexao.prepareStatement(query)) { 
       
        statement.setString(1, input_pesquisa); 
        statement.setString(2, input_pesquisa); 
        
        try (ResultSet resultSet = statement.executeQuery()) { 
            while (resultSet.next()) {
                Responsavel banco_responsavel = new Responsavel(
                        resultSet.getInt("responsavel_id"),
                        resultSet.getString("nome"),
                        resultSet.getString("telefone"),
                        resultSet.getString("cpf"),
                        resultSet.getString("endereco"));
                listaResponsaveis.add(banco_responsavel);
            }
        }
    } catch (SQLException e) {
        
        e.printStackTrace();
    }
    
    return listaResponsaveis;
}




















}
