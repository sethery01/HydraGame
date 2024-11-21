package CS3330.hydragame;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.ResourceBundle;

public class HydraGameController {

    // CLASS FIELD(S)

    private Button playButton;

    private Button resetButton;

    private Slider sizeSlider;

    private GridPane gridPane;

    private HydraHeadsFactory headFactory;

    private int headSize;

    // CLASS METHODS
    public void initialize(URL rul, ResourceBundle rb) {

    }

    public void reset(ActionEvent event) {

    }

    public void play(ActionEvent event) {
        System.out.println("play");
    }

    public void setHeadSize(MouseEvent event) {

    }
}
