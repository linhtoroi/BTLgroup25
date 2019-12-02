package Enemy;

import GameEntity.Config;

/**
 * Created with IntelliJ IDEA.
 * User: Incognito
 * Date: 12/2/19
 * Time: 2:51 PM
 * To change this template use File | Settings | File Templates.
 */
public class SmallerEnemy extends Enemy {
    public SmallerEnemy(double x, double y) {
        super(x, y);
        health = Config.SMALLER_ENEMY_HEALTH;
        armor = Config.SMALLER_ENEMY_ARMOR;
        speed = Config.SMALLER_ENEMY_SPEED;
        reward = Config.SMALLER_ENEMY_REWARD;
    }
}
