package com.kennycason.starlight.entity.enemy;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.kennycason.starlight.GameScreen;
import com.kennycason.starlight.StarLight;
import com.kennycason.starlight.movement.Linear;
import com.kennycason.starlight.movement.Movement;
import com.kennycason.starlight.entity.sprite.AnimatedSprite;
import com.kennycason.starlight.entity.weapon.bullet.EnergyBlue;
import com.kennycason.starlight.entity.weapon.bullet.Bullet;
import com.kennycason.starlight.math.Vector;
import com.kennycason.starlight.resources.Textures;

/**
 * Created by kenny on 4/26/15.
 */
public class BioMechChild extends Enemy {

    public AnimatedSprite sprite;
    private boolean isAngry = false;

    public BioMechChild(final StarLight game) {
        super(game, new Linear(0, 0));
        life = 3;
        score = 100;
        sprite = new AnimatedSprite(game, Textures.Enemies.ENEMY1, 4);
        sprite.setAnimationSpeed(.15f);
        sprite.setLooping(false);
        sprite.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);

        width = sprite.getWidth();
        height = sprite.getHeight();
    }

    @Override
    public void handle(final float deltaTime, final GameScreen gameScreen) {
        super.handle(deltaTime, gameScreen);
       if(isAngry) {
           shoot(gameScreen);
           isAngry = false;
       }
    }

    @Override
    public void hit(final Bullet bullet) {
        super.hit(bullet);
        isAngry = true;
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
        gameScreen.enemyBullets.add(makeBullet(-1, 0));
        gameScreen.enemyBullets.add(makeBullet(1, 0));
        gameScreen.enemyBullets.add(makeBullet(1, -1));
        gameScreen.enemyBullets.add(makeBullet(-1, -1));
    }

    private Bullet makeBullet(final float vx, final float vy) {
        final float[] unit = Vector.unit2d(vx, vy);
        final Movement movement = new Linear(unit[0] * 300, unit[1] * 300);
        final Bullet bullet = new EnergyBlue(game, movement);
        bullet.damage = 8;
        bullet.locate(x + width / 2 - bullet.width / 2, y + height / 2 - bullet.height / 2);

        return bullet;
    }

}
