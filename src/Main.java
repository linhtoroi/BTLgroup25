/**
 * Created with IntelliJ IDEA.
 * User: Incognito
 * Date: 11/8/19
 * Time: 7:57 PM
 * To change this template use File | Settings | File Templates.
 */
import entity.bullet.Bullet;
import entity.enemy.Enemy;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Main extends Application
{
    public static void main(String[] args)
    {
        launch(args);
    }

    public void start(Stage theStage)
    {
        theStage = new GameStage();

        Group root = new Group();
        Scene theScene = new Scene( root );
        theStage.setScene( theScene );

        Canvas canvas = new Canvas(500,500);
        root.getChildren().add(canvas);

        final GraphicsContext gc = canvas.getGraphicsContext2D();

        GameField field = new GameField();
        final Enemy enemy = new Enemy();
        //GameDrawer drawer = new GameDrawer(gc,field);
        final Bullet bullet = new Bullet(0,250,enemy);
        final long startNanoTime = System.nanoTime();
        new AnimationTimer()
        {
            public void handle(long currentNanoTime)
            {
                gc.drawImage(new Image("Image/Untitled.png"),0,0);
                double t = (currentNanoTime - startNanoTime) / 1000000000.0;
                enemy.update();
                bullet.update();
                bullet.draw(gc,bullet);
               enemy.draw(gc,enemy);
            }
        }.start();



        theStage.show();
    }
}
