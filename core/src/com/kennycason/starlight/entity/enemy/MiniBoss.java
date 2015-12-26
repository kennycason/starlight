package com.kennycason.starlight.entity.enemy;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.TimeUtils;
import com.kennycason.starlight.GameScreen;
import com.kennycason.starlight.StarLight;
import com.kennycason.starlight.entity.sprite.AnimatedSprite;
import com.kennycason.starlight.entity.weapon.bullet.Bullet;
import com.kennycason.starlight.entity.weapon.bullet.EnergyBlue;
import com.kennycason.starlight.math.Dice;
import com.kennycason.starlight.math.Vector;
import com.kennycason.starlight.movement.Linear;
import com.kennycason.starlight.movement.LinearPingPong;
import com.kennycason.starlight.movement.Movement;
import com.kennycason.starlight.resources.Textures;

/**
 * Created by kenny on 4/26/15.
 */
public class MiniBoss extends Enemy {

    public AnimatedSprite sprite;
    public AnimatedSprite spriteHit;

    private boolean isAngry = false;
    private boolean showHitAnim = false;
    private long hitTime = 0;

    public MiniBoss(final StarLight game) {
        super(game, new LinearPingPong(100, 0, 0, game.config.width - 150));
        life = 100;
        score = 2500;
        sprite = new AnimatedSprite(game, Textures.Enemies.BOSS, 1);
        sprite.setAnimationSpeed(.15f);
        sprite.setLooping(false);
        sprite.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);

        spriteHit = new AnimatedSprite(game, Textures.Enemies.BOSS_HIT, 1);
        spriteHit.setAnimationSpeed(.15f);
        spriteHit.setLooping(false);
        spriteHit.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);

        width = sprite.getWidth();
        height = sprite.getHeight();
    }

    @Override
    public void handle(final float deltaTime, final GameScreen gameScreen) {
        super.handle(deltaTime, gameScreen);

       if(isAngry) {
           shoot(gameScreen, 15);
           isAngry = false;
       }
       else {
           if(Dice.d100() > 98) {
               shoot(gameScreen, 15);
           }
       }
    }

    @Override
    public void hit(final Bullet bullet) {
        super.hit(bullet);
        isAngry = true;
        if(!showHitAnim) {
            showHitAnim = true;
            hitTime = TimeUtils.millis();
        }
    }

    @Override
    public void draw() {
        if(showHitAnim) {
            spriteHit.draw();
            if(TimeUtils.timeSinceMillis(hitTime) > 50) {
                showHitAnim = false;
            }
        } else {
            sprite.draw();
        }
    }

    @Override
    public void locate(final float x, final float y) {
        super.locate(x, y);
        sprite.locate(x, y);
        spriteHit.locate(x, y);
    }

    @Override
    public void move(final float vx, final float vy) {
        super.move(vx, vy);
        sprite.move(vx, vy);
        spriteHit.move(vx, vy);
    }

    @Override
    public boolean overlaps(final Rectangle entity) {
        return super.overlaps(entity);
    }

    private void shoot(final GameScreen gameScreen, final int count) {
        for(int i = 0; i < count; i++) {
            float vx = -10 + Dice.d20();
            float vy = -10 + Dice.d20();
            if(vx == 0 && vy == 0) { continue; }
            gameScreen.enemyBullets.add(makeBullet(vx, vy));
        }
    }

    private Bullet makeBullet(final float vx, final float vy) {
        final float[] unit = Vector.unit2d(vx, vy);
        final Movement movement = new Linear(unit[0] * 300, unit[1] * 300);
        final Bullet bullet = new EnergyBlue(game, movement);
        bullet.damage = 25;
        bullet.locate(x + width / 2 - bullet.width / 2, y + height / 2 - bullet.height / 2);

        return bullet;
    }

}
