package Main;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class GameEntity {
    public Point coordinate;
    public Image image;
    public void draw(GraphicsContext g2){
        g2.drawImage(image,coordinate.x,coordinate.y);
    }
}
