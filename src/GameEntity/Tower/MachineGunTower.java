package GameEntity.Tower;

import Bullet.Bullet;
import GameEntity.Config;
import javafx.scene.Group;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class MachineGunTower extends Tower {

    public MachineGunTower(double x, double y){
        super(x,y);
        radius = Config.MACHINE_GUN_TOWER_RANGE;
        speed = Config.MACHINE_GUN_TOWER_SPEED;
        image = new Image("/AssetsKit_2/PNG/Retina/towerDefense_tile226.png");
        imageView = new ImageView(image);
        imageView.setFitHeight(50);
        imageView.setFitWidth(50);
        imageView.setY(y*50);
        imageView.setX(x*50);
        imageBullet = new Image("/AssetsKit_2/PNG/Retina/towerDefense_tile295.png");
        bullet = new Bullet(x*50, y*50, imageBullet);
        price = Config.MACHINE_GUN_TOWER_PRICE;
    }

    @Override
    public void shoot(GraphicsContext gc, Group root) {
        if (countSpeed < speed){
            super.shoot(gc, root);
            countSpeed++;
        }
        else {
            countSpeed = 0;
        }
    }

    @Override
    public void upgrade(int newGrade, Group root){
        speed += 5;
        radius += 50;
        if (newGrade == 1){
            image = new Image("/AssetsKit_2/PNG/Retina/towerDefense_tile227.png");
            root.getChildren().remove(imageView);
            imageView = new ImageView(image);
            imageView.setFitHeight(50);
            imageView.setFitWidth(50);
            imageView.setY(coordinate.y);
            imageView.setX(coordinate.x);
            root.getChildren().add(imageView);
            this.grade = newGrade;
            System.out.println("day");
        }
        else if (newGrade == 2){
            image = new Image("/AssetsKit_2/PNG/Retina/towerDefense_tile228.png");
            root.getChildren().remove(imageView);
            imageView = new ImageView(image);
            imageView.setFitHeight(50);
            imageView.setFitWidth(50);
            imageView.setY(coordinate.y);
            imageView.setX(coordinate.x);
            root.getChildren().add(imageView);
            this.grade = newGrade;
            System.out.println("day");
        }
    }
}
