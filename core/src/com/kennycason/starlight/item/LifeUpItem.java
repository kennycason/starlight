package com.kennycason.starlight.item;

import com.kennycason.starlight.StarLight;
import com.kennycason.starlight.entity.player.Ship;
import com.kennycason.starlight.entity.sprite.AnimatedSprite;
import com.kennycason.starlight.resources.Textures;

/**
 * Created by kenny on 4/26/15.
 */
public class LifeUpItem extends Item {

    private AnimatedSprite sprite;

    public LifeUpItem(final StarLight game, final Ship ship) {
        super(game, ship);
        sprite = new AnimatedSprite(game, Textures.Items.LIFE_UP, 1, 1);
        dim(sprite.getWidth(), sprite.getHeight());
    }

    public void use() {
        ship.maxLife += 100;
        ship.life = ship.maxLife;
        ship.lifeUpCount++;
    }

    @Override
    public void locate(final float x, final float y) {
        super.locate(x, y);
        sprite.locate(x, y);
    }

    @Override
    public void move(final float x, final float y) {
        super.move(x, y);
        sprite.move(x, y);
    }

    public void draw() {
        sprite.draw();
    }

}
