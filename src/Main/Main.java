package Main;

import Enemy.Enemy;
import GameEntity.Config;
import GameEntity.Mountain;
import GameEntity.Road;
import GameEntity.Spawner;
import GameEntity.Tower.SniperTower;
import GameEntity.Tower.Tower;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;


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
            GameField field = new GameField();
            Label money = new Label();
            money.setLayoutX(1029);
            money.setLayoutY(77);
            money.setFont(Font.font(null, 20));
            money.setBorder(new Border(new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.EMPTY)));
            //money.setBorder(new Border(new BorderStroke()));
            money.setTextFill(Color.WHITE);
            money.setTextAlignment(TextAlignment.CENTER);
            Label lives = new Label();
            lives.setLayoutX(1032);
            lives.setLayoutY(167);
            lives.setTextFill(Color.WHITE);
            //lives.setPrefSize(90, 20);
            lives.setFont(Font.font(null, 20));
            //lives.setTextAlignment(TextAlignment.CENTER);
            Label mgPrice = new Label();
            mgPrice.setLayoutX(1029);
            mgPrice.setLayoutY(437);
            mgPrice.setTextFill(Color.WHITE);
            mgPrice.setFont(Font.font(null, 20));
            mgPrice.setTextAlignment(TextAlignment.CENTER);
            mgPrice.setText(Config.SNIPER_TOWER_PRICE+"");
            Label sPrice = new Label();
            sPrice.setLayoutX(1032);
            sPrice.setLayoutY(347);
            sPrice.setTextFill(Color.WHITE);
            sPrice.setFont(Font.font(null, 20));
            sPrice.setTextAlignment(TextAlignment.CENTER);
            sPrice.setText(Config.MACHINE_GUN_TOWER_PRICE+"");
            Label nPrice = new Label();
            nPrice.setLayoutX(1032);
            nPrice.setLayoutY(257);
            nPrice.setTextFill(Color.WHITE);
            nPrice.setFont(Font.font(null, 20));
            nPrice.setTextAlignment(TextAlignment.CENTER);
            nPrice.setText(Config.NORMAL_TOWER_PRICE+"");
            root.getChildren().addAll(money, lives, nPrice, sPrice, mgPrice);

            MainController.useDragRelaese(root,mountain);


            final long startNanoTime = System.nanoTime();

            Spawner spawner = new Spawner(3,0);
            //spawner.spawn();
            //spawner.update();

            new AnimationTimer()
            {
                public void handle(long currentNanoTime)
                {
                    gc.clearRect(0,0,1000,900);
                    double t = (currentNanoTime - startNanoTime) / 1000000000.0;
                    //MainController.up(root);
                    MainController.setRadius(root);

                    spawner.update();
                    if (MainController.towers.size()>0)
                        for (int i = 0; i < MainController.towers.size(); i++){
                            MainController.towers.get(i).shoot(gc, root);
                        }
                    for (int i = 0; i < MainController.enemy.size(); i++){
                        MainController.enemy.get(i).update(root);
                        MainController.enemy.get(i).draw(root, gc);
                    }
                    money.setText(MainController.money+"");
                    lives.setText(MainController.lives+"");
                    MainController.setRadius(root);
                    //MainController.DeleteEnemy();
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
/* SniperTower tower1 = new SniperTower(9,3);
            SniperTower tower2 = new SniperTower(2,10);
            MainController.towers.add(tower1);
            MainController.towers.add(tower2);
            root.getChildren().addAll(tower1.imageView, tower2.imageView);*/
//MainController.up(root);



/*

            if (MainController.towers.size()>0){
                SplitPane group = new SplitPane();
                Button upgrade = new Button("Upgrade");
                Button cancel = new Button("Cancel");
                MainController.towers.get(0).imageView.setOnMouseClicked(new EventHandler<MouseEvent>(){
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        System.out.println("hehe");
                        group.getItems().addAll(upgrade,cancel);
                        group.setLayoutX(MainController.towers.get(0).coordinate.x + 50);
                        group.setLayoutY(MainController.towers.get(0).coordinate.y);
                        root.getChildren().add(group);
                    }
                });
                upgrade.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        System.out.println("hihi");
                    }
                });
                cancel.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        System.out.println("haha");
                    }
                });
            }


*/