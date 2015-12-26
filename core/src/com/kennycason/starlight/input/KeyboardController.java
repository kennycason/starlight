package com.kennycason.starlight.input;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

/**
 * Created by kenny on 5/22/15.
 */
public class KeyboardController implements Controller {

    private final InputTimeRecorder inputTimeRecorder = new InputTimeRecorder();

    private final ButtonMapper<Integer> buttonMapper;

    public KeyboardController() {
        this(ButtonMapper.defaultKeyboardMapper());
    }

    public KeyboardController(final ButtonMapper<Integer> buttonMapper) {
        this.buttonMapper = buttonMapper;
    }

    @Override
    public boolean isUp() {
        final boolean pressed = Gdx.input.isKeyPressed(buttonMapper.get(Button.DPAD_UP));
        if(pressed) { inputTimeRecorder.recordUp(); }
        return pressed;
    }

    @Override
    public boolean isDown() {
        final boolean pressed = Gdx.input.isKeyPressed(buttonMapper.get(Button.DPAD_DOWN));
        if(pressed) { inputTimeRecorder.recordDown(); }
        return pressed;
    }

    @Override
    public boolean isLeft() {
        final boolean pressed = Gdx.input.isKeyPressed(buttonMapper.get(Button.DPAD_LEFT));
        if(pressed) { inputTimeRecorder.recordLeft(); }
        return pressed;
    }

    @Override
    public boolean isRight() {
        final boolean pressed = Gdx.input.isKeyPressed(buttonMapper.get(Button.DPAD_RIGHT));
        if(pressed) { inputTimeRecorder.recordUp(); }
        return pressed;
    }

    @Override
    public boolean isStart() {
        final boolean pressed = Gdx.input.isKeyPressed(buttonMapper.get(Button.START));
        if(pressed) { inputTimeRecorder.recordStart(); }
        return pressed;
    }

    @Override
    public boolean isSelect() {
        final boolean pressed =Gdx.input.isKeyPressed(buttonMapper.get(Button.SELECT));
        if(pressed) { inputTimeRecorder.recordSelect(); }
        return pressed;
    }

    @Override
    public boolean isA() {
        final boolean pressed = Gdx.input.isKeyPressed(buttonMapper.get(Button.A));
        if(pressed) { inputTimeRecorder.recordA(); }
        return pressed;
    }

    @Override
    public boolean isB() {
        final boolean pressed = Gdx.input.isKeyPressed(buttonMapper.get(Button.B));
        if(pressed) { inputTimeRecorder.recordB(); }
        return pressed;
    }

    @Override
    public boolean isX() {
        final boolean pressed = Gdx.input.isKeyPressed(buttonMapper.get(Button.X));
        if(pressed) { inputTimeRecorder.recordX(); }
        return pressed;
    }

    @Override
    public boolean isY() {
        final boolean pressed = Gdx.input.isKeyPressed(buttonMapper.get(Button.Y));
        if(pressed) { inputTimeRecorder.recordUp(); }
        return pressed;
    }

    @Override
    public boolean isL1() {
        final boolean pressed = Gdx.input.isKeyPressed(buttonMapper.get(Button.L1));
        if(pressed) { inputTimeRecorder.recordL1(); }
        return pressed;
    }

    @Override
    public boolean isL2() {
        final boolean pressed = Gdx.input.isKeyPressed(buttonMapper.get(Button.L2));
        if(pressed) { inputTimeRecorder.recordL2(); }
        return pressed;
    }

    @Override
    public boolean isR1() {
        final boolean pressed = Gdx.input.isKeyPressed(buttonMapper.get(Button.R1));
        if(pressed) { inputTimeRecorder.recordR1(); }
        return pressed;
    }

    @Override
    public boolean isR2() {
        final boolean pressed = Gdx.input.isKeyPressed(buttonMapper.get(Button.R2));
        if(pressed) { inputTimeRecorder.recordR2(); }
        return pressed;
    }

    @Override
    public boolean isAny() {
        return Gdx.input.isTouched() || Gdx.input.isKeyPressed(Input.Keys.ANY_KEY);
    }

    @Override
    public long whenUp() {
        return inputTimeRecorder.whenUp();
    }

    @Override
    public long whenDown() {
        return inputTimeRecorder.whenDown();
    }

    @Override
    public long whenLeft() {
        return inputTimeRecorder.whenLeft();
    }

    @Override
    public long whenRight() {
        return inputTimeRecorder.whenRight();
    }

    @Override
    public long whenStart() {
        return inputTimeRecorder.whenStart();
    }

    @Override
    public long whenSelect() {
        return inputTimeRecorder.whenSelect();
    }

    @Override
    public long whenA() {
        return inputTimeRecorder.whenA();
    }

    @Override
    public long whenB() {
        return inputTimeRecorder.whenB();
    }

    @Override
    public long whenX() {
        return inputTimeRecorder.whenX();
    }

    @Override
    public long whenY() {
        return inputTimeRecorder.whenY();
    }

    @Override
    public long whenL1() {
        return inputTimeRecorder.whenL1();
    }

    @Override
    public long whenL2() {
        return inputTimeRecorder.whenL2();
    }

    @Override
    public long whenR1() {
        return inputTimeRecorder.whenR1();
    }

    @Override
    public long whenR2() {
        return inputTimeRecorder.whenR2();
    }

}
