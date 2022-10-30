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
            ErrorWindow errorWindow = new ErrorWindow();
            errorWindow.start(stage);
        }
        else {
            HomeWindow homeWindow = new HomeWindow();
            homeWindow.start(stage);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

}
