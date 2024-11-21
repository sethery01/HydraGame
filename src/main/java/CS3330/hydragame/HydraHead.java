package CS3330.hydragame;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class HydraHead extends ImageView {
    // CLASS FIELDS
    private int headSize;
    private int currentGirdX;
    private int currentGirdY;

    // CLASS METHODS
    public HydraHead(Image image, int size) {

    }

    public int getHeadSize() {
        return headSize;
    }

    public int getGridX() {
        return currentGirdX;
    }

    public int getGridY() {
        return currentGirdY;
    }

    public void putIn(int gridX, int gridY, GridPane board) {
        currentGirdX = gridX;
        currentGirdY = gridY;

    }
}
