package Main;

import Enemy.Enemy;
import GameEntity.Tower.SniperTower;
import GameEntity.Tower.Tower;
import javafx.scene.Group;

import java.util.ArrayList;

public class MainController {
    public static ArrayList<Tower> towers = new ArrayList<Tower>();
    public static ArrayList<Enemy> enemy = new ArrayList<>();

    public static void createEnemy(){
        Enemy e = new Enemy(1,1);
        enemy.add(e);
    }

    public static void createTower(Group root){
        SniperTower tower1 = new SniperTower(10,9);
        //SniperTower tower2 = new SniperTower(10,9);
        towers.add(tower1);
        //towers.add(tower2);
        root.getChildren().addAll(tower1.imageView);//, tower2.imageView);
    }

    public static void createSpawner() {

    }
}
