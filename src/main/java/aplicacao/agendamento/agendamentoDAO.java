package aplicacao.agendamento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import aplicacao.UtilBD;
import entidades.Agendamento;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;

public class agendamentoDAO {
    public static void excluirAgendamento(Agendamento agendamento, Label infoLabel) {
        String sql = "DELETE FROM agendamentos WHERE agendamento_id= ?";

        try {
            Connection conexao = UtilBD.obterConexao(); 
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setLong( 1, agendamento.getId());
            int linhasAfetadas = ps.executeUpdate();
            ps.close();
            UtilBD.fecharConexao();
            if (linhasAfetadas > 0) {
                
                

            } else {
                String texto = "Erro ao Excluir Agendamento ";
            infoLabel.setText(texto);
                
            }
        } catch (SQLException e) {
            String texto = "Erro ao fazer Agendamento ";
            infoLabel.setText(texto);
            
        }
    }

    public static void atualizarAgendamento(Agendamento agendamento,Label infoLabel) {
        String sql = "UPDATE agendamentos SET data = ?, horario = ?, servico = ? WHERE responsavel_cpf = ?";

        try {
            Connection conexao = UtilBD.obterConexao(); 
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString( 1, agendamento.getData());
            ps.setString( 2, agendamento.getHorario());
            ps.setString( 3, agendamento.getServico());
            ps.setLong( 4, agendamento.getResponsavel_cpf());

            int linhasAfetadas = ps.executeUpdate();
            ps.close();
            UtilBD.fecharConexao();
            if (linhasAfetadas > 0) {
                
                

            } else {
                String texto = "Erro ao Fazer Agendamento ";
            infoLabel.setText(texto);
                
            }
        } catch (SQLException e) {
            String texto = "Erro ao Atualizar Agendamento ";
            infoLabel.setText(texto);
            
        }
    }
    public static void fazerAgendamento(Agendamento agendamento) {
        String sql = "INSERT INTO agendamentos (animal_id, responsavel_cpf, data, horario, servico) VALUES (?, ?, ?, ?, ?)";

        try {
            Connection conexao = UtilBD.obterConexao(); 
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, agendamento.getId());
            ps.setLong(2, agendamento.getResponsavel_cpf());
            ps.setString(3, agendamento.getData());
            ps.setString(4, agendamento.getHorario());
            ps.setString(5, agendamento.getServico());
            
            ps.executeUpdate();
            ps.close();
            UtilBD.fecharConexao();
        } catch (SQLException e) {
            System.err.println("Erro ao fazer agendamento no banco de dados: " + e.getMessage());
            e.printStackTrace();
        }
    }
   

    

    public static ObservableList<Agendamento> listarAnimaisPorCPF(long cpfResponsavel) {
        ObservableList<Agendamento> listaAnimais = FXCollections.observableArrayList();
        String query = "SELECT * FROM animais WHERE responsavel_cpf = ?";
        
        try (Connection conexao = UtilBD.obterConexao();
             PreparedStatement preparedStatement = conexao.prepareStatement(query)) {
            
            preparedStatement.setLong(1, cpfResponsavel);
            ResultSet resultSet = preparedStatement.executeQuery();
    
            while (resultSet.next()) {
                Agendamento agendamento = new Agendamento(
                        resultSet.getInt("animal_id"),"","","","",
                        resultSet.getString("nome"),
                        resultSet.getString("especie"),
                        resultSet.getString("raca"),
                        resultSet.getLong("responsavel_cpf"));
                listaAnimais.add(agendamento);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            UtilBD.fecharConexao();
        }
        return listaAnimais;
    }
    public static ObservableList<Agendamento> listarTodosAgendamentos() {
        ObservableList<Agendamento> listaAgendamentos = FXCollections.observableArrayList();
        String query = "SELECT a.agendamento_id, a.data, a.horario, a.servico, r.nome AS nome_responsavel, r.telefone AS telefone_responsavel, " +
                       "r.cpf AS cpf_responsavel, r.endereco AS endereco_responsavel, an.nome AS nome_animal, an.especie AS especie_animal, an.raca AS raca_animal " +
                       "FROM agendamentos a " +
                       "INNER JOIN responsaveis r ON a.responsavel_cpf = r.cpf " +
                       "INNER JOIN animais an ON a.animal_id = an.animal_id";
        
        try (Connection conexao = UtilBD.obterConexao();
             Statement statement = conexao.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            
            while (resultSet.next()) {
                Agendamento agendamento = new Agendamento(
                        resultSet.getInt("agendamento_id"),
                        resultSet.getString("endereco_responsavel"),
                        resultSet.getString("data"),
                        resultSet.getString("horario"),
                        resultSet.getString("servico"),
                        resultSet.getString("nome_animal"),
                        resultSet.getString("especie_animal"),
                        resultSet.getString("raca_animal"),
                        resultSet.getLong("cpf_responsavel"));
                listaAgendamentos.add(agendamento);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        UtilBD.fecharConexao();
        return listaAgendamentos;
    }
    
    
}




















