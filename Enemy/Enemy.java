package Enemy;

import GameEntity.GameEntity;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.HashSet;


public class Enemy extends GameEntity {
    private HashSet<Enemy> enemies = new HashSet<Enemy>();
    public Enemy(double x, double y){
        coordinate.x = x;
        coordinate.y = y;
    }
    public void draw(GraphicsContext gc, GameEntity entity){
        gc.setFill(Color.BLACK);
        gc.fillRect(entity.coordinate.getX(),entity.coordinate.getY(),25,25);
        //gc.drawImage(image,entity.getX(),entity.getY());
    }
    public void update(){
        coordinate.setX(coordinate.getX() + 1);
        coordinate.setY(coordinate.getY() + 1);
    }


    private void findPath(){

    }

    private boolean evaluate(){
        return true;
    }

}
