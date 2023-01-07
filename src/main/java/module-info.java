module com.catcafe.game {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.catcafe.game to javafx.fxml;
    exports com.catcafe.game;
}