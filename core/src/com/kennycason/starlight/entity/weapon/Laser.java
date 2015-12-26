package com.kennycason.starlight.entity.weapon;

import com.kennycason.starlight.GameScreen;
import com.kennycason.starlight.StarLight;
import com.kennycason.starlight.entity.player.Ship;
import com.kennycason.starlight.entity.weapon.bullet.Bullet;
import com.kennycason.starlight.entity.weapon.bullet.LaserDouble;
import com.kennycason.starlight.entity.weapon.bullet.LaserSingle;
import com.kennycason.starlight.movement.Linear;

/**
 * Created by kenny on 5/24/15.
 */
public class Laser extends Weapon {

    public Laser(final StarLight game, final Ship ship) {
        super(game, ship, 300, "LASER");
    }

    @Override
    public void fire(final GameScreen gameScreen) {
        if(!canFireAgain()) { return; }
        super.fire(gameScreen);

        switch(ship.weaponUpCount) {
            case 0:
                final Bullet laser = new LaserSingle(game, new Linear(0, 400));
                laser.locate(ship.x + ship.width / 2 - laser.width / 2, ship.y + ship.height);
                gameScreen.bullets.add(laser);
                break;

            case 1:
                final Bullet laserDouble = new LaserDouble(game, new Linear(0, 400));
                laserDouble.locate(ship.x + ship.width / 2 - laserDouble.width / 2, ship.y + ship.height);
                gameScreen.bullets.add(laserDouble);
                break;

            case 2:
            default:
                final Bullet laserLeft = new LaserSingle(game, new Linear(-250, 400));
                laserLeft.locate(ship.x + ship.width / 2 - laserLeft.width / 2, ship.y + ship.height);
                gameScreen.bullets.add(laserLeft);
                final Bullet laserCenter = new LaserDouble(game, new Linear(0, 400));
                laserCenter.locate(ship.x + ship.width / 2 - laserCenter.width / 2, ship.y + ship.height);
                gameScreen.bullets.add(laserCenter);
                final Bullet laserRight = new LaserSingle(game, new Linear(250, 400));
                laserRight.locate(ship.x + ship.width / 2 - laserRight.width / 2, ship.y + ship.height);
                gameScreen.bullets.add(laserRight);
                break;


        }

    }


}
