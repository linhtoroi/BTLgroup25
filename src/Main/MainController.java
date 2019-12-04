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



    public static void createTower(Group root, double x, double y, int kind){
        if (kind == 2) {
            SniperTower tower2 = new SniperTower(x, y);
            MainController.towers.add(tower2);
           /* Circle circle = new Circle();
            circle.setRadius(200);
            circle.setFill(Color.BLACK);
            circle.setOpacity(0.5);
            System.out.println(x+ "   " + y);
            circle.setCenterX(x*25+12.5);
            circle.setCenterY(y*25+12.5);*/
            root.getChildren().addAll(tower2.imageView);
        }
        else if (kind == 1) {
            NormalTower tower1 = new NormalTower(x, y);
            MainController.towers.add(tower1);
            root.getChildren().add(tower1.imageView);
        }
        else if (kind == 3){
            MachineGunTower tower3 = new MachineGunTower(x, y);
            MainController.towers.add(tower3);
            root.getChildren().add(tower3.imageView);
        }
    }
    public static void hihi(Stage stage){
       // MainController mainController = new MainController();
        //mainController
                Pause(new ActionEvent(), stage);
    }
    public static void DeleteEnemy(){
        if (enemy.size() != 0)
            for (int i = 0; i < enemy.size(); i++){
                if (enemy.get(i).Outmap())
                   enemy.remove(i);
            }
    }

    @FXML
    Button start;
    @FXML
    public static Button pause;

    public void Start(ActionEvent ac){
        Spawner spawner = new Spawner(2, 3);
        spawner.spawn(new GameField());
        spawner.update(new GameField());
    }

    public static void Pause(ActionEvent ac, Stage stage){
        pause.setOnAction(actionEvent -> {
            StackPane layout = new StackPane();
            Scene scene = new Scene(layout, 900, 1000);
            stage.setScene(scene);
        });
    }
}
