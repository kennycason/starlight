package com.kennycason.starlight.movement;

import com.kennycason.starlight.entity.Entity;

/**
 * Created by kenny on 4/25/15.
 */
public class Linear implements Movement {
    public static final Movement STATIONARY = new Linear(0, 0);

    private float vx;
    private float vy;

    public Linear(final float vx, final float vy) {
        this.vx = vx;
        this.vy = vy;
    }

    @Override
    public void move(final Entity entity, final float deltaTime) {
        entity.move(vx * deltaTime, vy * deltaTime);
    }

}
