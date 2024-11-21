package CS3330.hydragame;

import javafx.scene.image.Image;

import java.util.Objects;

public class HydraHeadsFactory {
    // CLASS
    private static final Image headSize1 = new Image("file:src/main/resources/CS3330/hydragame/HeadSize1.png");
    private static final Image headSize2 = new Image("file:src/main/resources/CS3330/hydragame/HeadSize2.png");
    private static final Image headSize3 = new Image("file:src/main/resources/CS3330/hydragame/HeadSize3.png");
    private static final Image headSize4 = new Image("file:src/main/resources/CS3330/hydragame/HeadSize4.png");
    private static final Image headSize5 = new Image("file:src/main/resources/CS3330/hydragame/HeadSize5.png");
    private static final Image headSize6 = new Image("file:src/main/resources/CS3330/hydragame/HeadSize6.png");

    // CLASS METHODS
    private HydraHeadsFactory() {}

    public static HydraHead getHead(int size) {
        switch (size) {
            case 1:
                return new HydraHead(headSize1,size);
            case 2:
                return new HydraHead(headSize2,size);
            case 3:
                return new HydraHead(headSize3,size);
            case 4:
                return new HydraHead(headSize4,size);
            case 5:
                return new HydraHead(headSize5,size);
            case 6:
                return new HydraHead(headSize6,size);
            default:
                return null;
        }
    }
}
