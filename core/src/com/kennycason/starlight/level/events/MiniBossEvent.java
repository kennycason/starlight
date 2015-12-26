package com.kennycason.starlight.level.events;

import com.kennycason.starlight.GameScreen;
import com.kennycason.starlight.StarLight;
import com.kennycason.starlight.entity.enemy.MiniBoss;
import com.kennycason.starlight.event.Event;

/**
 * Created by kenny on 5/29/15.
 */
public class MiniBossEvent extends Event {

    private final StarLight game;

    public MiniBossEvent(final StarLight game, final GameScreen gameScreen) {
        super(gameScreen);
        this.game = game;
    }

    @Override
    public boolean isReady() {
        return true;
    }

    @Override
    public void happen() {
        final MiniBoss miniBoss = new MiniBoss(game);
        miniBoss.locate(game.config.width / 2 - miniBoss.width / 2, game.config.height - miniBoss.height - 20);
        gameScreen.enemies.add(miniBoss);
    }

}
