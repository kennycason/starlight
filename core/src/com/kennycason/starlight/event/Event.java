package com.kennycason.starlight.event;

import com.kennycason.starlight.GameScreen;

/**
 * Created by kenny on 4/26/15.
 */
public abstract class Event {

    public GameScreen gameScreen;

    public Event(final GameScreen gameScreen) {
        this.gameScreen = gameScreen;
    }

    public abstract boolean isReady();

    public abstract void happen();


}
