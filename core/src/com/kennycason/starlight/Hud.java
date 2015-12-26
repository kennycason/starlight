package com.kennycason.starlight;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.kennycason.starlight.entity.BitmapFont;
import com.kennycason.starlight.entity.player.Ship;
import com.kennycason.starlight.resources.Textures;

/**
 * Created by kenny on 5/25/15.
 */
public class Hud {

    public int width = 160;

    private final StarLight game;

    private final ShapeRenderer shapeRenderer;

    private final BitmapFont bitmapFont;

    private final Color HUD_BG_BORDER = new Color(0x111111);
    private final Color HUD_BG_BORDER2 = new Color(0x151515);
    private final Color HUD_BG = new Color(0x222222);

    public Hud(final StarLight game) {
        this.game = game;
        shapeRenderer = new ShapeRenderer();
        bitmapFont = new BitmapFont(game, Textures.Fonts.TWINBEE);
    }


    public void draw(final GameScreen gameScreen) {
        final Ship ship = gameScreen.ship;
        game.batch.end();

        final int menuX = game.config.width - width;

        // hud background
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(HUD_BG);
        shapeRenderer.rect(menuX, 0, width, game.config.height);
        shapeRenderer.setColor(HUD_BG_BORDER);
        shapeRenderer.rect(menuX, 0, 6, game.config.height);
        shapeRenderer.setColor(HUD_BG_BORDER2);
        shapeRenderer.rect(menuX, 0, 3, game.config.height);

        // life bar
        final int lifeBars = ship.lifeUpCount + 1;
        final int fullBars = ship.life / 100;

        int lifeX = menuX + 10;
        final int lifeY = 40;
        final int barWidth = 15;
        final int barHeight = 18;
        for(int i = 0; i < fullBars; i++) {
            shapeRenderer.setColor(Color.RED);
            shapeRenderer.rect(lifeX, lifeY, barWidth, barHeight);
            shapeRenderer.setColor(Color.WHITE);
            shapeRenderer.rect(lifeX + 1, lifeY + 1, barWidth - 2, barHeight - 2);
            lifeX += 16;
        }
        if(fullBars < lifeBars) {
            final float rgb = (ship.life % 100) / (float) ship.maxLife;
            shapeRenderer.setColor(Color.RED);
            shapeRenderer.rect(lifeX, lifeY, barWidth, barHeight);
            shapeRenderer.setColor(rgb, rgb, rgb, 1.0f);
            shapeRenderer.rect(lifeX + 1, lifeY + 1, barWidth - 2, barHeight - 2);
        }

        shapeRenderer.end();

        game.batch.begin();
        bitmapFont.draw(String.valueOf(ship.life), menuX + 10, lifeY + 20);

        // items
        bitmapFont.draw(gameScreen.level.name, menuX + 10, game.config.height - 20);
        bitmapFont.draw("xp", menuX + 10, game.config.height - 40);
        bitmapFont.draw(String.valueOf(ship.score), menuX + 10, game.config.height - 60);

        int itemY = game.config.height - 80;
        bitmapFont.draw("items", menuX + 10, itemY);
        itemY -= 20;
        drawItem(Textures.Items.LIFE_UP, itemY, ship.lifeUpCount);
        itemY -= 20;
        drawItem(Textures.Items.WEAPON_UP, itemY, ship.weaponUpCount);
        itemY -= 20;
        drawItem(Textures.Items.SPEED_UP, itemY, ship.speedUpCount);

        bitmapFont.draw(ship.currentWeapon().name , menuX + 10, 10);
    }

    private void drawItem(Texture texture, int y, int count) {
        for(int i = 0; i < count; i++) {
            game.batch.draw(texture, (game.config.width - width + 10) + (i * 16), y, 16, 16);
        }
    }
}
