package spicetify;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class BaseWindow{
    protected Parent root;
    protected Scene scene;
    protected Stage stage;
    protected String title;
    protected int width;
    protected int height;
    protected int red;
    protected int green;
    protected int blue;

    public BaseWindow(){
        
    }

    public BaseWindow(String title, int width, int height, int red, int green, int blue){
        this.title = title;
        this.width = width;
        this.height = height;
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.root = new StackPane();
        this.scene = new Scene(root, width, height, Color.rgb(red, green, blue));
        this.stage = new Stage();
    }

    public void start(Stage stage){
        stage.setScene(scene);
        stage.setTitle(title);
        stage.show();
    }

    public Parent getRoot() {
        return root;
    }
}

