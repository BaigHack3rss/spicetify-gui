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

public class ErrorWindow {
    BaseWindow baseWindow = new BaseWindow();
    private String errorMessage;
    private Text errorText;
    private ImageView errorImage;

    public ErrorWindow(String errorMessage, int width, int height, String html){
        this.errorMessage = errorMessage;
        this.errorText = new Text(errorMessage);
        this.errorImage = new ImageView(new Image("file:src/main/resources/spicetify/images/essentials/Error.png"));
        baseWindow.setWidth(width);
        baseWindow.setHeight(height);
        baseWindow.setHtmlColor(html);

    }

    public void start(Stage stage){
        errorText = new Text(errorMessage);
        errorText.setFont(Font.font("Source Code Pro", FontWeight.BOLD, 20));
        errorText.setFill(Color.RED);
        errorText.setTranslateY(200);
        baseWindow.setRoot(new StackPane(errorImage, errorText));
        baseWindow.setScene(new Scene(baseWindow.getRoot(), baseWindow.getWidth(), baseWindow.getHeight(), Color.web(baseWindow.getHtmlColor())));
        stage.setTitle("Error");
        stage.setScene(baseWindow.getScene());
        stage.setResizable(false);
        stage.show();
    }
}
