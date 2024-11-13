package CS3330.hydragame;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class HydraGameApplication extends Application {

    // Launch the application
    public static void main(String[] args) {
        launch(args);
    }

    // Creates the initial stage
    @Override
    public void start(Stage stage) {
        Label messageLabel = new Label("Hello World");
        VBox vbox = new VBox(messageLabel);
        Scene scene = new Scene(vbox, 800, 850);
        stage.setScene(scene);
        stage.show();
    }
}
