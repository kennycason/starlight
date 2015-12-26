package com.kennycason.starlight.event;

import com.kennycason.starlight.GameScreen;
import com.kennycason.starlight.entity.enemy.Enemy;

/**
 * Created by kenny on 4/26/15.
 */
public class LevelProgressionEnemyDeploy extends LevelProgressionEvent {

    public Enemy enemy;

    public LevelProgressionEnemyDeploy(final GameScreen gameScreen, final long yOffset, final Enemy enemy) {
        super(gameScreen, yOffset);
        this.enemy = enemy;
    }

    @Override
    public void happen() {
        gameScreen.enemies.add(enemy);
    }

}
