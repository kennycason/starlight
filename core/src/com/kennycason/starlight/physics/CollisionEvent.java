package com.kennycason.starlight.physics;

import com.badlogic.gdx.math.Rectangle;

/**
 * Created by kenny on 5/26/15.
 */
public class CollisionEvent {

    public static final CollisionEvent FALSE = new CollisionEvent(false, null);

    public final boolean collided;
    public final Rectangle collidedWith;

    public CollisionEvent(final boolean collided, final Rectangle collidedWith) {
        this.collided = collided;
        this.collidedWith = collidedWith;
    }

}
