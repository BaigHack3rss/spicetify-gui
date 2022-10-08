package spicetify;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class HomeWindow extends BaseWindow {
    BaseWindow baseWindow = new BaseWindow();
    // EventHandler eventHandler = new EventHandler();
    private ImageView logoView;
    private ImageView preview;
    private BorderPane root;
    private AnchorPane centerAnchorPane;
    private VBox vBox;
    Scene scene;
    
    public HomeWindow(int width, int height, String html){
        this.logoView = new ImageView(new Image("file:src/main/resources/spicetify/images/essentials/logo.png"));
        this.preview = new ImageView(new Image("file:src/main/resources/spicetify/images/essentials/Preview.png"));
        this.root = new BorderPane();
        this.vBox = new VBox();
        this.centerAnchorPane = new AnchorPane();
        baseWindow.setWidth(width);
        baseWindow.setHeight(height);
        baseWindow.setHtmlColor(html);
    }

    public void start(Stage stage){
        root.setLeft(vBox);
        root.setCenter(centerAnchorPane);
        vBox.setPrefHeight(baseWindow.getHeight());
        vBox.setPrefWidth(100);
        vBox.styleProperty().set("-fx-background-color: #282828");

        this.logoView.setFitHeight(800);
        this.logoView.setFitWidth(700);
        this.logoView.setPreserveRatio(true);
        this.logoView.setTranslateX(225);

        this.preview.setFitHeight(500);
        this.preview.setFitWidth(400);
        this.preview.setPreserveRatio(true);
        this.preview.setTranslateX(550);
        this.preview.setTranslateY(300);

        centerAnchorPane.getChildren().add(logoView);   
        centerAnchorPane.getChildren().add(preview);

        scene = new Scene(root, baseWindow.getWidth(), baseWindow.getHeight(), Color.web(baseWindow.getHtmlColor()));
        stage.setScene(scene);
        stage.setTitle("Spicetify");
        stage.setResizable(false);
        stage.show();
    }
}
