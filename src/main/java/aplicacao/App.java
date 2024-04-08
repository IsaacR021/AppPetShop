package aplicacao; 

import javafx.application.Application; // Importa a classe Application do JavaFX para iniciar a aplicação
import javafx.fxml.FXMLLoader; // Importa o FXMLLoader do JavaFX para carregar arquivos FXML
import javafx.scene.Parent; // Importa a classe Parent do JavaFX para representar a hierarquia de nós da interface do usuário
import javafx.scene.Scene; // Importa a classe Scene do JavaFX para representar uma cena
import javafx.stage.Stage; // Importa a classe Stage do JavaFX para representar a janela da aplicação
import java.io.IOException; // Importa a classe IOException para lidar com exceções de entrada/saída de arquivos


/**
 * JavaFX App
 */
public class App extends Application {
     
   
    private static Scene scene; 
    @SuppressWarnings("exports")
    @Override
    public void start(Stage stage) throws IOException { 
        UtilBD.criarbanco();
        scene = new Scene(loadFXML("inicio")); 
        stage.setScene(scene); 
        stage.show(); 
    }

    public static void setRoot(String fxml) throws IOException { 
        scene.setRoot(loadFXML(fxml)); 
    }

    private static Parent loadFXML(String fxml) throws IOException { 
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml")); 
        return fxmlLoader.load(); 
    }

    public static void main(String[] args) {
        
        
        
        launch(); 
    }

}
