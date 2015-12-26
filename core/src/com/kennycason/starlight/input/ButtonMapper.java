package com.kennycason.starlight.input;

import com.badlogic.gdx.Input;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by kenny on 5/27/15.
 */
public class ButtonMapper<V> {

    private final Map<Button, V> buttonMap = new HashMap<>();

    public V get(final Button button) {
        return buttonMap.get(button);
    }

    public void map(final Button button, final V value) {
        buttonMap.put(button, value);
    }

    public static ButtonMapper<Integer> defaultKeyboardMapper() {
        final ButtonMapper<Integer> buttonMapper = new ButtonMapper<>();
        buttonMapper.map(Button.DPAD_UP, Input.Keys.UP);
        buttonMapper.map(Button.DPAD_DOWN, Input.Keys.DOWN);
        buttonMapper.map(Button.DPAD_LEFT, Input.Keys.LEFT);
        buttonMapper.map(Button.DPAD_RIGHT, Input.Keys.RIGHT);

        buttonMapper.map(Button.START, Input.Keys.ENTER);
        buttonMapper.map(Button.SELECT, Input.Keys.SHIFT_RIGHT);

        buttonMapper.map(Button.A, Input.Keys.Z);
        buttonMapper.map(Button.B, Input.Keys.X);
        buttonMapper.map(Button.X, Input.Keys.A);
        buttonMapper.map(Button.Y, Input.Keys.S);

        buttonMapper.map(Button.L1, Input.Keys.Q);
        buttonMapper.map(Button.L2, Input.Keys.W);
        buttonMapper.map(Button.R1, Input.Keys.C);
        buttonMapper.map(Button.R2, Input.Keys.D);

        return buttonMapper;
    }

    public static ButtonMapper<Integer> defaultLogitechButtonMapper() {
        final ButtonMapper<Integer> buttonMapper = new ButtonMapper<>();
        // dpad buttons are read from axis's, not button codes directly
        // consider allowing axis's to be configured.

        buttonMapper.map(Button.START, 9);
        buttonMapper.map(Button.SELECT, 8);

        buttonMapper.map(Button.A, 1);
        buttonMapper.map(Button.B, 2);
        buttonMapper.map(Button.X, 0);
        buttonMapper.map(Button.Y, 3);

        // left joystick pressed 10
        // right joystick pressed 11

        buttonMapper.map(Button.L1, 4);
        buttonMapper.map(Button.L2, 6);
        buttonMapper.map(Button.R1, 5);
        buttonMapper.map(Button.R2, 7);

        return buttonMapper;
    }

}
