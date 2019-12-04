package GameEntity;

import Enemy.Enemy;
import Enemy.NormalEnemy;
import Enemy.SmallerEnemy;
import Main.GameField;
import Main.MainController;
import javafx.scene.canvas.GraphicsContext;
/**
 * Created with IntelliJ IDEA.
 * User: Incognito
 * Date: 11/30/19
 * Time: 3:10 PM
 * To change this template use File | Settings | File Templates.
 */
public class Spawner extends GameEntity {
    private float count_down = 10;
    private float time_between_enemy = 20;
    private float time_between_wave = 200;
    private float countt;
    private int waves = 0;
    private int enemy_per_wave = 6;

    //private int waves = 0;
    //private int enemy_per_wave = 6;


    public Spawner(double x, double y) {
        coordinate.setX(x);
        coordinate.setY(y);
        countt = 0;
    }
    public void update(){//GameField field){
        count_down--;
        if(count_down <= 0) {
            spawn();
            enemy_per_wave--;
            if(enemy_per_wave == 0) {
                count_down = time_between_wave;
                enemy_per_wave = 6;
                waves++;
            }
            else count_down = time_between_enemy;
        }
    }


    public void spawn(){//GameField field){
//        int X = (int)coordinate.x/25;
//        double x = (double)X * 25 + Math.random()*25 + 1 ;
        double x = coordinate.x;
        double y = coordinate.y;

        //field.entities.add(new NormalEnemy(x,y));
        MainController.enemy.add(new SmallerEnemy(x,y));
        //}
    }

    public void draw(GraphicsContext gc) {

    }
}
/* public void update(){
        count_down--;
        if(count_down <= 0 && countt < 10) {
            spawn();
            count_down = time_between_wave;
            countt++;
        }
    }*/