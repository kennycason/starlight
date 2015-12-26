package com.kennycason.starlight.level;

import com.badlogic.gdx.math.Vector2;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by kenny on 5/29/15.
 */
public class TestYamlLevelLoader {

    private static final double DELTA = 0.0;

    @Test
    public void meta() {
        final Level level = Level.load(Vector2.Zero, null, null);
        assertEquals(0, level.getPosition().x, DELTA);
        assertEquals(0, level.getPosition().y, DELTA);
        assertEquals(0, level.getVelocity().x, DELTA);
        assertEquals(-10, level.getVelocity().y, DELTA);
        assertEquals(1000, level.length, DELTA);
    }

}
