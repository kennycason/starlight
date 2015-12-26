package com.kennycason.starlight.entity.weapon.bullet;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.kennycason.starlight.StarLight;
import com.kennycason.starlight.movement.Movement;
import com.kennycason.starlight.entity.sprite.AnimatedSprite;
import com.kennycason.starlight.resources.Textures;

/**
 * Created by kenny on 4/26/15.
 */
public class EnergyBlue extends Bullet {

    private AnimatedSprite sprite;

    public EnergyBlue(final StarLight game, final Movement movement) {
        super(game, movement);
        sprite = new AnimatedSprite(game, Textures.Weapons.ENERGY_BLUE, 1, 4);
        sprite.setAnimationSpeed(0.1f);
        sprite.setLooping(false);
        sprite.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);
        width = sprite.getWidth();
        height = sprite.getHeight();

        this.damage = 8;
    }

    @Override
    public void locate(final float x, final float y) {
        super.locate(x, y);
        sprite.locate(x, y);
    }

    @Override
    public void move(final float vx, final float vy) {
        super.move(vx, vy);
        sprite.move(vx, vy);
    }

    @Override
    public void draw() {
        sprite.draw();
    }

}
