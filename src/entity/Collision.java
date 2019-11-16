package entity;
import entity.GameEntity;
import entity.bullet.Bullet;
import entity.enemy.Enemy;

/**
 * Created with IntelliJ IDEA.
 * User: Incognito
 * Date: 11/16/19
 * Time: 9:43 AM
 * To change this template use File | Settings | File Templates.
 */
public class Collision {
    private static final double collision_range = 5;
    public static boolean isCollide(Enemy e1, Bullet e2) {
        if(e1.distance(e2) < collision_range) return true;
        return false;
    }




}
