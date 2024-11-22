package CS3330.hydragame;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Random;

public class HydraGameController {

    // CLASS FIELD(S)

    private Button playButton;

    private Button resetButton;

    private Slider sizeSlider;

    private GridPane board;

    private HydraHeadsFactory headFactory;

    private int headSize;

    private ArrayList<HydraHead> heads = new ArrayList<>();

    // CLASS METHODS
    HydraGameController(Button pb, Button rb, Slider s, GridPane gp) {
        playButton = pb;
        resetButton = rb;
        sizeSlider = s;
        board = gp;
    }

    public void initialize(URL rul, ResourceBundle rb) {

    }

    public void reset(ActionEvent event) {
        System.out.println("RESET BUTTON PRESSED");
        sizeSlider.setDisable(false);
        sizeSlider.setValue(4);
        playButton.setDisable(false);
    }

    public void play(ActionEvent event) {
        System.out.println("play");
        System.out.println("size: " + sizeSlider.getValue());
        headSize = (int) sizeSlider.getValue();
        sizeSlider.setDisable(true);
        //playButton.setDisable(true);
        HydraHead head = HydraHeadsFactory.getHead(headSize);
        Random random = new Random();
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

        System.out.println("x: " + x + ", y: " + y);
        head.putIn(x,y,board);
        heads.add(head);
    }

    public void setHeadSize(MouseEvent event) {

    }
}
