package com.kennycason.starlight.event;

import com.kennycason.starlight.GameScreen;

/**
 * Created by kenny on 4/26/15.
 */
public abstract class LevelProgressionEvent extends Event {

    // the y offset of the level required to trigger the event.
    public long yOffset;

    public LevelProgressionEvent(final GameScreen gameScreen, final long yOffset) {
        super(gameScreen);
        this.yOffset = yOffset;
    }

    public boolean isReady() {
        // System.out.println(gameScreen.level.position.y + " " + yOffset);
        return gameScreen.level.position.y >= yOffset;
    }

    public abstract void happen();

}
