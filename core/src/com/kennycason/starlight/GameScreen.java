package com.kennycason.starlight;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.kennycason.starlight.entity.enemy.Enemy;
import com.kennycason.starlight.entity.player.Ship;
import com.kennycason.starlight.entity.weapon.bullet.Bullet;
import com.kennycason.starlight.event.Event;
import com.kennycason.starlight.input.Controller;
import com.kennycason.starlight.input.KeyboardController;
import com.kennycason.starlight.input.LogitechController;
import com.kennycason.starlight.input.MultiController;
import com.kennycason.starlight.item.Item;
import com.kennycason.starlight.level.Level;
import com.kennycason.starlight.level.TmxLevelLoader;
import com.kennycason.starlight.math.Vector;

import java.util.Iterator;

/**
 * Created by kenny on 4/23/15.
 */
public class GameScreen implements Screen {

    public final OrthographicCamera camera; // player Camera

    public final OrthographicCamera mapCamera;
    public final TiledMapRenderer tiledMapRenderer;

    public final Hud hud;
    public final StarLight game;
    public final Ship ship;

    public Level level;

    // these represent the current entities on the screen;
    public final Array<Bullet> bullets = new Array<>();
    public final Array<Bullet> enemyBullets = new Array<>();
    public final Array<Enemy> enemies = new Array<>();
    public final Array<Item> items = new Array<>();

    private Controller controller = new MultiController(new KeyboardController(), new LogitechController());

    private boolean printState = false;

    public GameScreen(final StarLight game) {
        this.game = game;
        ship = new Ship(game);
        hud = new Hud(game);

        //level = YamlLevelLoader.load(Vector2.Zero, game, this);
        level = TmxLevelLoader.load(Vector2.Zero, game, this);

        // create the camera and the SpriteBatch
        camera = new OrthographicCamera();
        camera.setToOrtho(false, game.config.width, game.config.height);
        camera.update();

        mapCamera = new OrthographicCamera();
        mapCamera.setToOrtho(false, game.config.width, game.config.height);
        mapCamera.translate(0, -game.config.height);
        mapCamera.update();
        tiledMapRenderer = new OrthogonalTiledMapRenderer(level.map);
    }

    @Override
    public void render(float delta) {
        if(printState) {
            System.out.println("bullets: " + bullets.size + ", enemyBullets: " + enemyBullets.size + ", enemies: " + enemies.size + ", items: " + items.size);
        }
        final float deltaTime = Gdx.graphics.getDeltaTime();

        Gdx.gl.glClearColor(0, 0, 0.0f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();

        mapCamera.translate(0, level.velocity.y * deltaTime);
        mapCamera.update();
        tiledMapRenderer.setView(mapCamera);
        tiledMapRenderer.render();

        game.batch.setProjectionMatrix(camera.combined);
        game.batch.begin();

        ship.draw();
        for(Bullet bullet : bullets) {
            bullet.draw();
        }
        for(Item item : items) {
            item.draw();
        }
        for(Enemy enemy : enemies) {
            enemy.draw();
        }
        for(Bullet bullet : enemyBullets) {
            bullet.draw();
        }

        hud.draw(this);
        game.batch.end();

        handleInput(deltaTime);
        handleEvents();
        handleLevel(deltaTime);
        handleBullets(deltaTime);
        handleEnemyBullets(deltaTime);
        handleItems(deltaTime);
        handleEnemies(deltaTime);
    }

    private void handleLevel(final float deltaTime) {
        if(level.position.y >= level.length) {
            if(level.finalEvent == null) { return; }
            level.finalEvent.happen();
            level.velocity.x = 0;
            level.velocity.y = 0;
            level.finalEvent = null;
        }
        level.position.x += level.velocity.x * deltaTime;
        level.position.y += level.velocity.y * deltaTime;
    }

    private void handleEvents() {
        if(level.events.isEmpty()) { return; }

        Iterator<Event> eventIterator = level.events.iterator();
        while(eventIterator.hasNext()) {
            final Event event = eventIterator.next();
            if(event.isReady()) {
                event.happen();
                eventIterator.remove();
            }
//            } else { // events should be in a timely order
//                return;
//            }
        }
    }

    private void handleItems(final float deltaTime) {
        if(items.size == 0) { return; }

        final Iterator<Item> itemIterator = items.iterator();
        while(itemIterator.hasNext()) {
            final Item item = itemIterator.next();
            item.move(-level.velocity.x * deltaTime, -level.velocity.y * deltaTime);

            if(item.overlaps(ship)) {
                item.use();
                itemIterator.remove();
            } else if(item.y < 0) {
                itemIterator.remove();
            }
        }
    }

    private void handleEnemies(final float deltaTime) {
        if(enemies.size == 0) { return; }

        final Iterator<Enemy> enemyIterator = enemies.iterator();

        while(enemyIterator.hasNext()) {
            final Enemy enemy = enemyIterator.next();
            enemy.move(-level.velocity.x * deltaTime, -level.velocity.y * deltaTime);

            enemy.handle(deltaTime, this);

            if(enemy.overlaps(ship)) {
                ship.hit(enemy);
            }

            if(enemy.expire) {
                if(enemy.life < 1) {
                    ship.score += enemy.score;
                }
                enemyIterator.remove();
            }
        }
    }

    private void handleEnemyBullets(final float deltaTime) {
        if(enemyBullets.size == 0) { return; }

        final Iterator<Bullet> bulletIterator = enemyBullets.iterator();
        while(bulletIterator.hasNext()) {
            final Bullet bullet = bulletIterator.next();
            bullet.move(-level.velocity.x * deltaTime, -level.velocity.y * deltaTime);

            bullet.handle(deltaTime);

            if(bullet.overlaps(ship)) {
                ship.hit(bullet);
            }

            if(bullet.expire) {
                bulletIterator.remove();
            }
        }
    }

    private void handleBullets(final float deltaTime) {
        if(bullets.size == 0) { return; }

        final Iterator<Bullet> bulletIterator = bullets.iterator();
        while(bulletIterator.hasNext()) {
            final Bullet bullet = bulletIterator.next();
            bullet.move(-level.velocity.x * deltaTime, -level.velocity.y * deltaTime);

            bullet.handle(deltaTime);

            collideBulletsAndEnemies(bullet, enemies);

            if(bullet.expire) {
                bulletIterator.remove();
            }
        }
    }

    private static void collideBulletsAndEnemies(final Bullet bullet, final Array<Enemy> enemies) {
        if(enemies.size == 0) { return; }

        final Iterator<Enemy> enemyIterator = enemies.iterator();

        // collide with enemy
        while(enemyIterator.hasNext()) {
            final Enemy enemy = enemyIterator.next();
            if(enemy.overlaps(bullet)) {
                enemy.hit(bullet);
                bullet.expire = true;
                break;
            }
        }
    }

    private void handleInput(final float deltaTime) {
        // process user input
        ship.vx = 0;
        ship.vy = 0;

        if (controller.isLeft()) {
            ship.vx = -deltaTime;
        }
        if (controller.isRight()) {
            ship.vx = deltaTime;
        }
        if (controller.isUp()) {
            ship.vy = deltaTime;
        }
        if (controller.isDown()) {
            ship.vy = -deltaTime;
        }
        if (controller.isL1()) {
            ship.weaponScrollLeft();
        }
        if (controller.isR1()) {
            ship.weaponScrollRight();
        }
        if (controller.isSelect()) {
            game.setScreen(new GameScreen(game));
        }
        float[] v = Vector.unit2d(ship.vx, ship.vy);
        ship.vx = v[0] * ship.speed;
        ship.vy = v[1] * ship.speed;
        ship.handle(this);

        if (controller.isA()) {
            ship.shoot(this);
        }
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void show() {
        //Sounds.DEPARTURE_FOR_SPACE.play();
    }

    @Override
    public void hide() {
        //Sounds.DEPARTURE_FOR_SPACE.stop();
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void dispose() {
    }

}
