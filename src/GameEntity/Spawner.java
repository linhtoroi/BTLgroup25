package GameEntity;

import javafx.scene.canvas.GraphicsContext;
import Enemy.NormalEnemy;
import javafx.scene.paint.Color;

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
    private float time_between_wave = 1000;

    private int waves = 0;
    private int enemy_per_wave = 6;


    public Spawner(double x, double y) {
          coordinate.setX(x);
        coordinate.setY(y);

    }

    public void update(Main.GameField field){
        count_down--;
        if(count_down <= 0) {
            spawn(field);
            enemy_per_wave--;
            if(enemy_per_wave == 0) {
                count_down = time_between_wave;
                enemy_per_wave = 6;
                waves++;
            }
            else count_down = time_between_enemy;
        }
    }

    public void spawn(Main.GameField field){

        //waves++;
         //for(int i = 0; i < enemy_per_wave; i++) {
//          double x = new Random((long)coordinate.getX() * 25).nextDouble() + 1;       khong random dc
//          double y = new Random((long)coordinate.getY() * 25).nextDouble() + 1;
        int X = (int)coordinate.x/25;
        double x = (double)X * 25 + Math.random()*25 + 1 ;
        double y = coordinate.y;
        field.entities.add(new NormalEnemy(x,y));
        System.out.println(x );
         //}
    }

    public void draw(GraphicsContext gc) {

    }
}
