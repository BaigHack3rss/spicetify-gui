package spicetify;

import javafx.application.Application;
import javafx.stage.Stage;

public class MainApp extends Application{ 
    private OperatingSystem os = new OperatingSystem(System.getProperty("os.name"));
    private Scenes scenes = new Scenes();
    private String errorText = "Spicetify is not installed correctly. Please install it and try again.";
    private boolean readyToLaunch = os.readyToGo();

    @Override
    public void start(Stage stage) throws Exception {        
        if (readyToLaunch) {
            scenes.homeScene(stage);
        }
        else {
            if (os.getOperatingSystem().equals("Unknown")) {
                errorText = "Your operating system is not supported. Please use Windows, MacOS, or Linux.";
            }
            scenes.errorScene(stage, errorText);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

}
