package com.kennycason.starlight.entity.weapon;

import com.kennycason.starlight.GameScreen;
import com.kennycason.starlight.StarLight;
import com.kennycason.starlight.entity.player.Ship;
import com.kennycason.starlight.entity.weapon.bullet.Bullet;
import com.kennycason.starlight.entity.weapon.bullet.BulletSingle;
import com.kennycason.starlight.movement.Linear;

/**
 * Created by kenny on 5/24/15.
 */
public class BasicGun extends Weapon {

    public BasicGun(final StarLight game, final Ship ship) {
        super(game, ship, 300, "GUN");
    }

    @Override
    public void fire(final GameScreen gameScreen) {
        if(!canFireAgain()) { return; }
        super.fire(gameScreen);

        switch(ship.weaponUpCount) {
            case 0:
                final Bullet bullet = new BulletSingle(game, new Linear(0, 400));
                bullet.locate(ship.x + ship.width / 2 - bullet.width / 2, ship.y + ship.height);
                gameScreen.bullets.add(bullet);
                break;

            case 1:
                final Bullet bullet0 = new BulletSingle(game, new Linear(0, 400));
                bullet0.locate(ship.x + ship.width / 2 - bullet0.width / 2 - 10, ship.y + ship.height);
                gameScreen.bullets.add(bullet0);

                final Bullet bullet1 = new BulletSingle(game, new Linear(0, 400));
                bullet1.locate(ship.x + ship.width / 2 - bullet1.width / 2 + 10, ship.y + ship.height);
                gameScreen.bullets.add(bullet1);
                break;

            case 2:
            default:
                final Bullet bulletCenter = new BulletSingle(game, new Linear(0, 400));
                bulletCenter.locate(ship.x + ship.width / 2 - bulletCenter.width / 2, ship.y + ship.height);
                gameScreen.bullets.add(bulletCenter);

                final Bullet bulletLeft = new BulletSingle(game, new Linear(0, 400));
                bulletLeft.locate(ship.x + ship.width / 2 - bulletLeft.width / 2 - 10, ship.y + ship.height);
                gameScreen.bullets.add(bulletLeft);

                final Bullet bulletRight = new BulletSingle(game, new Linear(0, 400));
                bulletRight.locate(ship.x + ship.width / 2 - bulletRight.width / 2 + 10, ship.y + ship.height);
                gameScreen.bullets.add(bulletRight);

                break;


        }

    }


}
