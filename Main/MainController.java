package Main;

import javafx.scene.Group;

import javax.swing.*;
import java.util.ArrayList;

public class MainController {
    public static ArrayList<Tower> towers = new ArrayList<Tower>();
    public void createTower(Group root){
        SniperTower tower1 = new SniperTower(3,3);
        SniperTower tower2 = new SniperTower(4,3);
        towers.add(tower1);
        towers.add(tower2);
        root.getChildren().addAll(tower1.imageView,tower2.imageView);
    }
}
