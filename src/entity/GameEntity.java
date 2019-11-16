package entity;
import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: Incognito
 * Date: 11/8/19
 * Time: 8:29 PM
 * To change this template use File | Settings | File Templates.
 */
public abstract class GameEntity {
    protected double x;
    protected double y;

    public GameEntity(){
        x = 0;
        y = 0;
    }

    public GameEntity(double x, double y){
        this.x = x;
        this.y = y;
    }

    public double distanceSq(GameEntity e) {
        double x = e.getX();
        double y = e.getY();
        return (x - this.x)*(x - this.x) + (y - this.y)*(y - this.y);
    }

    public double distance(GameEntity e){
        return Math.sqrt(distanceSq(e));
    }

    public abstract void draw(GraphicsContext gc, GameEntity entity);

    public abstract void update();

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}
