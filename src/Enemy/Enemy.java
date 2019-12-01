package Enemy;

import GameEntity.GameEntity;
import Main.GameStage;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import GameEntity.Config;
import GameEntity.Point;

public class Enemy extends GameEntity {
    private Point p = new Point(0,0);
    public final Point[] DELTA_DIRECTION_ARRAY =
            {new Point(0.0, -1.0), new Point(0.0, 1.0), new Point(-1.0, 0.0), new Point(1.0, 0.0)};
    //            {0.0, -1.0}, {0.0, 1.0}, {-1.0, 0.0}, {1.0, 0.0}

    private double speed = 3;

    public Enemy(double x, double y){
        coordinate.x = x;
        coordinate.y = y;
    }

    public Enemy(Point a) {
        coordinate = a;
    }

    public void draw(GraphicsContext gc){
        gc.setFill(Color.BLACK);
        gc.fillRect(coordinate.getX(),coordinate.getY(),10,10);
        //gc.drawImage(image,entity.getX(),entity.getY());
    }
    public void update(){
        Point u = findPath();
        if(p.getX() + u.getX() == 0 && p.getY() + u.getY() == 0) u = p;
        else p = u;
        //if(u == null)System.out.print("dfasldjf");
        coordinate.x += u.getX() * speed;
        coordinate.y += u.getY() * speed;
    }


    private Point findPath(){
        int col = (int) coordinate.x / 25 ;
        int row = (int) coordinate.y / 25 ;
        if(col < 0 || row < 0) return DELTA_DIRECTION_ARRAY[1];
        int[][] a = GameStage.Map;
            if(a[row + 1][col] == 1) {
                return DELTA_DIRECTION_ARRAY[1];   // di xuong
            }
            else {
                if(a[row][col + 1] == 1) {
                    return DELTA_DIRECTION_ARRAY[3];  // re phai
                }
                else {
                    if(a[row][col - 1] == 1) return DELTA_DIRECTION_ARRAY[2];  // re trai
                }
            }

        return DELTA_DIRECTION_ARRAY[1];
    }



}
