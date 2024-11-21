module com.example.hydragame {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens CS3330.hydragame to javafx.fxml;
    exports CS3330.hydragame;
}