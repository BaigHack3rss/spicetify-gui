package spicetify;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BaseWindow{
    private Parent root;
    private Scene scene;
    private Stage stage;
    private String title;
    private int width;
    private int height;
    private String htmlColor;

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

    public void start(Stage stage){
        stage.setScene(scene);
        stage.setTitle(title);
        stage.show();
    }
}

