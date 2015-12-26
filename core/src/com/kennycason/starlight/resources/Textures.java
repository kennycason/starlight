package com.kennycason.starlight.resources;

import com.badlogic.gdx.graphics.Texture;

/**
 * Created by kenny on 4/25/15.
 */
public class Textures {

    public static final String TEXTURE_PATH = "core/resources/sprites/";

    public static class TitleScreen {
       // public static final Texture BG = new Texture(TEXTURE_PATH + "star_bg.png");
        public static final Texture LOGO = new Texture(TEXTURE_PATH + "starlight.png");
        public static final Texture GAMEOVER = new Texture(TEXTURE_PATH + "gameover.png");
        public static final Texture PUSH_ANY_BUTTON = new Texture(TEXTURE_PATH + "push_any_button.png");
    }

    public static class Player {
        public static final Texture SHIP0 = new Texture(TEXTURE_PATH + "ship0.png");
        public static final Texture SHIP0_LEFT = new Texture(TEXTURE_PATH + "ship0_left.png");
        public static final Texture SHIP0_RIGHT = new Texture(TEXTURE_PATH + "ship0_right.png");
    }

    public static class Enemies {
        public static final Texture ENEMY0 = new Texture(TEXTURE_PATH + "enemy/enemy0.png");
        public static final Texture ENEMY1 = new Texture(TEXTURE_PATH + "enemy/enemy1.png");
        public static final Texture PLUNK1 = new Texture(TEXTURE_PATH + "enemy/plunk1.png");
        public static final Texture BOSS = new Texture(TEXTURE_PATH + "enemy/boss.png");
        public static final Texture BOSS_HIT = new Texture(TEXTURE_PATH + "enemy/boss_hit.png");
    }

    public static class Weapons {
        public static final Texture BULLET1 = new Texture(TEXTURE_PATH + "weapon/bullet1.png");
        public static final Texture LASER1 = new Texture(TEXTURE_PATH + "weapon/laser1.png");
        public static final Texture LASER2 = new Texture(TEXTURE_PATH + "weapon/laser2.png");
        public static final Texture ENERGY_BLUE = new Texture(TEXTURE_PATH + "weapon/energy1.png");
        public static final Texture ENERGY_RED = new Texture(TEXTURE_PATH + "weapon/energy2.png");

        public static final Texture ENEMY_SLIME = new Texture(TEXTURE_PATH + "weapon/enemy_slime.png");
    }

    public static class Items {
        public static final Texture LIFE_UP = new Texture(TEXTURE_PATH + "item/life_up.png");
        public static final Texture WEAPON_UP = new Texture(TEXTURE_PATH + "item/weapon_up.png");
        public static final Texture SPEED_UP = new Texture(TEXTURE_PATH + "item/speed_up.png");
        public static final Texture XSPACE_UP = new Texture(TEXTURE_PATH + "item/xspace_up.png");

        public static final Texture LIFE1 = new Texture(TEXTURE_PATH + "item/life1.png");
        public static final Texture LIFE2 = new Texture(TEXTURE_PATH + "item/life2.png");
    }

    public static class Fonts {
        public static final Texture TWINBEE = new Texture(TEXTURE_PATH + "font/twinbee.png");
    }

    public void dispose() {
       // TitleScreen.BG.dispose();
        TitleScreen.LOGO.dispose();
        TitleScreen.PUSH_ANY_BUTTON.dispose();

        Player.SHIP0.dispose();
        Player.SHIP0_LEFT.dispose();
        Player.SHIP0_RIGHT.dispose();

        Enemies.ENEMY0.dispose();
        Enemies.ENEMY1.dispose();
        Enemies.PLUNK1.dispose();
        Enemies.BOSS.dispose();
        Enemies.BOSS_HIT.dispose();

        Weapons.LASER1.dispose();
        Weapons.LASER2.dispose();
        Weapons.ENERGY_BLUE.dispose();
        Weapons.ENERGY_RED.dispose();
        Weapons.ENEMY_SLIME.dispose();


        Items.LIFE_UP.dispose();
        Items.WEAPON_UP.dispose();
        Items.SPEED_UP.dispose();
        Items.XSPACE_UP.dispose();
        Items.LIFE1.dispose();
        Items.LIFE2.dispose();

        Fonts.TWINBEE.dispose();
    }

}
