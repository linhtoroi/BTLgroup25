package entity.bullet;
import entity.Collision;
import entity.GameEntity;
import entity.enemy.Enemy;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

/**
 * Created with IntelliJ IDEA.
 * User: Incognito
 * Date: 11/13/19
 * Time: 10:09 PM
 * To change this template use File | Settings | File Templates.
 */
public class Bullet extends GameEntity {
    private boolean isDestroy = true;
    private final double speed = 5;
    private double deltaX,deltaY;
    private double distance;
    private Enemy target;
    public Bullet(double x, double y,Enemy target){
        super(x, y);
        this.target = target;
        isDestroy = false;
    }

    public void draw(GraphicsContext gc, GameEntity entity){
        if(!isDestroyed()) {
            gc.setFill(Color.RED);
            gc.fillOval(entity.getX(),entity.getY(),10,10);
        }
    }

    public void update(){
        if(isDestroy) return;
        calculate();
        x =  x + deltaX*speed/distance(target);
        y = y + deltaY*speed/distance(target);
        if(Collision.isCollide(target, this)) doDestroy();
    }

    private void calculate(){
        deltaX = target.getX() - this.x;
        deltaY = target.getY() - this.y;
     // x  = x0 + deltaX/distance*speed    u = deltaX/distance
    }

    public void doDestroy(){
        isDestroy = true;
    }

    public boolean isDestroyed(){
        return isDestroy;
    }
}
