package spicetify;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class HomeWindow extends BaseWindow{
    private ImageView logoView;
    private Parent root;
    private Scene scene;
    BaseWindow baseWindow = new BaseWindow();
    Sidebar sidebar = new Sidebar(baseWindow.getHeight(), 100, "#282828", root);
    
    public HomeWindow(){
        this.root = new BorderPane();
        this.logoView = new ImageView(new Image("file:src/main/resources/spicetify/images/essentials/logo.png"));
        this.scene = baseWindow.getScene();
    }

    public HomeWindow(int width, int height, String html){
        this.logoView = new ImageView(new Image("file:src/main/resources/spicetify/images/essentials/logo.png"));
        this.root = new BorderPane();
        this.scene = baseWindow.getScene();
        baseWindow.setWidth(width);
        baseWindow.setMinWidth(width);
        baseWindow.setHeight(height);
        baseWindow.setMinHeight(height);
        baseWindow.setHtmlColor(html);
    }


    public void start(Stage stage){
        root.setStyle("-fx-background-color: transparent;");
        ((BorderPane) root).setLeft(sidebar.getSidebar());
        baseWindow.transform(logoView, 600, 700, true);
        ((BorderPane) root).setCenter(logoView);
        baseWindow.setStage(stage);
        baseWindow.setTitle("Spicetify");
        baseWindow.setRoot(root);
        baseWindow.setScene(new Scene(baseWindow.getRoot(), baseWindow.getWidth(), baseWindow.getHeight(), Color.web(baseWindow.getHtmlColor())));
        baseWindow.getStage().setScene(baseWindow.getScene());
        baseWindow.getStage().setMinWidth(baseWindow.getMinWidth());
        baseWindow.getStage().setMinHeight(baseWindow.getMinHeight());
        baseWindow.getStage().setTitle(baseWindow.getTitle());
        baseWindow.getStage().show();
    }
}
