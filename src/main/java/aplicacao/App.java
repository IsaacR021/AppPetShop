package aplicacao; 

import javafx.application.Application; 
import javafx.fxml.FXMLLoader; 
import javafx.scene.Parent; 
import javafx.scene.Scene; 
import javafx.stage.Stage; 
import java.io.IOException; 


/**
 * JavaFX App
 */
public class App extends Application {
     
   
    private static Scene scene; 
    private static Stage primaryStage;
    @SuppressWarnings("exports")
    @Override
    public void start(Stage stage) throws IOException { 

        primaryStage = stage;
        UtilBD.criarbanco();
        scene = new Scene(loadFXML("inicio")); 
        stage.setScene(scene); 
        stage.setResizable(false); 
        stage.show(); 
        stage.centerOnScreen();
    }

    public static void changeScene(String fxml, double width, double height) throws IOException {
        Scene newScene = new Scene(loadFXML(fxml), width, height);
        primaryStage.setScene(newScene);
        primaryStage.centerOnScreen();
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
