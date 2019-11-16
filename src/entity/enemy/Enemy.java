package entity.enemy;

import entity.GameEntity;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

import java.util.HashSet;

/**
 * Created with IntelliJ IDEA.
 * User: Incognito
 * Date: 11/12/19
 * Time: 9:43 PM
 * To change this template use File | Settings | File Templates.
 */
public class Enemy extends GameEntity{
    private HashSet<Enemy> enemies = new HashSet<Enemy>();
    public void draw(GraphicsContext gc, GameEntity entity){
        gc.setFill(Color.BLACK);
        gc.fillRect(entity.getX(),entity.getY(),50,50);
        //gc.drawImage(image,entity.getX(),entity.getY());
    }
    public  void update(){
        x += 1;
        y += 1;
    }


    private void findPath(){

    }

    private boolean evaluate(){
        return true;
    }

}
