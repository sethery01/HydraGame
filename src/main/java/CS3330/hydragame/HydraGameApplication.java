// Developed on a Windows machine.

package CS3330.hydragame;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;

public class HydraGameApplication extends Application {

    // Launch the application
    public static void main(String[] args) {
        launch(args);
    }

    // Creates the initial stage
    @Override
    public void start(Stage stage) {

        // Setup label and sliders
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

        // Organize buttons and slider
        HBox viewBox = new HBox(10, resetButton, sizeSlider, playButton);
        viewBox.setAlignment(Pos.CENTER);
        viewBox.setPrefWidth(800);
        viewBox.setPadding(new Insets(10));
        HBox.setHgrow(resetButton, Priority.ALWAYS);
        HBox.setHgrow(sizeSlider, Priority.ALWAYS);
        HBox.setHgrow(playButton, Priority.ALWAYS);
        viewBox.setAlignment(Pos.CENTER);

        // Create a GridPane with fixed size and empty placeholders
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(5);
        grid.setVgap(5);
        for (int i = 0; i < 15; i++) {
            ColumnConstraints col = new ColumnConstraints(40);
            grid.getColumnConstraints().add(col);
        }
        for (int i = 0; i < 15; i++) {
            RowConstraints row = new RowConstraints(40);
            grid.getRowConstraints().add(row);
        }

        // VBox layout for all components
        VBox vbox = new VBox(5, messageLabel, viewBox, grid);
        vbox.setAlignment(Pos.TOP_CENTER);

        // Create an instance of the controller
        HydraGameController controller = new HydraGameController(playButton,resetButton,sizeSlider,grid,vbox);
        playButton.setOnAction(event -> controller.play(event));
        resetButton.setOnAction(event -> controller.reset(event));

        // Set stage
        stage.setTitle("Hydra Game");
        stage.getIcons().add(new Image("file:src/main/resources/CS3330/hydragame/HydraIcon.png"));
        Scene scene = new Scene(vbox, 800, 850);
        stage.setScene(scene);
        stage.show();
    }
}
