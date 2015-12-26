package com.kennycason.starlight;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.kennycason.starlight.config.Configuration;

/**
 * Created by kenny on 4/23/15.
 */
public class StarLight extends Game {

    public Configuration config;
    public SpriteBatch batch;
    public BitmapFont font;

    public StarLight(final Configuration config) {
        this.config = config;
    }

    public void create() {
        batch = new SpriteBatch();
        //Use LibGDX's default Arial font.
        font = new BitmapFont();
        this.setScreen(new TitleScreen(this));
    }

    public void render() {
        super.render();
    }

    public void dispose() {
        batch.dispose();
        font.dispose();
    }

}