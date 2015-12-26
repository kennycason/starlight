package com.kennycason.starlight.level;

import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.MapProperties;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.kennycason.starlight.GameScreen;
import com.kennycason.starlight.StarLight;
import com.kennycason.starlight.entity.Entity;
import com.kennycason.starlight.entity.enemy.Enemy;
import com.kennycason.starlight.event.Event;
import com.kennycason.starlight.event.LevelProgressionEnemyDeploy;

/**
 * Created by kenny on 4/26/15.
 */
public class TmxLevelLoader {

    public static Level load(final Vector2 gridPosition, final StarLight game, final GameScreen gameScreen) {
        final TiledMap map = loadMap(gridPosition);
        final Level level = new Level();
        setDefaults(level);
        level.name = (String) map.getProperties().get("name");
        level.level.set(gridPosition.x, gridPosition.y);

        final TiledMapTileLayer tiledMapTileLayer = (TiledMapTileLayer) map.getLayers().get("tiles");

        final MapLayer objectLayer = map.getLayers().get("objects");

        final MapObjects allObjects = objectLayer.getObjects();
        final Array<RectangleMapObject> objects = allObjects.getByType(RectangleMapObject.class);

        level.map = map;
        level.length =  tiledMapTileLayer.getHeight() * level.tileSize;
        level.velocity.set(0, 32);

        for(RectangleMapObject object : objects) {
            final MapProperties properties = object.getProperties();
            final String type = (String) properties.get("type");
            switch(type) {
                case "enemy":
                    final Enemy enemy = readEnemy(object, game);
                    final Event enemyEvent = readEnemyEvent(enemy, gameScreen, game, object);
                    level.events.add(enemyEvent);
                    break;
            }
//            else if(data.containsKey("events")) {
//                readEvents(level, data, game, gameScreen);
//            }
        }

        final String clazz = "com.kennycason.starlight.level.events." + map.getProperties().get("final");
        try {
            level.finalEvent = (Event) Class.forName(clazz).getConstructor(StarLight.class, GameScreen.class).newInstance(game, gameScreen);
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }

        return level;
    }

    private static Event readEnemyEvent(final Enemy enemy, final GameScreen gameScreen, final StarLight game, final RectangleMapObject object) {
        final int spawnYOffset = (int) enemy.y;
        enemy.move(0, game.config.height);
        return new LevelProgressionEnemyDeploy(gameScreen, spawnYOffset, enemy);
    }

    private static Enemy readEnemy(final RectangleMapObject object, final StarLight game) {
        final String clazz = "com.kennycason.starlight.entity.enemy." + object.getName();
        try {
            final Enemy enemy = (Enemy) Class.forName(clazz).getConstructor(StarLight.class).newInstance(game);
            readEntityPosition(enemy, object);
            return enemy;
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static void readEntityPosition(final Entity entity, final RectangleMapObject object) {
        entity.locate((float) object.getProperties().get("x"), (float) object.getProperties().get("y"));
    }

    private static void setDefaults(final Level level) {
        level.position.set(0, 0);
        level.velocity.set(0, 0);
    }

    private static TiledMap loadMap(final Vector2 gridPosition) {
        final String resource = "core/resources/levels/" + (int) gridPosition.x + "_" + (int) gridPosition.y + ".tmx";
        final TmxMapLoader tmxMapLoader = new TmxMapLoader(new InternalFileHandleResolver());
        return tmxMapLoader.load(resource);
    }

}
