package GameEntity;

import Main.GameStage;

import java.util.ArrayList;
import java.util.List;

public class Mountain {
    List<Point> mountain = new ArrayList<Point>();
    public Mountain(){
        GameStage gs = new GameStage(400,470);
        for (int i = 0; i < 21; i++)
            for (int j = 0; j < 18; j++){
                if (gs.Map[i][j] == 0)
                    mountain.add(new Point(i,j));
            }
    }
}
