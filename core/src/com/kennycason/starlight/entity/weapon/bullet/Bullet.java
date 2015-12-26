package com.kennycason.starlight.entity.weapon.bullet;

import com.kennycason.starlight.StarLight;
import com.kennycason.starlight.entity.Entity;
import com.kennycason.starlight.movement.Movement;

/**
 * Created by kenny on 4/23/15.
 */
public abstract class Bullet extends Entity {

    public Movement movement;

    public boolean expire = false;

    public int damage = 1;

    public Bullet(final StarLight game, final Movement movement) {
        super(game);
        this.movement = movement;
    }

    public void handle(float deltaTime) {
        if(expire) { return; }

        movement.move(this, deltaTime);

        // offscreen
        if(x < -width || x > game.config.width
                || y < 0 || y + height > game.config.height) {
            expire = true;
        }
    }

    @Override
    public abstract void draw();

}
