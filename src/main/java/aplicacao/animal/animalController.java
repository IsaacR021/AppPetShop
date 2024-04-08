package aplicacao.animal;
import entidades.Animal;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class animalController {

    @FXML
    private Button cadastrar;

    @FXML
    private TextField especie;

    @FXML
    private TextField idade;

    @FXML
    private TextField nome;

    @FXML
    private TextField raca;

    @FXML
    void ChamarRegistroAnimal(){
        String idadetext = idade.getText();
        int idadevalor = Integer.parseInt(idadetext);
        System.out.println(idadevalor);
        Animal animal= new Animal(nome.getText(),especie.getText(),raca.getText(),idadevalor);
        AnimalDAO.cadastroAnimal(animal);
    }

    @FXML
    void telaregistroanimal(ActionEvent event) {
        ChamarRegistroAnimal();

    }

}
