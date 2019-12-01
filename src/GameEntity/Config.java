package GameEntity;

/**
 * Created with IntelliJ IDEA.
 * User: Incognito
 * Date: 11/28/19
 * Time: 11:09 AM
 * To change this template use File | Settings | File Templates.
 */
public class Config {
    public final static int TILE_SIZE = 25;
    public final static int TILE_HEIGHT = 500;
    public final static int TILE_WIDTH = 450;

//    private static final double SQRT_2 = Math.sqrt(2.0) / 2.0;
//    private static final double[][] DELTA_DIRECTION_ARRAY = {
//            {0.0, -1.0}, {0.0, 1.0}, {-1.0, 0.0}, {1.0, 0.0},
//            {-SQRT_2, -SQRT_2}, {SQRT_2, SQRT_2}, {SQRT_2, -SQRT_2}, {-SQRT_2, SQRT_2},
//    };
    public static final Point[] DELTA_DIRECTION_ARRAY =
            {new Point(0.0, -1.0), new Point(0.0, 1.0), new Point(-1.0, 0.0), new Point(1.0, 0.0)};
            //            {0.0, -1.0}, {0.0, 1.0}, {-1.0, 0.0}, {1.0, 0.0}

}
