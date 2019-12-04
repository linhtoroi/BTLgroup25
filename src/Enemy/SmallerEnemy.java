package Enemy;

import GameEntity.Config;
import javafx.scene.Group;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

/**
 * Created with IntelliJ IDEA.
 * User: Incognito
 * Date: 12/2/19
 * Time: 2:51 PM
 * To change this template use File | Settings | File Templates.
 */
public class SmallerEnemy extends Enemy {
    public SmallerEnemy(double x, double y) {
        super(x, y);
        health = Config.SMALLER_ENEMY_HEALTH;
        armor = Config.SMALLER_ENEMY_ARMOR;
        speed = Config.SMALLER_ENEMY_SPEED;
        reward = Config.SMALLER_ENEMY_REWARD;
    }
    @Override
    public void draw(Group root, GraphicsContext gc) {
        if(root.getChildren().contains(imageView)) root.getChildren().remove(imageView);
        image = new Image("/AssetsKit_2/PNG/Retina/towerDefense_tile245.png");
        imageView = new ImageView(image);
        imageView.setFitHeight(100);
        imageView.setFitWidth(100);
        imageView.setY(coordinate.y);
        imageView.setX(coordinate.x);
        root.getChildren().add(imageView);
        //health bars
        gc.setFill(Color.RED);
        gc.fillRect(coordinate.getX(),coordinate.getY() - 2,10*health/10, 2);
    }
}