package com.kennycason.starlight.entity.enemy;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.utils.TimeUtils;
import com.kennycason.starlight.GameScreen;
import com.kennycason.starlight.StarLight;
import com.kennycason.starlight.entity.sprite.AnimatedSprite;
import com.kennycason.starlight.entity.weapon.bullet.Bullet;
import com.kennycason.starlight.entity.weapon.bullet.enemy.SlimeBlast;
import com.kennycason.starlight.math.Dice;
import com.kennycason.starlight.math.Vector;
import com.kennycason.starlight.movement.Linear;
import com.kennycason.starlight.movement.Movement;
import com.kennycason.starlight.resources.Textures;

/**
 * Created by kenny on 4/26/15.
 */
public class Plunk extends Enemy {

    public AnimatedSprite sprite;

    public Plunk(final StarLight game) {
        super(game, new Linear(0, -32));
        life = 1;
        score = 25;
        sprite = new AnimatedSprite(game, Textures.Enemies.PLUNK1, 3);
        sprite.setAnimationSpeed(.15f);
        sprite.setLooping(false);
        sprite.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);

        width = sprite.getWidth();
        height = sprite.getHeight();
    }

    @Override
    public void handle(final float deltaTime, final GameScreen gameScreen) {
        super.handle(deltaTime, gameScreen);
       if(Dice.d(100) > 95 && TimeUtils.timeSinceMillis(lastFired) > 2000) {
           shoot(gameScreen);
           lastFired = TimeUtils.millis();
       }
    }

    @Override
    public void hit(final Bullet bullet) {
        super.hit(bullet);
    }

    @Override
    public void draw() {
        sprite.draw();
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

    private void shoot(final GameScreen gameScreen) {
        gameScreen.enemyBullets.add(makeBullet(0, -1));
    }

    private Bullet makeBullet(final float vx, final float vy) {
        final float[] unit = Vector.unit2d(vx, vy);
        final Movement movement = new Linear(unit[0] * 300, unit[1] * 300);
        final Bullet bullet = new SlimeBlast(game, movement);
        bullet.damage = 8;
        bullet.locate(x + width / 2 - bullet.width / 2, y + height / 2 - bullet.height / 2);

        return bullet;
    }

}
