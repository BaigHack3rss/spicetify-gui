package spicetify;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class BaseWindow{
    private Parent root;
    private Scene scene;
    private Stage stage;
    private String title;
    private int width;
    private int height;
    private int minWidth;
    private int minHeight;
    private String htmlColor;

    public int getMinWidth() {
        return minWidth;
    }

    public void setMinWidth(int minWidth) {
        this.minWidth = minWidth;
    }

    public int getMinHeight() {
        return minHeight;
    }

    public void setMinHeight(int minHeight) {
        this.minHeight = minHeight;
    }

    public String getHtmlColor() {
        return htmlColor;
    }

    public void setHtmlColor(String htmlColor) {
        this.htmlColor = htmlColor;
    }

    public Parent getRoot() {
        return root;
    }

    public void setRoot(Parent root) {
        this.root = root;
    }

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    // Transform Image sizes to fit the window

    public void transform(ImageView view, int width, int height, boolean preserveRatio){
        view.setFitWidth(width);
        view.setFitHeight(height);
        view.setPreserveRatio(preserveRatio);
    }

    // Start the window
    public void start(Stage stage){
        stage.setScene(scene);
        stage.setTitle(title);
        stage.show();
    }
}

