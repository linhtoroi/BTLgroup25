package Enemy;

import GameEntity.Config;
import javafx.scene.Group;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Created with IntelliJ IDEA.
 * User: Incognito
 * Date: 12/2/19
 * Time: 2:52 PM
 * To change this template use File | Settings | File Templates.
 */
public class BossEnemy extends Enemy {
    public BossEnemy(double x, double y) {
        super(x, y);
        health = Config.BOSS_ENEMY_HEALTH;
        armor = Config.BOSS_ENEMY_ARMOR;
        speed = Config.BOSS_ENEMY_SPEED;
        reward = Config.BOSS_ENEMY_REWARD;
    }

    @Override
    public void draw(Group root, GraphicsContext gc) {
        image = new Image("");
        imageView = new ImageView(image);
        imageView = new ImageView(image);
        imageView.setFitHeight(50);
        imageView.setFitWidth(50);
        imageView.setY(coordinate.y);
        imageView.setX(coordinate.x - 10);
        root.getChildren().add(imageView);
    }
}