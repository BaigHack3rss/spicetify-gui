package spicetify;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Scenes {

    public void homeScene(Stage stage) throws IOException {
        BorderPane root = FXMLLoader.load(getClass().getResource("FXML/HomeWindow.fxml"));
        Stage homeStage = stage;
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("CSS/application.css").toExternalForm());
        homeStage.setScene(scene);
        homeStage.setTitle("Spicetify - Home");
        homeStage.getIcons().add(new Image("file:src/main/resources/spicetify/images/essentials/icon.png"));
        homeStage.show();
    }
    
    public void themeScene(Stage stage) throws IOException {
        BorderPane root = FXMLLoader.load(getClass().getResource("FXML/ThemeWindow.fxml"));
        Stage homeStage = stage;
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("CSS/application.css").toExternalForm());
        homeStage.setScene(scene);
        homeStage.show();
    }

    public void extensionScene(Stage stage) throws IOException {
        BorderPane root = FXMLLoader.load(getClass().getResource("FXML/ExtensionWindow.fxml"));
        Stage homeStage = stage;
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("CSS/application.css").toExternalForm());
        homeStage.setScene(scene);
        homeStage.show();
    }

    public void editScene(Stage stage) throws IOException {
        BorderPane root = FXMLLoader.load(getClass().getResource("FXML/EditWindow.fxml"));
        Stage homeStage = stage;
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("CSS/application.css").toExternalForm());
        homeStage.setScene(scene);
        homeStage.show();
    } 

    public void errorScene(Stage stage, String errorText) throws IOException {
        BorderPane root = FXMLLoader.load(getClass().getResource("FXML/ErrorWindow.fxml"));
        Stage homeStage = stage;
        Scene scene = new Scene(root);
        Text textBox = (Text) scene.lookup("#errorText");
        textBox.setText(errorText);
        scene.getStylesheets().add(getClass().getResource("CSS/application.css").toExternalForm());
        homeStage.setScene(scene);
        homeStage.setResizable(false);
        homeStage.show();
    }
}
