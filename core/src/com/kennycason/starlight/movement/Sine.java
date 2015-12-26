package com.kennycason.starlight.movement;

import com.kennycason.starlight.entity.Entity;

/**
 * Created by kenny on 4/25/15.
 */
public class Sine implements Movement {

    private float vy;
    private float amp;
    private float freq;
    private float totalTime;

    public Sine(final float vy, final float amp, final float freq) {
        this.vy = vy;
        this.amp = amp;
        this.freq = freq;
    }

    @Override
    public void move(final Entity entity, final float deltaTime) {
        totalTime += deltaTime * freq;

        entity.move((float)Math.sin(totalTime) * amp, vy * deltaTime);
    }

}
