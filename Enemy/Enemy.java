package Enemy;

import GameEntity.GameEntity;
import GameEntity.Road;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.HashSet;


public class Enemy extends GameEntity {
    private HashSet<Enemy> enemies = new HashSet<Enemy>();
    private int mm;
    public Enemy(double x, double y){
        coordinate.x = x;
        coordinate.y = y;
        mm = 0;
    }
    public void draw(GraphicsContext gc, GameEntity entity){
        gc.setFill(Color.BLACK);
        gc.fillRect(entity.coordinate.getX(),entity.coordinate.getY(),50,50);
        //gc.drawImage(image,entity.getX(),entity.getY());
    }
    public void update(Road road){
        /*if(mm < road.road.size()) {
            coordinate.setX(road.road.get(mm).x);
            coordinate.setY(road.road.get(mm).y);
            mm++;
        }*/
        coordinate.setX(coordinate.x + 1);
        coordinate.setY(coordinate.y + 1);

    }
    public boolean Outmap(){
        if (this.coordinate.x > 1000 || this.coordinate.y < 900)
            return true;
        return false;
    }

    private void findPath(){

    }

    private boolean evaluate(){
        return true;
    }

}
