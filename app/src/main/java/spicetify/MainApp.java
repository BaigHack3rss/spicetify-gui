package spicetify;

import javafx.application.Application;
import javafx.stage.Stage;

public class MainApp extends Application{ 

    @Override
    public void start(Stage stage) throws Exception {
        OperatingSystem os = new OperatingSystem();

        os.setOperatingSystem(System.getProperty("os.name"));
        os.setConfigDirectory(os.getOperatingSystem());

        if (os.getOperatingSystem().equals("Unknown")) {
            ErrorWindow errorWindow = new ErrorWindow("Unknown Operating System", 600, 500, 28, 28, 28);
            errorWindow.start(stage);
        }
        else {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

}
