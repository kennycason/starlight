package com.kennycason.starlight.entity.player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.utils.TimeUtils;
import com.kennycason.starlight.GameOverScreen;
import com.kennycason.starlight.GameScreen;
import com.kennycason.starlight.StarLight;
import com.kennycason.starlight.entity.Entity;
import com.kennycason.starlight.entity.enemy.Enemy;
import com.kennycason.starlight.entity.sprite.AnimatedSprite;
import com.kennycason.starlight.entity.weapon.BasicGun;
import com.kennycason.starlight.entity.weapon.Laser;
import com.kennycason.starlight.entity.weapon.PlasmaBeam;
import com.kennycason.starlight.entity.weapon.Weapon;
import com.kennycason.starlight.entity.weapon.bullet.Bullet;
import com.kennycason.starlight.resources.Textures;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kenny on 4/23/15.
 */
public class Ship extends Entity {

    private AnimatedSprite current;
    private AnimatedSprite ship;
    private AnimatedSprite shipLeft;
    private AnimatedSprite shipRight;

    public int currentWeapon = 0;
    public List<Weapon> weapons = new ArrayList<>();

    public float vx;
    public float vy;

    public int life = 50;
    public int maxLife = 100;
    public boolean invincible;
    public long lastHitTime = -1;
    public int speed = 3;

    public int lifeUpCount = 0;
    public int weaponUpCount = 0;
    public int speedUpCount = 0;

    public int score = 0;

    private long lastWeaponScroll;

    public Ship(final StarLight game) {
        super(game);
        ship = new AnimatedSprite(game, Textures.Player.SHIP0, 2);
        shipLeft = new AnimatedSprite(game, Textures.Player.SHIP0_LEFT, 2);
        shipLeft.setAnimationSpeed(0.01f);
        shipLeft.setLooping(false);
        shipRight = new AnimatedSprite(game, Textures.Player.SHIP0_RIGHT, 2);
        shipRight.setAnimationSpeed(0.01f);
        shipRight.setLooping(false);
        locate(game.config.width / 2, 50);
        dim(ship.width - 3, ship.height - 3);

        current = ship;

        weapons.add(new BasicGun(game, this));
        weapons.add(new Laser(game, this));
        weapons.add(new PlasmaBeam(game, this));
    }

    public void hit(final Enemy enemy) {
        hit(enemy.hitDamage);
    }

    public void hit(final Bullet bullet) {
        hit(bullet.damage);
        bullet.expire = true;
    }

    private void hit(final int damage) {
        if(invincible) { return; }

        lastHitTime = TimeUtils.millis();
        invincible = true;
        life -= damage;
        if(life < 1) {
            game.setScreen(new GameOverScreen(game));
        }
    }

    public void handle(final GameScreen gameScreen) {
        if(invincible) {
            if(TimeUtils.timeSinceMillis(lastHitTime) > 1000) {
                invincible = false;
            }
        }

        if(vx == 0 && vy == 0) { return; }

        move(vx, vy);

        if (x < 0) {
            locate(0, y);
        }
        if (x > game.config.width- gameScreen.hud.width - width) {
            locate(game.config.width - gameScreen.hud.width - width, y);
        }
        if (y < 0) {
            locate(x, 0);
        }
        if (y > game.config.height - height) {
            locate(x, game.config.height  - height);
        }
    }

    @Override
    public void draw() {
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            current = shipLeft;
        } else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            current = shipRight;
        } else {
            current = ship;
        }
        current.locate(x, y);
        current.draw();
    }

    public void shoot(final GameScreen gameScreen) {
        currentWeapon().fire(gameScreen);
    }

    public Weapon currentWeapon() {
        return weapons.get(currentWeapon);
    }

    public void weaponScrollRight() {
        if(TimeUtils.timeSinceMillis(lastWeaponScroll) < 300) { return; }
        lastWeaponScroll = TimeUtils.millis();

        currentWeapon++;
        if(currentWeapon >= weapons.size()) { currentWeapon = 0; }
    }

    public void weaponScrollLeft() {
        if(TimeUtils.timeSinceMillis(lastWeaponScroll) < 300) { return; }
        lastWeaponScroll = TimeUtils.millis();

        currentWeapon--;
        if(currentWeapon < 0) { currentWeapon = weapons.size() - 1; }
    }

}
