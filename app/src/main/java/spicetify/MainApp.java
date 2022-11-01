package spicetify;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class MainApp extends Application{ 
    private Parent root;
    private Scene scene;

    @Override
    public void start(Stage stage) throws Exception {
        OperatingSystem os = new OperatingSystem();

        os.setOperatingSystem(System.getProperty("os.name"));
        // os.setOperatingSystem("jackHammer");
        os.setConfigDirectory(os.getOperatingSystem());
        stage.setTitle("Spicetify");


        if (os.getOperatingSystem().equals("Unknown")) {
            root = FXMLLoader.load(getClass().getResource("FXML/ErrorWindow.fxml"));
            scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("CSS/application.css").toExternalForm());
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        }
        else {
            root = FXMLLoader.load(getClass().getResource("FXML/HomeWindow.fxml"));
            scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("CSS/application.css").toExternalForm());
            stage.setScene(scene);
            stage.show();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

}
