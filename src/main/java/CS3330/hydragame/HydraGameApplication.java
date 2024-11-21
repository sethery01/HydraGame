package CS3330.hydragame;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.beans.EventHandler;
import java.util.Objects;

public class HydraGameApplication extends Application {

    // Launch the application
    public static void main(String[] args) {
        launch(args);
    }

    // Creates the initial stage
    @Override
    public void start(Stage stage) {
        HydraGameController controller = new HydraGameController();

        Label messageLabel = new Label("Head Size");
        Slider sizeSlider = new Slider(1, 6, 4);
        sizeSlider.setShowTickLabels(true);
        sizeSlider.setShowTickMarks(true);
        sizeSlider.setMajorTickUnit(1);
        sizeSlider.setMinorTickCount(0);
        sizeSlider.setSnapToTicks(true);

        // Create buttons
        Button playButton = new Button("Play");
        Button resetButton = new Button("Reset");
        playButton.setPrefWidth(150);
        resetButton.setPrefWidth(150);
        playButton.setOnAction(event -> controller.play(event));
        resetButton.setOnAction(event -> controller.reset(event));

        // Organize buttons and slider
        HBox viewBox = new HBox(10, resetButton, sizeSlider, playButton);
        viewBox.setAlignment(Pos.CENTER);
        viewBox.setPrefWidth(800);
        viewBox.setPadding(new Insets(10));
        HBox.setHgrow(resetButton, Priority.ALWAYS);
        HBox.setHgrow(sizeSlider, Priority.ALWAYS);
        HBox.setHgrow(playButton, Priority.ALWAYS);
        viewBox.setAlignment(Pos.CENTER);

        // Create a GridPane
        GridPane grid = new GridPane();


        // VBox layout for all components
        VBox vbox = new VBox(5, messageLabel, viewBox, grid);
        vbox.setAlignment(Pos.TOP_CENTER);

        // Set stage
        stage.setTitle("Hydra Game");
        stage.getIcons().add(new Image("file:src/main/resources/CS3330/hydragame/HydraIcon.png"));
        Scene scene = new Scene(vbox, 800, 850);
        stage.setScene(scene);
        stage.show();
    }
}
