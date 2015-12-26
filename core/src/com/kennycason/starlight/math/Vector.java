package com.kennycason.starlight.math;

/**
 * Created by kenny on 4/23/15.
 */
public class Vector {

    public static final float[] ZERO_2D = new float[] {0.0f, 0.0f};

    public static float[] unit2d(float x, float y) {
        final float magnitude = (float) Math.sqrt(x * x + y * y);
        if(magnitude == 0) { return ZERO_2D; }

        return new float[] {
                x / magnitude,
                y / magnitude
        };
    }

}
