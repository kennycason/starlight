package com.kennycason.starlight.item;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.kennycason.starlight.StarLight;
import com.kennycason.starlight.entity.player.Ship;
import com.kennycason.starlight.entity.sprite.AnimatedSprite;
import com.kennycason.starlight.math.Dice;
import com.kennycason.starlight.resources.Textures;

/**
 * Created by kenny on 4/26/15.
 */
public class LifeItem extends Item {

    public AnimatedSprite sprite;

    private final int life;

    public LifeItem(final StarLight game, final Ship ship) {
        super(game, ship);
        switch (Dice.d2()) {
            case 1: sprite = new AnimatedSprite(game, Textures.Items.LIFE1, 3); life = 3; break;
            case 2: sprite = new AnimatedSprite(game, Textures.Items.LIFE2, 5); life = 5; break;
            default: life = 0;
        }
        sprite.setAnimationSpeed(0.1f);
        sprite.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);
        dim(sprite.getWidth(), sprite.getHeight());
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

    public void use() {
        ship.life += life;
        if(ship.life > ship.maxLife) {
            ship.life = ship.maxLife;
        }
    }

    public void draw() {
        sprite.draw();
    }

}
