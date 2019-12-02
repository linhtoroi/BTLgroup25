package Main;

import Enemy.Enemy;
import GameEntity.Spawner;
import GameEntity.Tower.NormalTower;
import GameEntity.Tower.SniperTower;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
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


            Image sImage = new Image(("/AssetsKit_2/PNG/Retina/towerDefense_tile203.png"));
            ImageView sniperImage = new ImageView(sImage);
            sniperImage.setFitWidth(25);
            sniperImage.setFitHeight(25);
            sniperImage.setX(522);
            sniperImage.setY(150);
            root.getChildren().add(sniperImage);
            sniperImage.setOnMouseDragged(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    //System.out.println("10");
                    sniperImage.setY(mouseEvent.getY());
                    sniperImage.setX(mouseEvent.getX());
                }
            });
            sniperImage.setOnMouseReleased(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    //System.out.println("20");
                    MainController.createTower(root, mouseEvent.getX()/25, mouseEvent.getY()/25, 2);
                    //System.out.println(mouseEvent.getX()+"  "+mouseEvent.getY());
                    sniperImage.setX(522);
                    sniperImage.setY(150);
                }
            });



            Image nImage = new Image(("/AssetsKit_2/PNG/Retina/towerDefense_tile249.png"));
            ImageView nomalImage = new ImageView(nImage);
            nomalImage.setFitWidth(25);
            nomalImage.setFitHeight(25);
            nomalImage.setX(522);
            nomalImage.setY(100);
            root.getChildren().add(nomalImage);
            nomalImage.setOnMouseDragged(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    //System.out.println("10");
                    nomalImage.setY(mouseEvent.getY());
                    nomalImage.setX(mouseEvent.getX());
                }
            });
            nomalImage.setOnMouseReleased(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    //System.out.println("20");
                    MainController.createTower(root, mouseEvent.getX()/25, mouseEvent.getY()/25, 1);
                    //System.out.println(mouseEvent.getX()+"  "+mouseEvent.getY());
                    nomalImage.setX(522);
                    nomalImage.setY(100);
                }
            });



            Image mImage = new Image(("/AssetsKit_2/PNG/Retina/towerDefense_tile226.png"));
            ImageView machineGunImage = new ImageView(mImage);
            machineGunImage.setFitWidth(25);
            machineGunImage.setFitHeight(25);
            machineGunImage.setX(522);
            machineGunImage.setY(200);
            root.getChildren().add(machineGunImage);
            machineGunImage.setOnMouseDragged(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    //System.out.println("10");
                    machineGunImage.setY(mouseEvent.getY());
                    machineGunImage.setX(mouseEvent.getX());
                }
            });
            machineGunImage.setOnMouseReleased(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    //System.out.println("20");
                    MainController.createTower(root, mouseEvent.getX()/25, mouseEvent.getY()/25, 3);
                    //System.out.println(mouseEvent.getX()+"  "+mouseEvent.getY());
                    machineGunImage.setX(522);
                    machineGunImage.setY(200);
                }
            });




            final GameField field = new GameField();

            final GameDrawer drawer = new GameDrawer(gc,field);

            final NormalTower n = new NormalTower(200,230);
            Spawner spawner = new Spawner(80, 0);

            field.addEntity(spawner);
            field.addEntity(n);

            final long startNanoTime = System.nanoTime();
            new AnimationTimer()
            {
                public void handle(long currentNanoTime)
                {
                    gc.clearRect(0,0,500,450);
                    double t = (currentNanoTime - startNanoTime) / 1000000000.0;

                    field.update();
                    drawer.draw();

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
