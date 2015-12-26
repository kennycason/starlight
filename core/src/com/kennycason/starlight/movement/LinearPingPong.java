package com.kennycason.starlight.movement;

import com.kennycason.starlight.entity.Entity;

/**
 * Created by kenny on 4/25/15.
 */
public class LinearPingPong implements Movement {

    public float vx;
    public float vy;
    public float minX;
    public float maxX;

    public LinearPingPong(final float vx, final float vy, final float minX, final float maxX) {
        this.vx = vx;
        this.vy = vy;
        this.minX = minX;
        this.maxX = maxX;
    }

    @Override
    public void move(final Entity entity, final float deltaTime) {
        final float dvx = vx * deltaTime;
        final float dvy = vy * deltaTime;
        if(vx > 0) {
            if (entity.x + entity.width + dvx < maxX) {
                entity.move(dvx, 0);
            } else {
                vx = -vx;
                entity.move(0, dvy);
            }
        } else {
            if (entity.x - dvx > minX) {
                entity.move(dvx, 0);
            } else {
                vx = -vx;
                entity.move(0, dvy);
            }
        }
    }

}
