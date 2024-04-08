package aplicacao.inicio;

import java.io.IOException;

import aplicacao.App;
import javafx.fxml.FXML;

public class inicioController {
    @FXML
    void ChamarTelaResp() throws IOException{
        App.setRoot("register_resp"); 
    }
    @FXML
    void ChamarTelaAnimal() throws IOException{
        App.setRoot("register_animal"); 
    }




    

}
