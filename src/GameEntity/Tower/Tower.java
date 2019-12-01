package GameEntity.Tower;

import Bullet.Bullet;
import Enemy.Enemy;
import GameEntity.GameEntity;
import Main.MainController;
import javafx.scene.canvas.GraphicsContext;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public abstract class Tower extends GameEntity {
    protected double radius;
    protected double speed;
    //protected List<Bullet> bullet;
    protected Bullet bullet;
    protected Enemy target;
    public Tower(double x, double y){
        speed = 2;
        radius = 50;
        /*bullet = new ArrayList<Bullet>();
        for (int i = 0; i< 10; i++)
            bullet.add(new Bullet(x*25, y*25));*/
        bullet = new Bullet(x*25, y*25);
    }
    abstract public void shoot(GraphicsContext gc);
    public void findEnemy(){
        //double min = 500;
        /*for(int i = 0; i < MainController.enemy.size(); i++) {
            if (MainController.enemy.get(i).coordinate.distance(coordinate) < min) {
                min = MainController.enemy.get(i).coordinate.distance(coordinate);
                target = MainController.enemy.get(i);
            }
            if (min <= radius) {
                bullet.setTarget(target);
            }
        }*/

        target = MainController.enemy.get(0);
        bullet.setTarget(target);
        if (bullet.isDestroyed() == true && coordinate.distance(target.coordinate) < radius) {
            bullet = new Bullet(coordinate.x * 25, coordinate.y *  25);
        }

        /*for (int i = 0; i< 10; i++)
            bullet.get(i).setTarget(target);*/
    }

}
