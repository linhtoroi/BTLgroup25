package Main;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class SniperTower extends Tower {
    public SniperTower(double x, double y){
        super(x,y);
        image = new Image("/AssetsKit_2/PNG/Retina/towerDefense_tile205.png");//towerDefense_tile249.png");
        imageView = new ImageView(image);
        imageView.setFitHeight(40);
        imageView.setFitWidth(40);
        imageView.setX(x*41);
        imageView.setY(y*43);

    }
}
