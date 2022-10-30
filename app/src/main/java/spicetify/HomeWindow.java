package spicetify;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HomeWindow extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXML/HomeWindow.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("CSS/application.css").toExternalForm());

        stage.setTitle("Spicetify");
        stage.setScene(scene);
        stage.show();
        // System.out.println(getClass().getResource("FXML").toExternalForm());
    }

    public static void main(String[] args) {
        launch(args);
    }
}
