package Collision;



import Bullet.Bullet;
import Enemy.Enemy;

/**
 * Created with IntelliJ IDEA.
 * User: Incognito
 * Date: 11/16/19
 * Time: 9:43 AM
 * To change this template use File | Settings | File Templates.
 */
public class Collision {
    private static final double collision_range = 10;
    public static boolean isCollide(Enemy e1, Bullet e2) {
        if(e1 == null || e2 == null) return false;
        if (e1.coordinate.distance(e2.coordinate) < collision_range) return true;
        return false;
    }




}

