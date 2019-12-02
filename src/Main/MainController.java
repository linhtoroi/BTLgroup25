package Main;

import Enemy.Enemy;
import GameEntity.Spawner;
import GameEntity.Tower.MachineGunTower;
import GameEntity.Tower.NormalTower;
import GameEntity.Tower.SniperTower;
import GameEntity.Tower.Tower;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


import java.util.ArrayList;

public class MainController {
    public static ArrayList<Tower> towers = new ArrayList<Tower>();
    public static ArrayList<Enemy> enemy = new ArrayList<>();

//    public static void createEnemy(double x, double y){
//        Spawner spawner = new Spawner(x,y);
//        spawner.spawn();
//        spawner.update();
//    }

    public static void createTower(Group root, double x, double y, int kind){
        if (kind == 2) {
            SniperTower tower2 = new SniperTower(x, y);
            MainController.towers.add(tower2);
            root.getChildren().addAll(tower2.imageView);
        }
        else if (kind == 1) {
            NormalTower tower1 = new NormalTower(x, y);
            MainController.towers.add(tower1);
            root.getChildren().addAll(tower1.imageView);
        }
        else if (kind == 3){
            MachineGunTower tower3 = new MachineGunTower(x, y);
            MainController.towers.add(tower3);
            root.getChildren().addAll(tower3.imageView);
        }
    }
//    public static void hihi(Stage stage){
//        // MainController mainController = new MainController();
//        //mainController
//        Pause(new ActionEvent(), stage);
//    }

    @FXML
    Button start;
    @FXML
    public static Button pause;

    public void Start(ActionEvent ac){
        Spawner spawner = new Spawner(2, 3);
//        spawner.spawn();
//        spawner.update();
    }

    public static void Pause(ActionEvent ac, Stage stage){
        pause.setOnAction(actionEvent -> {
            StackPane layout = new StackPane();
            Scene scene = new Scene(layout, 450, 500);
            stage.setScene(scene);
        });
    }
}
