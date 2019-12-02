package GameEntity.Tower;

import Bullet.Bullet;
import Enemy.Enemy;
import GameEntity.GameEntity;
import Main.MainController;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;


import java.util.ArrayList;
import java.util.List;

public abstract class Tower extends GameEntity {
    protected double radius;
    protected double speed;
    protected Bullet bullet;
    protected Enemy target;
    public ImageView imageView;
    public Image imageBullet;

    //public Circle circle;

    public Tower(double x, double y){
        speed = 2;
        radius = 200;

        //circle = new Circle();
    }

    abstract public void shoot(GraphicsContext gc);

    public void findEnemy(){
        double min = 500;//MainController.enemy.get(0).coordinate.distance(coordinate);
        target = MainController.enemy.get(0);
        bullet.setTarget(target);
        //if (target.coordinate.distance(coordinate) > radius) {
            for (int i = 1; i < MainController.enemy.size(); i++) {
                if (MainController.enemy.get(i).coordinate.distance(coordinate) < min) {
                    min = MainController.enemy.get(i).coordinate.distance(coordinate);
                    target = MainController.enemy.get(i);
                }
            }
            if (min <= radius) {
                bullet.setTarget(target);
            }
        //}

        if (bullet.isDestroyed() == true && (target.coordinate.distance(this.coordinate) < radius)) {
            bullet = new Bullet(coordinate.x, coordinate.y, imageBullet);
        }
    }

}



/*int i = 1;
            if (target.coordinate.x > coordinate.x || target.coordinate.y > coordinate.y) {
                target = MainController.enemy.get(i);
                i++;
                bullet.setTarget(target);
            }
         */

//System.out.println(bullet.coordinate.x +" "+ bullet.coordinate.y);



        /*for (int i = 0; i< 10; i++)
            bullet.get(i).setTarget(target);*/