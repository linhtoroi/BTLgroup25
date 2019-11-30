package Main;

import Enemy.Enemy;
import GameEntity.Spawner;
import GameEntity.Tower.SniperTower;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try {

            primaryStage = new GameStage(450,500);
            Parent root1 = FXMLLoader.load(getClass().getResource("Main.fxml"));
            Group root = new Group();
            root.getChildren().add(root1);
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            Canvas canvas = new Canvas(500,450);
            root.getChildren().add(canvas);

            final GraphicsContext gc = canvas.getGraphicsContext2D();

            final GameField field = new GameField();

            final GameDrawer drawer = new GameDrawer(gc,field);

            Spawner spawner = new Spawner(25, - 25);

            field.addEntity(spawner);


//            Enemy enemy = new Enemy(0,0);
//            MainController.enemy.add(enemy);
//
//            MainController.createEnemy();
//            MainController.createTower(root);

            final long startNanoTime = System.nanoTime();
            new AnimationTimer()
            {
                public void handle(long currentNanoTime)
                {
                    gc.clearRect(0,0,500,450);
                    double t = (currentNanoTime - startNanoTime) / 1000000000.0;

                    field.update();
                    drawer.draw();
//                    for (int i = 0; i < MainController.towers.size(); i++){
//                        MainController.towers.get(i).shoot(gc);
//                    }
//                    enemy.update();
//                    enemy.draw(gc);




                }
            }.start();
            primaryStage.show();
        }
        catch (Exception e) {
            System.out.println("Ex");
            e.printStackTrace();
        }
    }
}
