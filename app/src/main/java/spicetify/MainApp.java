package spicetify;

import javafx.application.Application;
import javafx.stage.Stage;

public class MainApp extends Application{ 

    @Override
    public void start(Stage stage) throws Exception {
        OperatingSystem os = new OperatingSystem();

        os.setOperatingSystem(System.getProperty("os.name"));
        // os.setOperatingSystem("TruckOS");
        os.setConfigDirectory(os.getOperatingSystem());

        if (os.getOperatingSystem().equals("Unknown")) {
            ErrorWindow errorWindow = new ErrorWindow("Unknown Operating System", 600, 500, "#1c1c1c");
            errorWindow.start(stage);
        }
        else {
            HomeWindow homeWindow = new HomeWindow(1280, 720, "#1c1c1c");
            homeWindow.start(stage);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

}
