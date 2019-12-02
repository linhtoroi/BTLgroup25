package Bullet;
//import entity.Collision;
//import entity.GameEntity;
//import entity.enemy.Enemy;
import Enemy.Enemy;
import GameEntity.GameEntity;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import Collision.Collision;


public class Bullet extends GameEntity {
    private boolean isDestroy;
    private final double speed = 20;
    private double deltaX, deltaY;
    //private double distance;
    private Enemy target;

    public  Bullet(){

    }
    public Bullet(double x, double y, Image imageBullet) {
        image = imageBullet;
        coordinate.x = x;
        coordinate.y = y;
        target = null;
        isDestroy = false;
    }
    public Bullet(double x, double y, Enemy target) {
        coordinate.x = x;
        coordinate.y = y;
        this.target = target;
        isDestroy = false;
    }


    public void update(GraphicsContext gc) {
        if(isDestroy) return;
        if(target!=null) {
            calculate();
            coordinate.x = coordinate.x + deltaX * speed/coordinate.distance(target.coordinate);
            coordinate.y = coordinate.y + deltaY * speed/coordinate.distance(target.coordinate);
            gc.drawImage(image, coordinate.x, coordinate.y,50,50);
            if(Collision.isCollide(target, this)) doDestroy();
        }
        if (coordinate.x < 0 || coordinate.y < 0 || coordinate.x > 1000 || coordinate.y > 900)
            doDestroy();
    }

    private void calculate() {
        deltaX = target.coordinate.x - this.coordinate.x;
        deltaY = target.coordinate.y - this.coordinate.y;
    }

    public void doDestroy() {
        isDestroy = true;
    }

    public boolean isDestroyed() {
        return isDestroy;
    }

    public Enemy getTarget() {
        return target;
    }

    public void setTarget(Enemy target) {
        this.target = target;
    }

}