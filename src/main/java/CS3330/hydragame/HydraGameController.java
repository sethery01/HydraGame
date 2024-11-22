package CS3330.hydragame;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Random;

public class HydraGameController {

    // CLASS FIELDS
    private Button playButton;
    private Button resetButton;
    private Slider sizeSlider;
    private GridPane board;
    private VBox vbox;
    private HydraHeadsFactory headFactory;
    private int headSize;
    private ArrayList<HydraHead> heads = new ArrayList<>();
    private int headsClicked;
    private Label l;

    // CLASS METHODS
    HydraGameController(Button pb, Button rb, Slider s, GridPane gp, VBox box) {
        playButton = pb;
        resetButton = rb;
        sizeSlider = s;
        board = gp;
        vbox = box;
    }

    public void initialize(URL rul, ResourceBundle rb) {
        // Needed for JavaFX magic
    }

    // On reset button press clear window of heads and message
    public void reset(ActionEvent event) {
        System.out.println("RESET BUTTON PRESSED");
        sizeSlider.setDisable(false);
        sizeSlider.setValue(4);
        playButton.setDisable(false);
        board.getChildren().clear();
        if (l != null) {
            vbox.getChildren().remove(l);
            l = null;
        }
    }

    // On play button press create a new head of size from the slider
    public void play(ActionEvent event) {
        System.out.println("play");
        System.out.println("size: " + sizeSlider.getValue());

        // Check if slider is a valid value
        headSize = (int) sizeSlider.getValue();
        if (headSize < 2) {
            reset(null);
            return;
        }

        // Do some setup by disabling buttons, creating a head, and action event for head
        headsClicked = 0;
        sizeSlider.setDisable(true);
        playButton.setDisable(true);
        HydraHead head = HydraHeadsFactory.getHead(headSize);
        head.setOnMouseClicked(mouseEvent -> this.setHeadSize(mouseEvent));

        // Generate random cords
        Random random = new Random();
        int x = random.nextInt(15);
        int y = random.nextInt(15);
        boolean dupe = true;

        // Check if a head already is at that coordinate then place head
        if (!heads.isEmpty()) {
            while (dupe) {
                x = random.nextInt(15);
                y = random.nextInt(15);
                dupe = false;
                for (HydraHead h : heads) {
                    if (h.getX() == x && h.getY() == y) {
                        dupe = true;
                        break;
                    }
                }
            }
        }
        head.putIn(x,y,board);
        heads.add(head);
    }

    public void setHeadSize(MouseEvent event) {
        // Logic to delete head and find n - 1 size
        System.out.println("setHeadSize called");
        headsClicked++;
        HydraHead headClicked = (HydraHead) event.getSource();
        headSize = headClicked.getHeadSize() - 1;
        heads.remove(headClicked);
        board.getChildren().remove(headClicked);
        if (headSize < 1) {
            if (heads.isEmpty()) {
                String str = String.format("You clicked %d heads! Press reset to play again!", headsClicked);
                l = new Label(str);
                l.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");
                vbox.getChildren().add(l);
            }
            return;
        }

        // Make 2-3 new heads
        Random random = new Random();
        int numberOfNewHeads = random.nextInt(2) + 2;
        for (int i = 0; i < numberOfNewHeads; i++) {

            HydraHead head = HydraHeadsFactory.getHead(headSize);
            head.setOnMouseClicked(mouseEvent -> this.setHeadSize(mouseEvent));
            int x = random.nextInt(15);
            int y = random.nextInt(15);
            boolean dupe = true;

            if (!heads.isEmpty()) {
                while (dupe) {
                    x = random.nextInt(15);
                    y = random.nextInt(15);
                    dupe = false;
                    for (HydraHead h : heads) {
                        if (h.getX() == x && h.getY() == y) {
                            dupe = true;
                            break;
                        }
                    }
                }
            }
            head.putIn(x, y, board);
            heads.add(head);
        }
    }
}
