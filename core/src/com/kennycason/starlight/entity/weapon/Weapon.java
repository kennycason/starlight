package com.kennycason.starlight.entity.weapon;

import com.badlogic.gdx.utils.TimeUtils;
import com.kennycason.starlight.GameScreen;
import com.kennycason.starlight.StarLight;
import com.kennycason.starlight.entity.player.Ship;

/**
 * Created by kenny on 5/24/15.
 */
public abstract class Weapon {

    protected final StarLight game;

    protected final Ship ship;

    protected long lastFired;

    protected long refireRate;

    public final String name;

    public Weapon(final StarLight game, final Ship ship,  final long refireRate, final String name) {
        this.game = game;
        this.ship = ship;
        this.refireRate = refireRate;
        this.name = name;
    }

    public void fire(final GameScreen gameScreen) {
        lastFired = TimeUtils.millis();
    }

    public boolean canFireAgain() {
        return TimeUtils.timeSinceMillis(lastFired) >= refireRate;
    }


}
