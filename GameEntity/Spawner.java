package GameEntity;

import Enemy.Enemy;
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
    private float time_between_wave = 20;
    private float countt;

    //private int waves = 0;
    //private int enemy_per_wave = 6;


    public Spawner(double x, double y) {
        coordinate.setX(x);
        coordinate.setY(y);
        countt = 0;
    }

    public void update(){
        count_down--;
        if(count_down <= 0 && countt < 10) {
            spawn();
            count_down = time_between_wave;
            countt++;
        }
    }

    public static void spawn(){

        //waves++;
        //for(int i = 0; i < enemy_per_wave; i++) {
//             double x = new Random((long)coordinate.getX() * 25).nextDouble() + 1;       khong random dc
//             double y = new Random((long)coordinate.getY() * 25).nextDouble() + 1;
        double x = 3 ;
        double y = 0;
        MainController.enemy.add(new Enemy(x,y));
        //System.out.println(x );
        //}
    }

    public void draw(GraphicsContext gc) {

    }
}