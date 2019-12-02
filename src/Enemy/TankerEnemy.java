package Enemy;

import GameEntity.Config;

/**
 * Created with IntelliJ IDEA.
 * User: Incognito
 * Date: 12/2/19
 * Time: 2:51 PM
 * To change this template use File | Settings | File Templates.
 */
public class TankerEnemy extends Enemy {
    public TankerEnemy(double x, double y) {
        super(x, y);
        health = Config.TANKER_ENEMY_HEALTH;
        armor = Config.TANKER_ENEMY_ARMOR;
        speed = Config.TANKER_ENEMY_SPEED;
        reward = Config.TANKER_ENEMY_REWARD;
    }
}
