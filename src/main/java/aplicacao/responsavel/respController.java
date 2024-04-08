
package aplicacao.responsavel;

import java.io.IOException;

import aplicacao.App;
import entidades.Responsavel;

//import java.sql.SQLException;
import entidades.Bancoresponsavel;
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
    private TableView<Bancoresponsavel> mytable;

    @FXML
    private TableColumn<Bancoresponsavel, String> CPF;

    @FXML
    private TableColumn<Bancoresponsavel, String> Endereco;

    @FXML
    private TableColumn<Bancoresponsavel, Integer> ID;

    @FXML
    private TableColumn<Bancoresponsavel, String> Nome;

    @FXML
    private TableColumn<Bancoresponsavel, String> Telefone;

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
    void ChamarCadastrarResponsavel(){
        Responsavel responsavel = new Responsavel(input_nome.getText(),input_telefone.getText(),input_cpf.getText(),input_endereco.getText());
        ResponsavelDAO.cadastrarResponsavel(responsavel);
    }

    @FXML
    void ChamarExcluirResponsavel(){
        Responsavel responsavel = new Responsavel(input_nome.getText(),input_telefone.getText(),input_cpf.getText(),input_endereco.getText());
        ResponsavelDAO.excluirResponsavel(responsavel,info);
    }

    @FXML
    void ChamarAtualizarResponsavel(){
        Bancoresponsavel responsavel = new Bancoresponsavel(getIdSelecionado(),input_nome.getText(),input_telefone.getText(),input_cpf.getText(),input_endereco.getText());
        ResponsavelDAO.atualizarResponsavel(responsavel,info);
    }

    
    @FXML
    void Chamartelainicial() throws IOException{
        App.setRoot("inicio"); 

    }
    
    private int idSelecionado;

    public void exibirDados() {
        // Obtém a lista de responsáveis do banco de dados
        ObservableList<Bancoresponsavel> listaResponsaveis = ResponsavelDAO.listartodosresponsaveis();
        
        // Define as células de cada coluna para exibir os dados corretos
        CPF.setCellValueFactory(new PropertyValueFactory<>("cpf"));
        Endereco.setCellValueFactory(new PropertyValueFactory<>("endereco"));
        ID.setCellValueFactory(new PropertyValueFactory<>("id"));
        Nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        Telefone.setCellValueFactory(new PropertyValueFactory<>("telefone"));
        
        // Define os itens da TableView
        mytable.setItems(listaResponsaveis);
        mytable.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                // Quando uma linha é selecionada, você pode acessar os itens da linha e fazer o que precisar com eles
                Bancoresponsavel itemSelecionado = newSelection;
                // Por exemplo, se deseja exibir o CPF na caixa de texto input_cpf
                idSelecionado=itemSelecionado.getId();
                input_nome.setText(itemSelecionado.getNome());
                input_telefone.setText(itemSelecionado.getTelefone());
                input_cpf.setText(itemSelecionado.getCpf());
                input_endereco.setText(itemSelecionado.getEndereco());

                
                
                
            }
        });
    }

    public void exibirPesquisa() {
        
        ObservableList<Bancoresponsavel> listaResponsaveis = ResponsavelDAO.listarpesquisaresponsaveis(input_pesquisa.getText());
        
        // Define as células de cada coluna para exibir os dados corretos
        CPF.setCellValueFactory(new PropertyValueFactory<>("cpf"));
        Endereco.setCellValueFactory(new PropertyValueFactory<>("endereco"));
        ID.setCellValueFactory(new PropertyValueFactory<>("id"));
        Nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        Telefone.setCellValueFactory(new PropertyValueFactory<>("telefone"));
        
        // Define os itens da TableView
        mytable.setItems(listaResponsaveis);
        mytable.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                // Quando uma linha é selecionada, você pode acessar os itens da linha e fazer o que precisar com eles
                Bancoresponsavel itemSelecionado = newSelection;
                //exibir o CPF na caixa de texto input_cpf
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
        // Limpa o conteúdo de todos os campos de entrada
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

