package GameEntity;

/**
 * Created with IntelliJ IDEA.
 * User: Incognito
 * Date: 11/28/19
 * Time: 11:09 AM
 * To change this template use File | Settings | File Templates.
 */
public class Config {
    public final static int TILE_SIZE = 50;


    // copy ở project mẫu

    //Other config related to other entities in the game.

    //region Bullet
    public static final long NORMAL_BULLET_TTL = 30;
    public static final long NORMAL_BULLET_STRENGTH = 30;
    public static final double NORMAL_BULLET_SPEED = 0.3;

    public static final long MACHINE_GUN_BULLET_TTL = 15;
    public static final long MACHINE_GUN_BULLET_STRENGTH = 20;
    public static final double MACHINE_GUN_BULLET_SPEED = 0.4;

    public static final long SNIPER_BULLET_TTL = 60;
    public static final long SNIPER_BULLET_STRENGTH = 120;
    public static final double SNIPER_BULLET_SPEED = 0.5;
    //endregion

    //region Tower
    public static final long NORMAL_TOWER_SPEED = 10;
    public static final double NORMAL_TOWER_RANGE = 200;
    public static final long NORMAL_TOWER_PRICE = 30;

    public static final long MACHINE_GUN_TOWER_SPEED = 20;
    public static final double MACHINE_GUN_TOWER_RANGE = 150;
    public static final long MACHINE_GUN_TOWER_PRICE = 70;

    public static final long SNIPER_TOWER_SPEED = 15;
    public static final double SNIPER_TOWER_RANGE = 300;
    public static final long SNIPER_TOWER_PRICE = 100;

    //endregion

    //region Enemy
    public static final double NORMAL_ENEMY_SIZE = 0.9;
    public static final long NORMAL_ENEMY_HEALTH = 100;
    public static final long NORMAL_ENEMY_ARMOR = 3;
    public static final double NORMAL_ENEMY_SPEED = 3;
    public static final long NORMAL_ENEMY_REWARD = 20;

    public static final double SMALLER_ENEMY_SIZE = 0.7;
    public static final long SMALLER_ENEMY_HEALTH = 50;
    public static final long SMALLER_ENEMY_ARMOR = 0;
    public static final double SMALLER_ENEMY_SPEED = 4;
    public static final long SMALLER_ENEMY_REWARD = 10;

    public static final double TANKER_ENEMY_SIZE = 1.1;
    public static final long TANKER_ENEMY_HEALTH = 300;
    public static final long TANKER_ENEMY_ARMOR = 5;
    public static final double TANKER_ENEMY_SPEED = 2;
    public static final long TANKER_ENEMY_REWARD = 50;

    public static final double BOSS_ENEMY_SIZE = 1.3;
    public static final long BOSS_ENEMY_HEALTH = 500;
    public static final long BOSS_ENEMY_ARMOR = 8;
    public static final double BOSS_ENEMY_SPEED = 3;
    public static final long BOSS_ENEMY_REWARD = 100;
    //endregion


    private Config() {
    }
}