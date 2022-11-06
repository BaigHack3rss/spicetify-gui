package spicetify;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Scenes {
    private OperatingSystem os = new OperatingSystem(System.getProperty("os.name"));
    private String currentTheme, themeVariant;

    public void homeScene(Stage stage) throws IOException {
        // set window root, stage, scene and properties
        BorderPane root = FXMLLoader.load(getClass().getResource("FXML/HomeWindow.fxml"));
        Stage homeStage = stage;
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("CSS/application.css").toExternalForm());
        homeStage.setScene(scene);
        homeStage.setTitle("Spicetify - Home");
        homeStage.setMinHeight(605);
        homeStage.setMinWidth(895);
        homeStage.getIcons().add(new Image("file:src/main/resources/spicetify/images/essentials/icon.png"));
        homeStage.show();

        // find nodes for the first half of the scene from fxml file
        SplitPane homePane1 = (SplitPane) scene.lookup("#homePane1");
        BorderPane homePane1_1 = (BorderPane) scene.lookup("#homePane1_1");
        ImageView logoView = (ImageView) scene.lookup("#logoView");
        ImageView appPreview = (ImageView) scene.lookup("#appPreview");

        // bind the logo's width and height so that resizing the window will resize the logo
        logoView.fitWidthProperty().bind(homePane1_1.widthProperty().divide(1.25));
        logoView.fitHeightProperty().bind(homePane1_1.heightProperty().divide(2.50));

        // bind the app preview's width and height so that resizing the window will resize the app preview
        appPreview.fitWidthProperty().bind(homePane1_1.widthProperty().divide(1.50));
        appPreview.fitHeightProperty().bind(homePane1_1.heightProperty().divide(2));
        
        // find nodes for the second half of the scene from fxml file
        SplitPane homePane2 = (SplitPane) scene.lookup("#homePane2");
        BorderPane homePane2_1 = (BorderPane) scene.lookup("#homePane2_1");
        ImageView themePreview = (ImageView) scene.lookup("#themePreview");
        Text themeName = (Text) scene.lookup("#themeName");
        Text title = (Text) scene.lookup("#title");
        
        // get the width ratio between homePane1 and homePane2 (the 2 halves of the scene).
        double splitPaneWidthRatio = homePane1.widthProperty().divide(homePane2.widthProperty()).doubleValue();
        
        // maintain the ratio between homePane1 and homePane2 when resizing
        homePane2.minWidthProperty().bind(homePane1.widthProperty().divide(splitPaneWidthRatio));

        // bind the title and theme name's font size so that resizing the window will resize the font
        title.styleProperty()
            .bind(homePane2_1.widthProperty().asString()
            .concat("px")
            .concat(";-fx-font-size: ")
            .concat(homePane2_1.widthProperty()
            .divide(10).asString())
            .concat("px;"));

        themeName.styleProperty()
            .bind(homePane2_1.widthProperty().asString()
            .concat("px")
            .concat(";-fx-font-size: ")
            .concat(homePane2_1.widthProperty()
            .divide(15).asString())
            .concat("px;"));

        // bind the theme preview's width and height so that resizing the window will resize the theme preview
        themePreview.fitWidthProperty().bind(homePane2_1.widthProperty().divide(1.25));
        themePreview.fitHeightProperty().bind(homePane2_1.heightProperty().divide(1.75));
        
        // set the themeName and themePreview to whatever theme the user has selected
        currentTheme = os.readConfig("current_theme");
        themeVariant = os.readConfig("color_scheme");
        themeName.setText(currentTheme + " " + themeVariant);
        themePreview.setImage(os.getThemePreview(currentTheme, themeVariant));
    }
    
    public void themeScene(Stage stage) throws IOException {
        // set window root, stage, scene and properties
        BorderPane root = FXMLLoader.load(getClass().getResource("FXML/ThemeWindow.fxml"));
        Stage themeStage = stage;
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("CSS/application.css").toExternalForm());
        themeStage.setScene(scene);
        themeStage.show();
    }

    public void extensionScene(Stage stage) throws IOException {
        // set window root, stage, scene and properties
        BorderPane root = FXMLLoader.load(getClass().getResource("FXML/ExtensionWindow.fxml"));
        Stage extensionStage = stage;
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("CSS/application.css").toExternalForm());
        extensionStage.setScene(scene);
        extensionStage.show();
    }

    public void editScene(Stage stage) throws IOException {
        // set window root, stage, scene and properties
        BorderPane root = FXMLLoader.load(getClass().getResource("FXML/EditWindow.fxml"));
        Stage editStage = stage;
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("CSS/application.css").toExternalForm());
        editStage.setScene(scene);
        editStage.show();
    } 

    public void errorScene(Stage stage, String errorText) throws IOException {
        // set window root, stage, scene and properties
        BorderPane root = FXMLLoader.load(getClass().getResource("FXML/ErrorWindow.fxml"));
        Stage errorStage = stage;
        Scene scene = new Scene(root);
        Text textBox = (Text) scene.lookup("#errorText");
        textBox.setText(errorText);
        scene.getStylesheets().add(getClass().getResource("CSS/application.css").toExternalForm());
        errorStage.setScene(scene);
        errorStage.setResizable(false);
        errorStage.show();
    }
}
