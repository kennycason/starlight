package com.kennycason.starlight.entity.weapon;

import com.kennycason.starlight.GameScreen;
import com.kennycason.starlight.StarLight;
import com.kennycason.starlight.entity.player.Ship;
import com.kennycason.starlight.entity.weapon.bullet.Bullet;
import com.kennycason.starlight.entity.weapon.bullet.EnergyRed;
import com.kennycason.starlight.movement.Linear;

/**
 * Created by kenny on 5/24/15.
 */
public class PlasmaBeam extends Weapon {

    public PlasmaBeam(final StarLight game, final Ship ship) {
        super(game, ship, 100, "PLASMA");
    }

    @Override
    public void fire(final GameScreen gameScreen) {
        if(!canFireAgain()) { return; }
        super.fire(gameScreen);

        switch(ship.weaponUpCount) {
            case 0:
                final Bullet bullet = new EnergyRed(game, new Linear(0, 400));
                bullet.locate(ship.x + ship.width / 2 - bullet.width / 2, ship.y + ship.height);
                gameScreen.bullets.add(bullet);
                break;

            case 1:
                final Bullet bulletDouble = new EnergyRed(game, new Linear(0, 400));
                bulletDouble.locate(ship.x + ship.width / 2 - bulletDouble.width / 2 - 10, ship.y + ship.height);
                gameScreen.bullets.add(bulletDouble);
                final Bullet bulletDouble2 = new EnergyRed(game, new Linear(0, 400));
                bulletDouble2.locate(ship.x + ship.width / 2 - bulletDouble.width / 2 + 10, ship.y + ship.height);
                gameScreen.bullets.add(bulletDouble2);
                break;

            case 2:
                final Bullet bulletLeft = new EnergyRed(game, new Linear(-250, 400));
                bulletLeft.locate(ship.x + ship.width / 2 - bulletLeft.width / 2, ship.y + ship.height);
                gameScreen.bullets.add(bulletLeft);
                final Bullet bulletCenter = new EnergyRed(game, new Linear(0, 400));
                bulletCenter.locate(ship.x + ship.width / 2 - bulletCenter.width / 2, ship.y + ship.height);
                gameScreen.bullets.add(bulletCenter);
                final Bullet bulletRight = new EnergyRed(game, new Linear(250, 400));
                bulletRight.locate(ship.x + ship.width / 2 - bulletRight.width / 2, ship.y + ship.height);
                gameScreen.bullets.add(bulletRight);
                break;

            case 3:
            default:
                final Bullet bulletLeftest2 = new EnergyRed(game, new Linear(-250, 400));
                bulletLeftest2.locate(ship.x + ship.width / 2 - bulletLeftest2.width / 2, ship.y + ship.height);
                gameScreen.bullets.add(bulletLeftest2);
                final Bullet bulletLeft2 = new EnergyRed(game, new Linear(-125, 400));
                bulletLeft2.locate(ship.x + ship.width / 2 - bulletLeft2.width / 2, ship.y + ship.height);
                gameScreen.bullets.add(bulletLeft2);
                final Bullet bulletCenter2 = new EnergyRed(game, new Linear(0, 400));
                bulletCenter2.locate(ship.x + ship.width / 2 - bulletCenter2.width / 2, ship.y + ship.height);
                gameScreen.bullets.add(bulletCenter2);
                final Bullet bulletRight2 = new EnergyRed(game, new Linear(125, 400));
                bulletRight2.locate(ship.x + ship.width / 2 - bulletRight2.width / 2, ship.y + ship.height);
                gameScreen.bullets.add(bulletRight2);
                final Bullet bulletRightest2 = new EnergyRed(game, new Linear(250, 400));
                bulletRightest2.locate(ship.x + ship.width / 2 - bulletRightest2.width / 2, ship.y + ship.height);
                gameScreen.bullets.add(bulletRightest2);
                break;


        }

    }


}
