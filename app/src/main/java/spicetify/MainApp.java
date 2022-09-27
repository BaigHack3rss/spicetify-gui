package spicetify;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class MainApp extends Application{
    
    private static void error(String message){
        Text errMessage = new Text(message);
        Parent root = new StackPane();
        Scene scene = new Scene(root, 600, 408, Color.rgb(28, 28, 28));
        Stage stage = new Stage();
        Image error = new Image("file:src/main/resources/spicetify/images/Error.png");
        ImageView errorView = new ImageView(error);
        
        errorView.setTranslateY(-25);

        errMessage.setFont(Font.font("source code pro", FontWeight.BOLD, 20));
        errMessage.setFill(Color.RED);
        errMessage.setTranslateY(175);

        ((StackPane) root).getChildren().addAll(errMessage, errorView);

        stage.setScene(scene);
        stage.setTitle("Error: " + message);
        
        stage.show();
        
    } 

    @Override
    public void start(Stage stage) throws Exception {
        OperatingSystem os = new OperatingSystem();
        os.setOperatingSystem(System.getProperty("os.name"));
        os.setConfigDirectory(os.getOperatingSystem());
        if (os.getOperatingSystem().equals("Unknown")) {
            error("Unsupported Operating System");
        }
        else {
            return;
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

}
