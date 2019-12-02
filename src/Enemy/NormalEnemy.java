package Enemy;

import GameEntity.Config;

/**
 * Created with IntelliJ IDEA.
 * User: Incognito
 * Date: 12/2/19
 * Time: 2:00 PM
 * To change this template use File | Settings | File Templates.
 */
public class NormalEnemy extends Enemy{
    public NormalEnemy(double x, double y) {
        super(x, y);
        health = Config.NORMAL_ENEMY_HEALTH;
        armor = Config.NORMAL_ENEMY_ARMOR;
        speed = Config.NORMAL_ENEMY_SPEED;
        reward = Config.NORMAL_ENEMY_REWARD;
    }
}
