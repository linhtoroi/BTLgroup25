package Main;

import Enemy.Enemy;
import GameEntity.Mountain;
import GameEntity.Spawner;
import GameEntity.Tower.MachineGunTower;
import GameEntity.Tower.NormalTower;
import GameEntity.Tower.SniperTower;
import GameEntity.Tower.Tower;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.stage.Window;
import jdk.jshell.Snippet;


import java.awt.*;
import java.util.ArrayList;

public class MainController {
    public static ArrayList<Tower> towers = new ArrayList<Tower>();
    public static ArrayList<Enemy> enemy = new ArrayList<>();
    public static int countOfClick = 0;
    public static long money = 100;
    public static int lives = 20;
    //@FXML
    //ImageView upgrade;
    //@FXML
    //ImageView cancel;

    public static void createEnemy(GameField field, double x, double y){
        Spawner spawner = new Spawner(x,y);
        spawner.spawn();
        spawner.update();
    }

    public static void createTower(Group root, double x, double y, int kind){
        if (kind == 2 && money >= 100) {
            SniperTower tower2 = new SniperTower(x, y);
            MainController.towers.add(tower2);
            root.getChildren().addAll(tower2.imageView);
            money -= 100;
        }
        else if (kind == 1 && money >= 30) {
            NormalTower tower1 = new NormalTower(x, y);
            MainController.towers.add(tower1);
            root.getChildren().add(tower1.imageView);
            money -= 30;
        }
        else if (kind == 3 && money >= 200){
            MachineGunTower tower3 = new MachineGunTower(x, y);
            MainController.towers.add(tower3);
            root.getChildren().add(tower3.imageView);
            money -= 200;
        }
    }
    public static void hihi(Stage stage){
       // MainController mainController = new MainController();
        //mainController
                //Pause(new ActionEvent(), stage);
    }
    public static void DeleteEnemy(){
        if (enemy.size() != 0)
            for (int i = 0; i < enemy.size(); i++){
                if (enemy.get(i).Outmap())
                   enemy.remove(i);
            }
    }
    public static void radiusOfTower(Tower tower, Group root){
        tower.circle.setRadius(tower.getRadius());
        //tower.circle.setFill(Color.BLACK);
        tower.circle.setOpacity(0.3);
        //System.out.println(x+ "   " + y);
        tower.circle.setCenterX(tower.coordinate.x  + 25);
        tower.circle.setCenterY(tower.coordinate.y + 25);
        VBox group = new VBox();
        tower.imageView.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                root.getChildren().add(tower.circle);
                //System.out.println(0);
            }
        });
        tower.circle.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                root.getChildren().remove(tower.circle);
                //root.getChildren().remove(group);
                //System.out.println(0);
            }
        });
        tower.circle.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                //if (mouseEvent.isPrimaryButtonDown())
                //buttonOfTower(tower,root,group);
                button(tower,root,group);

            }
        });
    }




    public static void button(Tower tower, Group root, VBox group){

        ImageView upgrade = new ImageView(new Image("/AssetsKit_2/PNG/Retina/towerDefense_tile043.png"));
        ImageView sell = new ImageView(new Image("/AssetsKit_2/PNG/Retina/towerDefense_tile044.png"));
        sell.setFitHeight(90);
        sell.setFitWidth(90);
        upgrade.setFitHeight(90);
        upgrade.setFitWidth(90);
        group.getChildren().addAll(sell, upgrade);

        group.setLayoutX(1000);
        group.setLayoutY(540);
        root.getChildren().add(group);
        sell.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                //System.out.println("hihi");
            }
        });
        upgrade.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                //System.out.println("hihi");
                if (tower.getGrade() < 2) {
                    System.out.println("day truoc");
                    tower.upgrade(tower.getGrade() + 1, root);

                }
                //group.getChildren().removeAll(upgrade,sell);
                root.getChildren().remove(group);
            }
        });
        sell.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                //System.out.println("hihi");
                //group.getChildren().removeAll(upgrade,sell);
                money += 50;
                root.getChildren().remove(tower.imageView);
                towers.remove(tower);
                root.getChildren().remove(group);
            }
        });
        /*cancel.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                //System.out.println("hihi");
                //group.getChildren().removeAll(upgrade,sell);
                root.getChildren().remove(group);
            }
        });
        /*tower.circle.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if(mouseEvent.isSecondaryButtonDown()) {
                    System.out.println("hihi");
                    //group.getChildren().removeAll(upgrade,sell);
                    root.getChildren().remove(group);
                }
            }
        });*/

    }


    public static void setRadius(Group root){
        if (towers.size()>0){
            for (int i = 0; i < towers.size(); i++){
                radiusOfTower(towers.get(i), root);
                //MainController.upgrade(towers.get(i), root);
            }
        }
    }
    public static void up(Group root){
        if (towers.size()>0){
            for (int i = 0; i < towers.size(); i++){
                //MainController.radiusOfTower(MainController.towers.get(i), root);
                //MainController.upgrade(towers.get(i), root, group);
            }
        }
    }






    public static void useDragRelaese(Group root, Mountain mountain){
        Image nImage = new Image(("/AssetsKit_2/PNG/Retina/towerDefense_tile249.png"));
        ImageView nomalImage = new ImageView(nImage);
        dragRelease(root,mountain,nomalImage,1);
        Image sImage = new Image(("/AssetsKit_2/PNG/Retina/towerDefense_tile203.png"));
        ImageView sniperImage = new ImageView(sImage);
        dragRelease(root,mountain,sniperImage,2);
        Image mImage = new Image(("/AssetsKit_2/PNG/Retina/towerDefense_tile226.png"));
        ImageView machineGunImage = new ImageView(mImage);
        dragRelease(root,mountain,machineGunImage,3);
    }


    public static void dragRelease(Group root, Mountain mountain, ImageView imageView, int kind){

        imageView.setFitWidth(50);
        imageView.setFitHeight(50);
        imageView.setX(1020);
        imageView.setY(kind*90 + 111);
        root.getChildren().add(imageView);
        imageView.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                //System.out.println("10");
                imageView.setY(mouseEvent.getY());
                imageView.setX(mouseEvent.getX());
            }
        });
        imageView.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                //System.out.println("20");
                for (int i = 0; i < mountain.mountain.size(); i++){
                    if (mountain.mountain.get(i).x == (int)mouseEvent.getX()/50 && mountain.mountain.get(i).y == (int)mouseEvent.getY()/50){
                        MainController.createTower(root, (int)mouseEvent.getX()/50, (int)mouseEvent.getY()/50, kind);
                        //System.out.println(mouseEvent.getX()+"  "+mouseEvent.getY());
                    }
                }
                //System.out.println(mouseEvent.getX()+"  "+mouseEvent.getY());
                imageView.setX(1020);
                imageView.setY(kind*90 + 111);
            }
        });
    }
















    @FXML
    Button start;
    @FXML
    public static Button pause;

    public void Start(ActionEvent ac){
        Spawner spawner = new Spawner(3, 0);
        spawner.spawn();
        spawner.update();
    }

    /*public static void Pause(ActionEvent ac, Stage stage){
        pause.setOnAction(actionEvent -> {
            StackPane layout = new StackPane();
            Scene scene = new Scene(layout, 900, 1000);
            stage.setScene(scene);
        });
    }*/

    @FXML
    Label moneyText;

    public void setMoneyText(){
        //moneyText = new TextField();
        moneyText = new Label();
        moneyText.setText(money+"");
    }
}




//Button ban dau viet de nang cap va ban sung
/* public static void buttonOfTower(Tower tower, Group root, VBox group){

        Button upgrade = new Button("Upgrade");
        Button sell = new Button("Sell");
        Button cancel = new Button("Cancel");
        //if (countOfClick == 0) {
            //
        //System.out.println("hjhsjkdafhsjdfh");
        group.getChildren().addAll(upgrade,sell, cancel);

        group.setLayoutX(tower.coordinate.x + 50);
        group.setLayoutY(tower.coordinate.y);
        root.getChildren().add(group);
        sell.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                //System.out.println("hihi");
            }
        });
        upgrade.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                //System.out.println("hihi");
                if (tower.getGrade() < 2) {
                    System.out.println("day truoc");
                    tower.upgrade(tower.getGrade() + 1, root);

                }
                //group.getChildren().removeAll(upgrade,sell);
                root.getChildren().remove(group);
            }
        });
        sell.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                //System.out.println("hihi");
                //group.getChildren().removeAll(upgrade,sell);
                money += 50;
                root.getChildren().remove(tower.imageView);
                towers.remove(tower);
                root.getChildren().remove(group);
            }
        });
        cancel.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                //System.out.println("hihi");
                //group.getChildren().removeAll(upgrade,sell);
                root.getChildren().remove(group);
            }
        });
        /*tower.circle.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if(mouseEvent.isSecondaryButtonDown()) {
                    System.out.println("hihi");
                    //group.getChildren().removeAll(upgrade,sell);
                    root.getChildren().remove(group);
                }
            }
        });
    */