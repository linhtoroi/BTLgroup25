package GameEntity.Tower;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class SniperTower extends Tower {
    public ImageView imageView;
    public SniperTower(double x, double y){
        super(x,y);
        coordinate.x = x;
        coordinate.y = y;
        image = new Image("/AssetsKit_2/PNG/Retina/towerDefense_tile205.png");
        imageView = new ImageView(image);
        imageView.setFitHeight(25);
        imageView.setFitWidth(25);
        imageView.setY(y*25);
        imageView.setX(x*25);
    }

    @Override
    public void shoot(GraphicsContext gc) {
        findEnemy();
        if (bullet.isDestroyed() == false)
            bullet.update(gc);
        /*long startNanoTime = System.nanoTime();
        int i = 0;
        while(i < 10){
            if (System.nanoTime() - startNanoTime > 1000000000.0) {
                startNanoTime = System.nanoTime();
                bullet.get(i).update(gc);
                i++;
            }
        }*/

    }
}
