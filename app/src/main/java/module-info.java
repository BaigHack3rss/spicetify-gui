module spicetify {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;
    
    opens spicetify to javafx.fxml;
    exports spicetify;
}
