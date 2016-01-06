package com.kennycason.starlight;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.TimeUtils;
import com.kennycason.starlight.input.Controller;
import com.kennycason.starlight.input.StarLightControllerFactory;
import com.kennycason.starlight.input.controls.GameControls;
import com.kennycason.starlight.resources.Sounds;
import com.kennycason.starlight.resources.Textures;

/**
 * Created by kenny on 4/23/15.
 */
public class GameOverScreen implements Screen {

    private final StarLight game;

    private final OrthographicCamera camera;

    private long startTime = 0;

    private Controller<GameControls> controller = StarLightControllerFactory.buildMultiController();


    public GameOverScreen(final StarLight game) {
        this.game = game;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, game.config.width, game.config.height);
        startTime = TimeUtils.millis();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0.0f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        game.batch.setProjectionMatrix(camera.combined);

        game.batch.begin();
        game.batch.draw(Textures.TitleScreen.GAMEOVER, game.config.width / 2 - Textures.TitleScreen.GAMEOVER.getWidth() / 2, game.config.height - 100);
        game.batch.draw(Textures.TitleScreen.PUSH_ANY_BUTTON, game.config.width / 2 - Textures.TitleScreen.PUSH_ANY_BUTTON.getWidth() / 2, 150);
        game.batch.end();

        if(TimeUtils.timeSinceMillis(startTime) > 500) {
            if (controller.isPressed(GameControls.START)
                    || controller.isPressed(GameControls.A)
                    || controller.isPressed(GameControls.B)) {
                game.setScreen(new TitleScreen(game));
                dispose();
            }
        }
    }

    @Override
    public void resize(final int width, final int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void show() {
        Sounds.GAME_OVER.play();
    }

    @Override
    public void hide() {
        Sounds.GAME_OVER.stop();
    }

    @Override
    public void dispose() {
    }

}