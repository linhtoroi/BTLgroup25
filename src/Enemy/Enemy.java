package Enemy;

import GameEntity.Target;
import GameEntity.GameEntity;
import Main.GameStage;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import GameEntity.Point;
import GameEntity.Config;
public abstract class Enemy extends GameEntity {
    protected Point p = new Point(0,0);

    protected final Point[] DELTA_DIRECTION_ARRAY =
            {new Point(0.0, -1.0), new Point(0.0, 1.0), new Point(-1.0, 0.0), new Point(1.0, 0.0)};

    protected long health;
    protected long armor;
    protected double speed;
    protected long reward;

    protected boolean isDestroy = false;

    public Enemy(){
        coordinate.x = 0;
        coordinate.y = 0;
    }

    public Enemy(double x, double y){
        coordinate.x = x;
        coordinate.y = y;
    }

    public void draw(GraphicsContext gc){
        gc.setFill(Color.BLACK);
        gc.fillRect(coordinate.getX(),coordinate.getY(),10,10);
        //health bars
        gc.setFill(Color.RED);
        gc.fillRect(coordinate.getX(),coordinate.getY() - 2,10*health/100, 2);
    }
    public void update(){
        if(isDestroy()) return;
        if(health <= 0) {
            doDestroy();
            return;
        }
        Point u = findPath();
        if(p.getX() + u.getX() == 0 && p.getY() + u.getY() == 0) u = p;
        else p = u;
        //if(u == null)System.out.print("dfasldjf");
        coordinate.x += u.getX() * speed;
        coordinate.y += u.getY() * speed;
    }


    private Point findPath(){
        int col = (int) coordinate.x / Config.TILE_SIZE ;
        int row = (int) coordinate.y / Config.TILE_SIZE ;
        int[][] a = GameStage.Map;
            if(a[row][col] == 4 && coordinate.x <= 0) {
                Target.health --;
                doDestroy();
            }
            if(a[row + 1][col] == 1 ) {
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

    public void doDestroy() {
           isDestroy = true;
    }

    public boolean isDestroy() {
        return isDestroy;
    }

    public boolean Outmap() {
        return coordinate.x < 900 && coordinate.y < 1000;
    }

    public long getHealth() {
        return health;
    }

    public void setHealth(long health) {
        this.health = health;
    }

    public void damaged(long strength) {
        health -= strength;
    }
}
