package GameEntity.Tower;

import Bullet.Bullet;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class MachineGunTower extends Tower {
    public ImageView imageView;
    public MachineGunTower(double x, double y){
        super(x,y);
        coordinate.x = x;
        coordinate.y = y;
        image = new Image("/AssetsKit_2/PNG/Retina/towerDefense_tile226.png");
        imageView = new ImageView(image);
        imageView.setFitHeight(25);
        imageView.setFitWidth(25);
        imageView.setY(y*25);
        imageView.setX(x*25);
        Image imageBullet = new Image("/AssetsKit_2/PNG/Retina/towerDefense_tile295.png");
        bullet = new Bullet(x*25, y*25, imageBullet);
    }

    @Override
    public void shoot(GraphicsContext gc) {
        findEnemy(new Image("/AssetsKit_2/PNG/Retina/towerDefense_tile295.png"));

        if (target.coordinate.distance(this.coordinate) < radius)
            bullet.update(gc);


    }
}
