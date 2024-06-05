
package aplicacao.responsavel;

import java.io.IOException;

import aplicacao.App;
import entidades.Responsavel;


import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class respController {

    @FXML
    private TextField input_cpf;

    @FXML
    private TextField input_endereco;

    @FXML
    private TextField input_nome;

    @FXML
    private TextField input_telefone;

    @FXML
    private TextField input_pesquisa;

    @FXML
    private Label responsavel;

    @FXML
    private  Label info;


    @FXML
    private TableView<Responsavel> mytable;

    @FXML
    private TableColumn<Responsavel, String> CPF;

    @FXML
    private TableColumn<Responsavel, String> Endereco;

    @FXML
    private TableColumn<Responsavel, Integer> ID;

    @FXML
    private TableColumn<Responsavel, String> Nome;

    @FXML
    private TableColumn<Responsavel, String> Telefone;

    @FXML
    private Button atualizar;

    @FXML
    private Button deletar;

    @FXML
    private Button cadastrar;

    @FXML
    private Button mostrartodos;

    @FXML
    private Button voltar;

    

    

    



    @FXML
    void ChamarCadastrarResponsavel() {
    if (input_nome.getText().isEmpty() || 
        input_telefone.getText().isEmpty() || 
        input_cpf.getText().isEmpty() || 
        input_endereco.getText().isEmpty()) {
        
        
        info.setText("Preencha todos os campos.");
        return;
    }
    
    
    Responsavel responsavel = new Responsavel(0,input_nome.getText(), input_telefone.getText(), input_cpf.getText(), input_endereco.getText());
    ResponsavelDAO.cadastrarResponsavel(responsavel);
}


    @FXML
    void ChamarExcluirResponsavel(){
        Responsavel responsavel = new Responsavel(0,input_nome.getText(),input_telefone.getText(),input_cpf.getText(),input_endereco.getText());
        ResponsavelDAO.excluirResponsavel(responsavel,info);
    }

    @FXML
    void ChamarAtualizarResponsavel(){
        Responsavel responsavel = new Responsavel(getIdSelecionado(),input_nome.getText(),input_telefone.getText(),input_cpf.getText(),input_endereco.getText());
        ResponsavelDAO.atualizarResponsavel(responsavel,info);
    }

    
    @FXML
    void Chamartelainicial() throws IOException{
        App.changeScene("inicio", 900, 538); 

    }
    
    private int idSelecionado;

    public void exibirDados() {
        
        ObservableList<Responsavel> listaResponsaveis = ResponsavelDAO.listartodosresponsaveis();
        
        
        CPF.setCellValueFactory(new PropertyValueFactory<>("cpf"));
        Endereco.setCellValueFactory(new PropertyValueFactory<>("endereco"));
        ID.setCellValueFactory(new PropertyValueFactory<>("id"));
        Nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        Telefone.setCellValueFactory(new PropertyValueFactory<>("telefone"));
        
        
        mytable.setItems(listaResponsaveis);
        mytable.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                
                Responsavel itemSelecionado = newSelection;
                
                idSelecionado=itemSelecionado.getId();
                input_nome.setText(itemSelecionado.getNome());
                input_telefone.setText(itemSelecionado.getTelefone());
                input_cpf.setText(itemSelecionado.getCpf());
                input_endereco.setText(itemSelecionado.getEndereco());

                
                
                
            }
        });
    }

    public void exibirPesquisa() {
        
        ObservableList<Responsavel> listaResponsaveis = ResponsavelDAO.listarpesquisaresponsaveis(input_pesquisa.getText());
        
        
        CPF.setCellValueFactory(new PropertyValueFactory<>("cpf"));
        Endereco.setCellValueFactory(new PropertyValueFactory<>("endereco"));
        ID.setCellValueFactory(new PropertyValueFactory<>("id"));
        Nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        Telefone.setCellValueFactory(new PropertyValueFactory<>("telefone"));
        
        
        mytable.setItems(listaResponsaveis);
        mytable.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                
                Responsavel itemSelecionado = newSelection;
                
                idSelecionado=itemSelecionado.getId();
                input_nome.setText(itemSelecionado.getNome());
                input_telefone.setText(itemSelecionado.getTelefone());
                input_cpf.setText(itemSelecionado.getCpf());
                input_endereco.setText(itemSelecionado.getEndereco());

                
                
                
            }
        });
    }



    @FXML
    public int getIdSelecionado() {
        return idSelecionado;
    }


    @FXML
    void limparCampos(ActionEvent event) {
        
        input_pesquisa.clear();
        input_cpf.clear();
        input_endereco.clear();
        input_nome.clear();
        input_telefone.clear();
    }

    @FXML
    void limparInfo() {
    info.setText("");
    }



    
    // hover
    @FXML
    void onMouseEnteredAtualizar(MouseEvent event) {
        // Altera a cor de fundo do botão quando o mouse entra sobre ele
        atualizar.setStyle("-fx-background-radius:  45px; -fx-background-color: lightblue;");
    }

    @FXML
    void onMouseExitedAtualizar(MouseEvent event) {
        // Retorna a cor de fundo original do botão quando o mouse sai dele
        atualizar.setStyle(" -fx-background-radius:  45px; -fx-background-color:  #00009C; ");
    }

    @FXML
    void onMouseEnteredDeletar(MouseEvent event) {
        // Altera a cor de fundo do botão quando o mouse entra sobre ele
        
        deletar.setStyle("-fx-background-radius:  45px; -fx-background-color: lightblue;");
    }

    @FXML
    void onMouseExitedDeletar(MouseEvent event) {
        // Retorna a cor de fundo original do botão quando o mouse sai dele
        
        deletar.setStyle(" -fx-background-radius:  45px; -fx-background-color:  #00009C; ");
    }

    
    @FXML
    void onMouseEnteredCadastrar(MouseEvent event) {
        // Altera a cor de fundo do botão quando o mouse entra sobre ele
        
        cadastrar.setStyle("-fx-background-radius:  45px; -fx-background-color: lightblue;");
    }

    @FXML
    void onMouseExitedCadrastar(MouseEvent event) {
        // Retorna a cor de fundo original do botão quando o mouse sai dele
        
        cadastrar.setStyle(" -fx-background-radius:  45px; -fx-background-color:  #00009C; ");
    }

    @FXML
    void onMouseEnteredmostrartodos(MouseEvent event) {
        // Altera a cor de fundo do botão quando o mouse entra sobre ele
        
        mostrartodos.setStyle("-fx-background-radius:  0px; -fx-background-color: lightblue;");
    }

    @FXML
    void onMouseExitedmostrartodos(MouseEvent event) {
        // Retorna a cor de fundo original do botão quando o mouse sai dele
        
        mostrartodos.setStyle(" -fx-background-radius:  0px; -fx-background-color:  #00009C; ");
    }

    @FXML
    void onMouseEnteredvoltar(MouseEvent event) {
        // Altera a cor de fundo do botão quando o mouse entra sobre ele
        
        voltar.setStyle("-fx-background-radius:  0px; -fx-background-color: lightblue;");
    }

    @FXML
    void onMouseExitedvoltar(MouseEvent event) {
        // Retorna a cor de fundo original do botão quando o mouse sai dele
        
        voltar.setStyle(" -fx-background-radius:  0px; -fx-background-color:  #00009C; ");
    }



    @FXML
    void botaocadastrar(ActionEvent event){
        limparInfo();
        ChamarCadastrarResponsavel();
        initialize();
        limparCampos(event);
    }

    @FXML
    void botaodeletar(ActionEvent event){
        limparInfo();
        ChamarExcluirResponsavel();
        initialize();
        limparCampos(event);
    }
    @FXML
    void botaoatualizar(ActionEvent event){
        limparInfo();
        ChamarAtualizarResponsavel();
        initialize();
        limparCampos(event);
    }

    @FXML
    void botaopesquisar(ActionEvent event){
        limparInfo();
        
        exibirPesquisa();
        limparCampos(event);
    }

    @FXML
    void botaomostrartodos(ActionEvent event){
        limparInfo();
        initialize();
        limparCampos(event);
    }
    





    @FXML
    public void initialize() {
        
        exibirDados();
    }











}

