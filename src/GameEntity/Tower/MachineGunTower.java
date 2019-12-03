package GameEntity.Tower;

import Bullet.Bullet;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class MachineGunTower extends Tower {
    public ImageView imageView;
    public MachineGunTower(double x, double y){
        super(x,y);
        coordinate.x = x*50;
        coordinate.y = y*50;
        image = new Image("/AssetsKit_2/PNG/Retina/towerDefense_tile226.png");
        imageView = new ImageView(image);
        imageView.setFitHeight(50);
        imageView.setFitWidth(50);
        imageView.setY(y*50);
        imageView.setX(x*50);
        Image imageBullet = new Image("/AssetsKit_2/PNG/Retina/towerDefense_tile295.png");
        bullet = new Bullet(x*50, y*50, imageBullet);
    }

    @Override
    public void shoot(GraphicsContext gc) {
        findEnemy(new Image("/AssetsKit_2/PNG/Retina/towerDefense_tile295.png"));
        if (target!= null){
            //phuong trinh duong thang giua dan va dich
            double deltaX = target.coordinate.x - coordinate.x;
            double deltaY = target.coordinate.y - coordinate.y;


            //tinh goc giua duong thang noi quan dich vs thap va ox
            double X = coordinate.y + (-coordinate.x / deltaX) * deltaY;
            double Y = coordinate.x + (-coordinate.y / deltaY) * deltaX;
            double angle = Math.atan(Y / X) / (Math.PI) * 180;
            if (target.coordinate.y > coordinate.y) {
                angle += 180;
            }
            imageView.setRotate(angle);
            /*double deltaX = target.coordinate.x - this.coordinate.x;
            double deltaY = target.coordinate.y - this.coordinate.y;
            double tata = deltaX / Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2));
            double degrees = Math.acos(tata);
            degrees = Math.toDegrees(degrees);
            System.out.println(deltaX + "   " + deltaY + "       " + tata + "        " + degrees);
            imageView.setRotate(degrees-270);*/
        }
        if (target.coordinate.distance(this.coordinate) < radius)
            bullet.update(gc);


    }
}
