package Main;

import GameEntity.GameEntity;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

/**
 * Created with IntelliJ IDEA.
 * User: Incognito
 * Date: 11/9/19
 * Time: 11:08 AM
 * To change this template use File | Settings | File Templates.
 */
public class GameDrawer {
    private GraphicsContext gc;
    private GameField field;
    public GameDrawer(GraphicsContext gc, GameField field){
        this.gc = gc;
        this.field = field;
    }

    public void draw(){
        for(GameEntity e : field.entities) {

            e.draw(gc);
        }
    }
}
