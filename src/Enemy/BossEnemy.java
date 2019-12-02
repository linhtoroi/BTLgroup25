package Enemy;

import GameEntity.Config;

/**
 * Created with IntelliJ IDEA.
 * User: Incognito
 * Date: 12/2/19
 * Time: 2:52 PM
 * To change this template use File | Settings | File Templates.
 */
public class BossEnemy extends Enemy {
    public BossEnemy(double x, double y) {
        super(x, y);
        health = Config.BOSS_ENEMY_HEALTH;
        armor = Config.BOSS_ENEMY_ARMOR;
        speed = Config.BOSS_ENEMY_SPEED;
        reward = Config.BOSS_ENEMY_REWARD;
    }
}
