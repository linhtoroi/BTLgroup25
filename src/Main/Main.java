package Main;

import GameEntity.*;
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
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.File;


public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try {

            primaryStage = new GameStage(900,1000);
            Parent root1 = FXMLLoader.load(getClass().getResource("Main.fxml"));
            Group root = new Group();
            root.getChildren().add(root1);
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            Canvas canvas = new Canvas(1000,900);
            root.getChildren().add(canvas);
            final GraphicsContext gc = canvas.getGraphicsContext2D();
            Mountain mountain = new Mountain();
            Road road = new Road();




            Image sImage = new Image(("/AssetsKit_2/PNG/Retina/towerDefense_tile203.png"));
            ImageView sniperImage = new ImageView(sImage);
            sniperImage.setFitWidth(50);
            sniperImage.setFitHeight(50);
            sniperImage.setX(1044);
            sniperImage.setY(300);
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
                    MainController.createTower(root, mouseEvent.getX()/50, mouseEvent.getY()/50, 2);
                    //System.out.println(mouseEvent.getX()+"  "+mouseEvent.getY());
                    sniperImage.setX(1044);
                    sniperImage.setY(300);
                }
            });



            Image nImage = new Image(("/AssetsKit_2/PNG/Retina/towerDefense_tile249.png"));
            ImageView nomalImage = new ImageView(nImage);
            nomalImage.setFitWidth(50);
            nomalImage.setFitHeight(50);
            nomalImage.setX(1044);
            nomalImage.setY(200);
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
                    MainController.createTower(root, mouseEvent.getX()/50, mouseEvent.getY()/50, 1);
                    //System.out.println(mouseEvent.getX()+"  "+mouseEvent.getY());
                    nomalImage.setX(1044);
                    nomalImage.setY(200);
                }
            });



            Image mImage = new Image(("/AssetsKit_2/PNG/Retina/towerDefense_tile226.png"));
            ImageView machineGunImage = new ImageView(mImage);
            machineGunImage.setFitWidth(50);
            machineGunImage.setFitHeight(50);
            machineGunImage.setX(1044);
            machineGunImage.setY(400);
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
                    for (int i = 0; i < mountain.mountain.size(); i++){
                        if (mountain.mountain.get(i).x == (int)mouseEvent.getX()/50 && mountain.mountain.get(i).y == (int)mouseEvent.getY()/50){
                            MainController.createTower(root, (int)mouseEvent.getX()/50, (int)mouseEvent.getY()/50, 3);
                            //System.out.println(mouseEvent.getX()+"  "+mouseEvent.getY());
                        }
                    }
                    machineGunImage.setX(1044);
                    machineGunImage.setY(400);

                }
            });


            GameField field = new GameField();
            SniperTower tower1 = new SniperTower(9,3);
            SniperTower tower2 = new SniperTower(2,10);
            MainController.towers.add(tower1);
            MainController.towers.add(tower2);
            root.getChildren().addAll(tower1.imageView, tower2.imageView);

            final long startNanoTime = System.nanoTime();

            Spawner spawner = new Spawner(160,0);
            spawner.spawn(field);
            spawner.update(field);

            // for playing background MUSIC

            MediaPlayer mediaPlayer = new MediaPlayer(Config.bgm);
            mediaPlayer.setVolume(0.3);
            mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
            mediaPlayer.play();

            new AnimationTimer()
            {
                public void handle(long currentNanoTime)
                {
                    gc.clearRect(0,0,1000,900);
                    if(Target.health <= 0) mediaPlayer.stop();
                    else{
                        // render and update
                        //double t = (currentNanoTime - startNanoTime) / 1000000000.0;
                        spawner.update(field);
                        for (int i = 0; i < MainController.towers.size(); i++){
                            MainController.towers.get(i).shoot(gc);
                        }
                        for (int i = 0; i < MainController.enemy.size(); i++){
                            MainController.enemy.get(i).update();
                            if (MainController.enemy.get(i).isDestroy())  MainController.enemy.remove(i);
                            else MainController.enemy.get(i).draw(gc);
                        }
                        Target.drawHealthbar(gc);
                    }
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




/*Image image = new Image(("/AssetsKit_2/PNG/Retina/towerDefense_tile231.png"));
            ImageView startImage = new ImageView(image);
            startImage.setFitWidth(94);
            startImage.setFitHeight(41);
            Button startButton = new Button("Pause");
            root.getChildren().add(startButton);
            startButton.setLayoutX(1044.0);
            startButton.setLayoutY(377);
            Stage finalPrimaryStage = primaryStage;
            startButton.setOnAction(actionEvent -> {
                StackPane layout = new StackPane();
                Scene scene2 = new Scene(layout, 900, 1000);
                finalPrimaryStage.setScene(scene2);
            });*/
//MainController.hihi(primaryStage);
//MainController.Pause(new ActionEvent(), primaryStage);