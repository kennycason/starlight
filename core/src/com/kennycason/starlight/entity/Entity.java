package com.kennycason.starlight.entity;

import com.badlogic.gdx.math.Rectangle;
import com.kennycason.starlight.StarLight;

/**
 * Created by kenny on 4/23/15.
 */
public abstract class Entity extends Rectangle {

    public final StarLight game;

    protected Entity(final StarLight game) {
        this.game = game;
    }

    public void locate(final float x, final float y) {
        this.x = x;
        this.y = y;
    }

    public void move(final float vx, final float vy) {
        this.x += vx;
        this.y += vy;
    }

    public void dim(final float width, final float height) {
        this.width = width;
        this.height = height;
    }

    public boolean overlaps(final Entity entity) {
        return this.overlaps((Rectangle) entity);
    }

    @Override
    public boolean overlaps(final Rectangle entity) {
        if(true) return super.overlaps(entity);
        if((entity.y + entity.height / 2 >= y - height / 2) && (entity.y - entity.height / 2 <= y + height / 2)) {
            if((entity.x + entity.width / 2 >= x - width / 2) && (entity.x - entity.width / 2 <= x + width / 2)) {
                return true;
            }
        }
        return false;
    }

    public abstract void draw();

}
