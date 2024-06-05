package aplicacao.animal;


import java.io.IOException;

import aplicacao.App;
import entidades.Animal;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class animalController {

    @FXML
    private TextField input_nome;

    @FXML
    private TextField input_especie;

    @FXML
    private TextField input_raca;

    @FXML
    private TextField input_cpf;

    

    @FXML
    private Button cadastrar;

    @FXML
    private Button deletar;

    @FXML
    private Button atualizar;


    @FXML
    private Label info;

    @FXML
    private TableView<Animal> mytable2;

    @FXML
    private TableColumn<Animal, Integer> ID;

    @FXML
    private TableColumn<Animal, String> Nome;

    @FXML
    private TableColumn<Animal, String> Especie;

    @FXML
    private TableColumn<Animal, String> Raca;

    @FXML
    private TableColumn<Animal, Long> Cpfresponsavel;

    @FXML
    void limparCampos(ActionEvent event) {
        
        input_nome.clear();
        input_especie.clear();
        input_raca.clear();
        input_cpf.clear();
    }

    @FXML
    void limparInfo() {
    info.setText("");
    }




    @FXML
    private void botaocadastrar(ActionEvent event) {
        

        if (input_nome.getText().isEmpty() || 
        input_especie.getText().isEmpty() || 
        input_raca.getText().isEmpty() || 
        input_cpf.getText().isEmpty()) {
        
        info.setText("Preencha todos os campos.");
        return; 
    }
        limparInfo();
        String nome = input_nome.getText();
        String especie = input_especie.getText();
        String raca = input_raca.getText();
        long responsavelCpf =Long.parseLong(input_cpf.getText());

        
        Animal animal = new Animal(0,nome,especie,raca,responsavelCpf);
        AnimalDAO.cadastrarAnimal(animal,info);

        initialize();
        limparCampos(event);
    }

    @FXML
    private void botaodeletar(ActionEvent event) {

        limparInfo();

        int id = getIdSelecionado();
        String nome = input_nome.getText();
        String especie = input_especie.getText();
        String raca = input_raca.getText();
        long responsavelCpf =Long.parseLong(input_cpf.getText());
        // Lógica para deletar
        Animal animal = new Animal(id,nome,especie,raca,responsavelCpf);
        AnimalDAO.excluirAnimal(animal,info);


        initialize();
        limparCampos(event);
    }

    @FXML
    private void botaoatualizar(ActionEvent event) {

        limparInfo();

        int id = getIdSelecionado();
        String nome = input_nome.getText();
        String especie = input_especie.getText();
        String raca = input_raca.getText();
        long responsavelCpf =Long.parseLong(input_cpf.getText());
        // Lógica para deletar
        Animal animal = new Animal(id,nome,especie,raca,responsavelCpf);
        AnimalDAO.atualizarAnimal(animal,info);


        initialize();
        limparCampos(event);
    }

    @FXML
    private void botaomostrartodos(ActionEvent event) {
        
        System.out.println("Botão mostrar todos clicado");
    }

    @FXML
    private void botaopesquisar(ActionEvent event) {
        
        System.out.println("Botão pesquisar clicado");
    }

    @FXML
    private void botaovoltar(ActionEvent event) throws IOException {
        
        App.changeScene("inicio", 900, 538);
    }
    private int idSelecionado;
    public void exibirDados() {
        
        ObservableList<Animal> listaResponsaveis = AnimalDAO.listartodosaAnimals();
        
        
        ID.setCellValueFactory(new PropertyValueFactory<>("id"));
        Nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        Especie.setCellValueFactory(new PropertyValueFactory<>("especie"));
        Raca.setCellValueFactory(new PropertyValueFactory<>("raca"));
        Cpfresponsavel.setCellValueFactory(new PropertyValueFactory<>("responsavel_cpf"));
        
        
        mytable2.setItems(listaResponsaveis);
        mytable2.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                
                Animal itemSelecionado = newSelection;
                
                idSelecionado=itemSelecionado.getId();
                input_nome.setText(itemSelecionado.getNome());
                input_especie.setText(itemSelecionado.getEspecie());
                input_raca.setText(itemSelecionado.getRaca());
                input_cpf.setText(String.valueOf(itemSelecionado.getResponsavel_cpf()));


                
            }
        });
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
