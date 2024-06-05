package aplicacao.agendamento;


import java.io.IOException;

import aplicacao.App;
import entidades.Agendamento;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;



public class agendamentoController {

    

    @FXML
    private Button atualizar;

    @FXML
    private Button cadastrar;

    @FXML
    private Button deletar;


    @FXML
    private Button voltar;

    @FXML
    private Label info;

    @FXML
    private Label responsavel;

    @FXML
    private TextField input_cpf;

    @FXML
    private TextField input_data;

    @FXML
    private TextField input_horario;

    @FXML
    private TextField input_servico;

    @FXML
    private TableView<Agendamento> mytable;

    @FXML
    private TableColumn<Agendamento, Integer> ID;

    @FXML
    private TableColumn<Agendamento, Long> Cpfresponsavel;

    @FXML
    private TableColumn<Agendamento, String> Data;

    @FXML
    private TableColumn<Agendamento, String> Endereco;

    @FXML
    private TableColumn<Agendamento, String> Especie;

    @FXML
    private TableColumn<Agendamento, String> Horario;

    @FXML
    private TableColumn<Agendamento, String> Nome;

    @FXML
    private TableColumn<Agendamento, String> Raca;

    @FXML
    private TableColumn<Agendamento, String> Servico;

    
    @FXML
    void limparCampos(ActionEvent event) {
        
        input_cpf.clear();
        input_data.clear();
        input_horario.clear();
        input_servico.clear();
    }

    @FXML
    void limparInfo() {
    info.setText("");
    }


    @FXML
    void botaovoltar() throws IOException{
        App.changeScene("inicio", 900, 538);
    }

    @FXML
    private void botaoatualizar(ActionEvent event) {
        enableFieldUpdates();
        limparInfo();

        
        String data = input_data.getText();
        String horario = input_horario.getText();
        String servico = input_servico.getText();
        long responsavelCpf =Long.parseLong(input_cpf.getText());
        // Lógica para deletar
        Agendamento agendamento = new Agendamento(0,null,data,horario,servico,null,null,null,responsavelCpf);
        agendamentoDAO.atualizarAgendamento(agendamento,info);


        initialize();
        limparCampos(event);
    }
    @FXML
    private void botaodeletar(ActionEvent event) {
        enableFieldUpdates();
        limparInfo();

        int id = getIdSelecionado();
        String data = input_data.getText();
        String horario = input_horario.getText();
        String servico = input_servico.getText();
        long responsavelCpf =Long.parseLong(input_cpf.getText());
        // Lógica para deletar
        Agendamento agendamento = new Agendamento(id,null,data,horario,servico,null,null,servico, responsavelCpf);
        agendamentoDAO.excluirAgendamento(agendamento,info);


        initialize();
        limparCampos(event);
    }

   



    public boolean chamarexibirAnimais() {
        long responsavelCpf = Long.parseLong(input_cpf.getText());
        return exibirAnimais(responsavelCpf);
    }
    

    @FXML
    private void botaofazeragendamento(ActionEvent event) {
    if (input_data.getText().isEmpty() || 
        input_horario.getText().isEmpty() || 
        input_servico.getText().isEmpty() || 
        input_cpf.getText().isEmpty()) {
        
        
        info.setText("Preencha todos os campos.");
        return; 
    }

    limparInfo();
    
    Agendamento itemSelecionado = mytable.getSelectionModel().getSelectedItem();
    
    if (itemSelecionado != null) {
        
        int id_animal = itemSelecionado.getId(); 
        String data = input_data.getText();
        String horario = input_horario.getText();
        String servico = input_servico.getText();
        long responsavelCpf = Long.parseLong(input_cpf.getText());

        Agendamento agendamento = new Agendamento(id_animal, null, data, horario, servico, null, null, null, responsavelCpf);
        agendamentoDAO.fazerAgendamento(agendamento);
        limparCampos(event);
        initialize();
        enableFieldUpdates();
        
    } else {
        
            chamarexibirAnimais();
            info.setText("Selecione um animal.");
        }
    
}



public boolean exibirAnimais(long cpf) {
    disableFieldUpdates();
    
    ObservableList<Agendamento> listaAnimais = agendamentoDAO.listarAnimaisPorCPF(cpf);

    
    ID.setCellValueFactory(new PropertyValueFactory<>("id"));
    Endereco.setCellValueFactory(new PropertyValueFactory<>(""));
    Data.setCellValueFactory(new PropertyValueFactory<>(""));
    Horario.setCellValueFactory(new PropertyValueFactory<>(""));
    Servico.setCellValueFactory(new PropertyValueFactory<>(""));
    Especie.setCellValueFactory(new PropertyValueFactory<>("especie"));
    Raca.setCellValueFactory(new PropertyValueFactory<>("raca"));
    Nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
    Cpfresponsavel.setCellValueFactory(new PropertyValueFactory<>("responsavel_cpf"));


    


    
    mytable.setItems(listaAnimais);

    
    final Agendamento[] itemSelecionado = {null};
    mytable.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
        if (newSelection != null) {
            
            itemSelecionado[0] = newSelection;
            
            input_cpf.setText(String.valueOf(itemSelecionado[0].getResponsavel_cpf()));
        }
    });

    
    return itemSelecionado[0] != null;
}
private int idSelecionado;

private boolean shouldUpdateFields = true;
public void exibirDados() {
    
    
    ObservableList<Agendamento> listartAgendamentos = agendamentoDAO.listarTodosAgendamentos();
    
    
    ID.setCellValueFactory(new PropertyValueFactory<>("id"));
    Endereco.setCellValueFactory(new PropertyValueFactory<>("endereco"));
    Data.setCellValueFactory(new PropertyValueFactory<>("data"));
    Horario.setCellValueFactory(new PropertyValueFactory<>("horario"));
    Servico.setCellValueFactory(new PropertyValueFactory<>("servico"));
    Especie.setCellValueFactory(new PropertyValueFactory<>("especie"));
    Raca.setCellValueFactory(new PropertyValueFactory<>("raca"));
    Nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
    Cpfresponsavel.setCellValueFactory(new PropertyValueFactory<>("responsavel_cpf"));
    
    
    mytable.setItems(listartAgendamentos);
    mytable.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
        if (newSelection != null && shouldUpdateFields) {
            
            Agendamento itemSelecionado = newSelection;
          
            idSelecionado=itemSelecionado.getId();
            input_data.setText(itemSelecionado.getData());
            input_horario.setText(itemSelecionado.getHorario());
            input_servico.setText(itemSelecionado.getServico());
            input_cpf.setText(String.valueOf(itemSelecionado.getResponsavel_cpf()));
            
            
            
            
        }
    });
}

public void disableFieldUpdates() {
    shouldUpdateFields = false;
}

public void enableFieldUpdates() {
    shouldUpdateFields = true;
}


@FXML
    public int getIdSelecionado() {
        return idSelecionado;
    }

@FXML
    public void initialize() {
        
        exibirDados();
    }
    


    


}
