package spicetify;

import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

public class Sidebar {
    BaseWindow baseWindow = new BaseWindow();
    private String[] buttonIconLocation = {
        "file:src/main/resources/spicetify/images/buttons/home.png",
        "file:src/main/resources/spicetify/images/buttons/theme.png",
        "file:src/main/resources/spicetify/images/buttons/extension.png",
        "file:src/main/resources/spicetify/images/buttons/edit.png",
    };
    private ImageView[] buttonIcon = new ImageView[4];
    private VBox sidebar;
    private Button[] buttons = new Button[4];
    private Tooltip[] tooltips = new Tooltip[4];
    private String[] buttonNames = {
        "Home",
        "Theme",
        "Extension",
        "Edit"
    };
    
    public Sidebar(int height, int width, String html, Parent root){
        this.sidebar = new VBox();
        this.sidebar.setPrefHeight(height);
        this.sidebar.setPrefWidth(width);
        this.sidebar.setStyle("-fx-background-color: " + html);
        
        for (int i = 0; i < buttonIcon.length; i++){
            buttonIcon[i] = new ImageView(buttonIconLocation[i]);
            baseWindow.transform(buttonIcon[i], 50, 50, true);
        }        

        for (int i = 0; i < buttons.length; i++){
            buttons[i] = new Button("", buttonIcon[i]);
            sidebar.getChildren().add(buttons[i]);
            buttons[i].setTranslateX(18);
            buttons[i].setTranslateY(i * 100);
            // Give the buttons an id
            buttons[i].setId(buttonNames[i]);
            // set button tooltip
            tooltips[i] = new Tooltip(buttonNames[i]);
            tooltips[i].setShowDelay(new Duration(250));
            // set tooltip size
            tooltips[i].setPrefWidth(100);
            tooltips[i].setPrefHeight(25);
            // set tooltip text size
            tooltips[i].setStyle("-fx-font-size: 15px;");
            Tooltip.install(buttons[i], tooltips[i]);

            buttons[i].setStyle("-fx-background-color: transparent;");

            colorChangeOnEvent(i);
        }

    }

    // method to highlight button when mouse hover
    public void colorChangeOnEvent(int index){
        buttons[index].setOnMouseEntered(e -> {
            buttons[index].setStyle("-fx-background-color: rgba(30,30,30,0.85);");
        });
        buttons[index].setOnMouseExited(e -> {
            buttons[index].setStyle("-fx-background-color: transparent;");
        });
        buttons[index].setOnMousePressed(e -> {
            buttons[index].setStyle("-fx-background-color: rgba(30,30,30,0.50);");
        });
        buttons[index].setOnMouseReleased(e -> {
            buttons[index].setStyle("-fx-background-color: rgba(30,30,30,0.85);");
        });
    }

    public String[] getButtonIconLocation() {
        return buttonIconLocation;
    }

    public void setButtonIconLocation(String[] buttonIconLocation) {
        this.buttonIconLocation = buttonIconLocation;
    }

    public ImageView[] getButtonIcon() {
        return buttonIcon;
    }

    public void setButtonIcon(ImageView[] buttonIcon) {
        this.buttonIcon = buttonIcon;
    }

    public VBox getSidebar() {
        return sidebar;
    }

    public void setSidebar(VBox sidebar) {
        this.sidebar = sidebar;
    }


}
