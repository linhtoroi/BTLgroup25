package GameEntity;

import GameEntity.Point;
import Main.GameStage;

import java.util.ArrayList;
import java.util.List;

public class Road {
    List<Point> road = new ArrayList<Point>();
    public Road(){
        GameStage gs = new GameStage(400,470);
        for (int i = 0; i < 21; i++)
            for (int j = 0; j < 18; j++){
                if (gs.Map[i][j] == 1)
                    road.add(new Point(i,j));
            }
    }
}
