package aplicacao.inicio;

import java.io.IOException;

import aplicacao.App;
import javafx.fxml.FXML;

public class inicioController {
    @FXML
    void ChamarTelaResp() throws IOException{
        App.changeScene("register_resp", 900, 538); 
    }
    @FXML
    void ChamarTelaAnimal() throws IOException{
        App.changeScene("register_animal", 900, 538);
    }

    @FXML
    void ChamarTelaAgendamentos() throws IOException{
        App.changeScene("agendamentos", 1255, 547);
    }




    

}
