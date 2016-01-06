package com.kennycason.starlight.input;

import com.badlogic.gdx.Gdx;
import com.kennycason.starlight.input.controls.Controls;
import com.kennycason.starlight.input.mapping.ButtonMapper;

/**
 * Created by kenny on 5/22/15.
 */
public class KeyboardController<V extends Controls> extends Controller<V> {

    public KeyboardController(final ButtonMapper<V> buttonMapper) {
        super.buttonMapper = buttonMapper;
    }

    @Override
    public boolean isPressed(V control) {
        final boolean pressed = Gdx.input.isKeyPressed(buttonMapper.get(control));
        if (pressed) { record(control); }
        return pressed;
    }

}
