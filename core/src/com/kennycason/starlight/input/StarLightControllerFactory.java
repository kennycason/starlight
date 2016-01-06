package com.kennycason.starlight.input;

import com.badlogic.gdx.Input;
import com.kennycason.starlight.input.controls.GameControls;
import com.kennycason.starlight.input.mapping.Axis;
import com.kennycason.starlight.input.mapping.AxisMapper;
import com.kennycason.starlight.input.mapping.ButtonMapper;

/**
 * Created by kenny on 1/5/16.
 */
public class StarLightControllerFactory {

    public static MultiplexedController<GameControls> buildMultiController() {
        return new MultiplexedController<>(buildKeyboard(), buildLogitech());
    }

    public static KeyboardController<GameControls> buildKeyboard() {
        final ButtonMapper<GameControls> buttonMapper = new ButtonMapper<>();
        buttonMapper.map(GameControls.DPAD_UP, Input.Keys.UP);
        buttonMapper.map(GameControls.DPAD_DOWN, Input.Keys.DOWN);
        buttonMapper.map(GameControls.DPAD_LEFT, Input.Keys.LEFT);
        buttonMapper.map(GameControls.DPAD_RIGHT, Input.Keys.RIGHT);

        buttonMapper.map(GameControls.START, Input.Keys.ENTER);
        buttonMapper.map(GameControls.SELECT, Input.Keys.SHIFT_RIGHT);

        buttonMapper.map(GameControls.A, Input.Keys.Z);
        buttonMapper.map(GameControls.B, Input.Keys.X);
        buttonMapper.map(GameControls.X, Input.Keys.A);
        buttonMapper.map(GameControls.Y, Input.Keys.S);

        buttonMapper.map(GameControls.L1, Input.Keys.Q);
        buttonMapper.map(GameControls.L2, Input.Keys.W);
        buttonMapper.map(GameControls.R1, Input.Keys.C);
        buttonMapper.map(GameControls.R2, Input.Keys.D);

        return new KeyboardController<>(buttonMapper);
    }

    public static LogitechController<GameControls> buildLogitech() {
        final ButtonMapper<GameControls> buttonMapper = new ButtonMapper<>();
        // dpad buttons are read from axis's, not button codes directly
        // consider allowing axis's to be configured.

        buttonMapper.map(GameControls.START, 9);
        buttonMapper.map(GameControls.SELECT, 8);

        buttonMapper.map(GameControls.A, 1);
        buttonMapper.map(GameControls.B, 2);
        buttonMapper.map(GameControls.X, 0);
        buttonMapper.map(GameControls.Y, 3);

        // left joystick pressed 10
        // right joystick pressed 11

        buttonMapper.map(GameControls.L1, 4);
        buttonMapper.map(GameControls.L2, 6);
        buttonMapper.map(GameControls.R1, 5);
        buttonMapper.map(GameControls.R2, 7);

        final AxisMapper<GameControls> axisMapper = new AxisMapper<>();
        axisMapper.map(GameControls.DPAD_UP, new Axis(1, -0.75f));
        axisMapper.map(GameControls.DPAD_DOWN, new Axis(1, 0.75f));
        axisMapper.map(GameControls.DPAD_LEFT, new Axis(0, -0.75f));
        axisMapper.map(GameControls.DPAD_RIGHT, new Axis(0, 0.75f));

        return new LogitechController<>(0, buttonMapper, axisMapper);
    }

}
