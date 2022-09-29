package spicetify;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.layout.StackPane;

public class ErrorWindow extends BaseWindow{
    private String errorMessage;
    private Text errorText;
    private ImageView errorImage;

    public ErrorWindow(String errorMessage, int width, int height, int red, int green, int blue){
        this.errorMessage = errorMessage;
        this.errorText = new Text(errorMessage);
        this.errorImage = new ImageView(new Image("file:src/main/resources/spicetify/images/essentials/Error.png"));
        this.width = width;
        this.height = height;
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    public void start(Stage stage){
        errorText = new Text(errorMessage);
        errorText.setFont(Font.font("Source Code Pro", FontWeight.BOLD, 20));
        errorText.setFill(Color.RED);
        errorText.setTranslateY(200);
        root = new StackPane(errorImage, errorText);
        scene = new Scene(root, width, height, Color.rgb(red, green, blue));
        stage.setTitle("Error");
        stage.setScene(scene);
        stage.setTitle(title);
        stage.show();
    }
}
