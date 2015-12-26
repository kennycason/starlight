package com.kennycason.starlight.entity.sprite;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.kennycason.starlight.StarLight;
import com.kennycason.starlight.entity.Entity;

/**
 * Created by kenny on 4/23/15.
 */
public class AnimatedSprite extends Entity {

    private final Animation animation;
    private final TextureRegion[] animationFrames;

    private TextureRegion currentFrame;
    private float stateTime;
    private boolean looping = true;
    private float animationSpeed = 0.025f;

    public AnimatedSprite(final StarLight game, final Texture texture, final int columns) {
        this(game, texture, 1, columns);
    }

    public AnimatedSprite(final StarLight game, final Texture texture, final int rows, final int columns) {
        super(game);
        final TextureRegion[][] tmp = TextureRegion.split(texture, texture.getWidth() / columns, texture.getHeight() / rows);
        animationFrames = new TextureRegion[rows * columns];

        int index = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                animationFrames[index++] = tmp[i][j];
            }
        }
        width = animationFrames[0].getRegionWidth();
        height = animationFrames[0].getRegionHeight();
        animation = new Animation(animationSpeed, animationFrames);
    }

    @Override
    public void draw() {
        stateTime += Gdx.graphics.getDeltaTime();
        currentFrame = animation.getKeyFrame(stateTime, looping);

        game.batch.draw(currentFrame, this.x, this.y);
    }

    @Override
    public void locate(final float x, final float y) {
        super.locate(x, y);
    }


    public boolean isLooping() {
        return looping;
    }

    public void setLooping(final boolean looping) {
        this.looping = looping;
    }

    public float getAnimationSpeed() {
        return animationSpeed;
    }

    public void setAnimationSpeed(final float animationSpeed) {
        this.animationSpeed = animationSpeed;
        animation.setFrameDuration(animationSpeed);
    }

    public void setPlayMode(final Animation.PlayMode playMode) {
        this.animation.setPlayMode(playMode);
    }

}
