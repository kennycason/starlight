package com.kennycason.starlight.item;

import com.kennycason.starlight.StarLight;
import com.kennycason.starlight.entity.Entity;
import com.kennycason.starlight.entity.player.Ship;

/**
 * Created by kenny on 4/26/15.
 */
public abstract class Item extends Entity {

    public Ship ship;

    public Item(final StarLight game, final Ship ship) {
        super(game);
        this.ship = ship;
    }

    public abstract void use();

    public abstract void draw();

}
