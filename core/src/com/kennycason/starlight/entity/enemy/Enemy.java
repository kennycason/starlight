package com.kennycason.starlight.entity.enemy;

import com.badlogic.gdx.utils.TimeUtils;
import com.kennycason.starlight.GameScreen;
import com.kennycason.starlight.StarLight;
import com.kennycason.starlight.entity.Entity;
import com.kennycason.starlight.entity.weapon.bullet.Bullet;
import com.kennycason.starlight.item.Item;
import com.kennycason.starlight.item.LifeItem;
import com.kennycason.starlight.item.LifeUpItem;
import com.kennycason.starlight.item.SpeedUpItem;
import com.kennycason.starlight.item.WeaponUpItem;
import com.kennycason.starlight.math.Dice;
import com.kennycason.starlight.movement.Movement;

/**
 * Created by kenny on 4/23/15.
 */
public abstract class Enemy extends Entity {

    public Movement movement;

    public boolean expire = false;

    public int life = 1;
    public int score = 0;
    public boolean invincible;
    public long lastHitTime = -1;
    public int hitDamage = 5;
    public long lastFired;


    public Enemy(final StarLight game, final Movement movement) {
        super(game);
        this.movement = movement;
    }

    public void handle(final float deltaTime, final GameScreen gameScreen) {
        if(life <= 0) {
            expire = true;
            if(Dice.d6() >= 5) {
                final Item item = new WeaponUpItem(game, gameScreen.ship);
                item.locate(x, y);
                gameScreen.items.add(item);
            } else if(Dice.d6() >= 5) {
                final Item item = new LifeUpItem(game, gameScreen.ship);
                item.locate(x, y);
                gameScreen.items.add(item);
            } else if(Dice.d6() >= 5) {
                final Item item = new SpeedUpItem(game, gameScreen.ship);
                item.locate(x, y);
                gameScreen.items.add(item);
            } else {
                final int num = Dice.d10();
                for(int i = 0; i < num; i++) {
                    final Item item = new LifeItem(game, gameScreen.ship);
                    item.locate(x - 10 + Dice.d(20), y - 10 + Dice.d(20));
                    gameScreen.items.add(item);
                }
            }
        }
        if(invincible) {
            if (TimeUtils.timeSinceMillis(lastHitTime) > 50) {
                invincible = false;
            }
        }

        if(expire) { return; }

        movement.move(this, deltaTime);

        if(y < -height) {
            expire = true;
        }
    }

    public void hit(final Bullet bullet) {
        hit(bullet.damage);
    }

    private void hit(final int damage) {
        if(invincible) { return; }

        lastHitTime = TimeUtils.millis();
        invincible = true;
        life -= damage;
    }

    @Override
    public abstract void draw();


}
