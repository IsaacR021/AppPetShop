package aplicacao; // Declaração do pacote onde a classe App está contida

import javafx.application.Application; // Importa a classe Application do JavaFX para iniciar a aplicação
import javafx.fxml.FXMLLoader; // Importa o FXMLLoader do JavaFX para carregar arquivos FXML
import javafx.scene.Parent; // Importa a classe Parent do JavaFX para representar a hierarquia de nós da interface do usuário
import javafx.scene.Scene; // Importa a classe Scene do JavaFX para representar uma cena
import javafx.stage.Stage; // Importa a classe Stage do JavaFX para representar a janela da aplicação
import java.io.IOException; // Importa a classe IOException para lidar com exceções de entrada/saída de arquivos

/**
 * JavaFX App
 */
public class App extends Application { // Declaração da classe App que estende a classe Application do JavaFX
   
    private static Scene scene; // Declaração de uma cena estática para a aplicação
    @SuppressWarnings("exports")
    @Override
    public void start(Stage stage) throws IOException { // Método de inicialização da aplicação
        scene = new Scene(loadFXML("register_resp")); // Cria uma nova cena com base no arquivo FXML "primary.fxml" e define as dimensões
        stage.setScene(scene); // Define a cena para o palco (Stage)
        stage.show(); // Mostra o palco
    }

    static void setRoot(String fxml) throws IOException { // Método estático para definir o nó raiz da cena
        scene.setRoot(loadFXML(fxml)); // Define o nó raiz da cena carregando o arquivo FXML especificado
    }

    private static Parent loadFXML(String fxml) throws IOException { // Método privado para carregar arquivos FXML
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml")); // Cria um objeto FXMLLoader para carregar o arquivo FXML
        return fxmlLoader.load(); // Carrega e retorna a hierarquia de nós do arquivo FXML como um objeto Parent
    }

    public static void main(String[] args) { // Método principal para iniciar a aplicação
        launch(); // Inicia a aplicação JavaFX
    }

}
