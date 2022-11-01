package spicetify;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.Node;

public class FXMLController {
    private BorderPane root;
    private Scene scene;
    private Stage stage;

    @FXML
    private void switchToHome(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("FXML/HomeWindow.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("CSS/application.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void switchToTheme(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("FXML/ThemeWindow.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        root.setCenter(new ImageView(getClass().getResource("images/buttons/theme.png").toExternalForm()));
        scene.getStylesheets().add(getClass().getResource("CSS/application.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void switchToExtension(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("FXML/ExtensionWindow.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        root.setCenter(new ImageView(getClass().getResource("images/buttons/extension.png").toExternalForm()));
        scene.getStylesheets().add(getClass().getResource("CSS/application.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void switchToEdit(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("FXML/EditWindow.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        root.setCenter(new ImageView(getClass().getResource("images/buttons/edit.png").toExternalForm()));
        scene.getStylesheets().add(getClass().getResource("CSS/application.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }
}
