package aplicacao;

import java.io.IOException;
import javafx.fxml.FXML;

public class animalController {

    @FXML
    private void telaregistroanimal() throws IOException {
        App.setRoot("register_animal");
    }
}