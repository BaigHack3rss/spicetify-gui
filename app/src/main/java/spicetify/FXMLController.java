package spicetify;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import javafx.scene.Node;

public class FXMLController {
    private Scenes scenes = new Scenes();

    @FXML
    private void switchToHome(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scenes.homeScene(stage);
    }

    @FXML
    private void switchToTheme(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scenes.themeScene(stage);
    }

    @FXML
    private void switchToExtension(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scenes.extensionScene(stage);

    }

    @FXML
    private void switchToEdit(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scenes.editScene(stage);
    }
}
