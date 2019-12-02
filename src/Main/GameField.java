package Main;

import GameEntity.GameEntity;
import GameEntity.Spawner;
import Enemy.Enemy;
import GameEntity.Tower.Tower;

import java.util.HashSet;

/**
 * Created with IntelliJ IDEA.
 * User: Incognito
 * Date: 11/8/19
 * Time: 8:28 PM
 * To change this template use File | Settings | File Templates.
 */
public class GameField {
    public HashSet<GameEntity> entities = new HashSet<GameEntity>();

    public void addEntity(GameEntity entity){
        entities.add(entity);
    }

    public void removeEntity(GameEntity entity){
        entities.remove(entity);
    }

    public void update() {
        for (GameEntity entity : entities) {
            if(entity instanceof Spawner) ((Spawner) entity).update(this);
            if(entity instanceof Enemy) {
                ((Enemy) entity).update();
                if(((Enemy) entity).isDestroy()) {
                    entities.remove(entity);
                    //System.out.println(true );
                }
            }

        }
    }



}