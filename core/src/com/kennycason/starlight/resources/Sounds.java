package com.kennycason.starlight.resources;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;

/**
 * Created by kenny on 4/25/15.
 */
public class Sounds {

    public static final String MUSIC_PATH = "core/resources/sounds/";

    public static final Music PRELUDE_OF_LEGEND = Gdx.audio.newMusic(Gdx.files.internal(MUSIC_PATH + "01-prelude-of-legend.mp3"));
    static { PRELUDE_OF_LEGEND.setLooping(true); }

    public static final Music INVITATION = Gdx.audio.newMusic(Gdx.files.internal(MUSIC_PATH + "02-invitation.mp3"));
    static { INVITATION.setLooping(true); }

    public static final Music DEPARTURE_FOR_SPACE = Gdx.audio.newMusic(Gdx.files.internal(MUSIC_PATH + "03-departure-for-space.mp3"));
    static { DEPARTURE_FOR_SPACE.setLooping(true); }

    public static final Music SAND_STORM = Gdx.audio.newMusic(Gdx.files.internal(MUSIC_PATH + "04-sand-storm.mp3"));
    static { SAND_STORM.setLooping(true); }

    public static final Music GAME_OVER = Gdx.audio.newMusic(Gdx.files.internal(MUSIC_PATH + "26-game-over.mp3"));
    static { GAME_OVER.setLooping(true); }



    public void dispose() {
        PRELUDE_OF_LEGEND.dispose();
        INVITATION.dispose();
        DEPARTURE_FOR_SPACE.dispose();
        SAND_STORM.dispose();
        GAME_OVER.dispose();

    }
}
