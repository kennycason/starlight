package com.kennycason.starlight.entity.sprite;

import com.badlogic.gdx.graphics.Texture;
import com.kennycason.starlight.StarLight;
import com.kennycason.starlight.entity.Entity;

/**
 * Created by kenny on 4/23/15.
 */
public class SimpleSprite extends Entity {

    private Texture texture;

    public SimpleSprite(final StarLight game, final Texture texture) {
        super(game);
        this.texture = texture;
    }

    @Override
    public void draw() {
        game.batch.draw(texture, this.x, this.y);
    }

    @Override
    public void locate(final float x, final float y) {
        super.locate(x, y);
    }

}
