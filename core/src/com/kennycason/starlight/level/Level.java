package com.kennycason.starlight.level;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Vector2;
import com.kennycason.starlight.StarLight;
import com.kennycason.starlight.event.Event;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kenny on 4/26/15.
 */
public class Level {
    public String name;
    public final Vector2 level = new Vector2();

    public final Vector2 position = new Vector2();
    public final Vector2 velocity = new Vector2();
    public final List<Event> events = new ArrayList<>();
    public Event finalEvent;
    public int length;
    public int tileSize = 16;
    public int offsetX;

    public TiledMap map;

    public void render(final StarLight game) {
        offsetX = game.config.height;
    }

}
