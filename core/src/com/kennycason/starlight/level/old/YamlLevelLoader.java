package com.kennycason.starlight.level.old;

import com.badlogic.gdx.math.Vector2;
import com.kennycason.starlight.GameScreen;
import com.kennycason.starlight.StarLight;
import com.kennycason.starlight.entity.Entity;
import com.kennycason.starlight.entity.enemy.Enemy;
import com.kennycason.starlight.event.Event;
import com.kennycason.starlight.event.LevelProgressionEnemyDeploy;
import com.kennycason.starlight.level.Level;
import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by kenny on 4/26/15.
 */
public class YamlLevelLoader {

    public static Level load(final Vector2 position, final StarLight game, final GameScreen gameScreen) {
        final List<Object> objects = loadYaml(position);
        final Level level = new Level();
        setDefaults(level);
        for(Object object : objects) {
            Map<String, Object> data = (Map<String, Object>) object;
            if(data.containsKey("meta")) {
                readMeta(level, data);
            }
            else if(data.containsKey("events")) {
                readEvents(level, data, game, gameScreen);
            }
            else if(data.containsKey("final")) {
                readFinalEvent(level, data, game, gameScreen);
            }
        }

        return level;
    }

    private static void readFinalEvent(final Level level, final Map<String, Object> data, final StarLight game, final GameScreen gameScreen) {
        final String clazz = "com.kennycason.starlight.level.events." + data.get("final");
        try {
            level.finalEvent = (Event) Class.forName(clazz).getConstructor(StarLight.class, GameScreen.class).newInstance(game, gameScreen);
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static void readEvents(final Level level, final Map<String, Object> data, final StarLight game, final GameScreen gameScreen) {
        final Iterable<Object> events = (Iterable<Object>) data.get("events");
        for(Object eventObj : events) {
            Map<String, Object> event = (Map<String, Object>) eventObj;
            final String type = (String) event.get("type");
            switch (type) {
                case "enemy":
                    final Enemy enemy = readEnemy(event, game);
                    final Event enemyEvent = readEnemyEvent(enemy, gameScreen, event);
                    level.events.add(enemyEvent);
                    break;
            }

        }
    }

    private static Event readEnemyEvent(final Enemy enemy, final GameScreen gameScreen, final Map<String, Object> event) {
        Map<String, Object> spawn = (Map<String, Object>) event.get("spawn");
        final int spawnYOffset = (int) spawn.get("y");
        return new LevelProgressionEnemyDeploy(gameScreen, spawnYOffset, enemy);
    }

    private static Enemy readEnemy(Map<String, Object> event, final StarLight game) {
        final String clazz = "com.kennycason.starlight.entity.enemy." + event.get("class");
        try {
            final Enemy enemy = (Enemy) Class.forName(clazz).getConstructor(StarLight.class).newInstance(game);
            readEntityPosition(enemy, event);
            return enemy;
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static void readMeta(final Level level, final Map<String, Object> data) {
        final Map<String, Object> meta = (Map<String, Object>) data.get("meta");
        readVector(level.position, meta.get("position"));
        readVector(level.velocity, meta.get("velocity"));
        level.length = (int) meta.get("length");
    }

    private static void readVector(final Vector2 vector2, Object vectorMapObj) {
        final Map<String, Object> vectorMap = (Map<String, Object>) vectorMapObj;
        vector2.x = (int) vectorMap.get("x");
        vector2.y = (int) vectorMap.get("y");
    }

    private static void readEntityPosition(final Entity entity, Map<String, Object> event) {
        final Map<String, Object> position = (Map<String, Object>) event.get("position");
        entity.locate((int) position.get("x"), (int) position.get("y"));
    }

    private static void setDefaults(final Level level) {
        level.position.set(0, 0);
        level.velocity.set(0, 0);
    }

    private static List<Object> loadYaml(final Vector2 position) {
        final String resource = "levels/" + (int)position.x + "_" + (int)position.y + ".yml";
        final InputStream input = Thread.currentThread().getContextClassLoader().getResourceAsStream(resource);
        final Yaml yaml = new Yaml();
        final List<Object> objects = new ArrayList<>();
        for(Object object : yaml.loadAll(input)) {
            objects.add(object);
        }
        return objects;
    }

}
