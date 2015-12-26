package com.kennycason.starlight.entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.kennycason.starlight.StarLight;

/**
 * Created by kenny on 4/24/15.
 */
public class BitmapFont {

    private static final int NUMBER_LETTERS = 36;

    private final StarLight game;

    private final TextureRegion[] letters;

    public final int width;
    public final int height;

    public BitmapFont(final StarLight game, final Texture texture) {
        this.game = game;

        final TextureRegion[][] tmp = TextureRegion.split(texture, texture.getWidth() / NUMBER_LETTERS, texture.getHeight());
        letters = new TextureRegion[NUMBER_LETTERS];

        for (int j = 0; j < NUMBER_LETTERS; j++) {
            letters[j] = tmp[0][j];

        }
        width = letters[0].getRegionWidth();
        height = letters[0].getRegionHeight();
    }

    public void draw(final String text, final int x, int y) {
        for(int i = 0; i < text.length(); i++) {
            final TextureRegion textureRegion = getTextRegion(text.charAt(i));
            if(textureRegion == null) { continue; }
            game.batch.draw(textureRegion, x + (i * width), y);
        }
    }

    private TextureRegion getTextRegion(final char c) {
        int index = -1;
        if(Character.isAlphabetic(c)) {
            if(Character.isUpperCase(c)) {
                index = ((int) c) - 65;
            } else {
                index = ((int) c) - 97;
            }
        } else if(Character.isDigit(c)){
            index = 26 + ((int) c) - 48;
        }
        if(index < 0) {
            return null;
        }
        return letters[index];
    }

}
