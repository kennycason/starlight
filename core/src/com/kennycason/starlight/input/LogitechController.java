package com.kennycason.starlight.input;

import com.badlogic.gdx.controllers.Controllers;

/**
 * Created by kenny on 5/22/15.
 */
public class LogitechController implements Controller {

    private final InputTimeRecorder inputTimeRecorder = new InputTimeRecorder();

    private com.badlogic.gdx.controllers.Controller controller;

    private final ButtonMapper<Integer> buttonMapper;

    public LogitechController() {
        this(0, ButtonMapper.defaultLogitechButtonMapper());
    }

    public LogitechController(final int controllerNumber, final ButtonMapper<Integer> buttonMapper) {
        this.buttonMapper = buttonMapper;

        if(Controllers.getControllers().size < (controllerNumber + 1)) { return; }
        controller = Controllers.getControllers().get(controllerNumber);
    }

    @Override
    public boolean isUp() {
        if(controller == null) { return false; }
        final boolean pressed = controller.getAxis(1) < -0.75;
        if(pressed) { inputTimeRecorder.recordUp(); }
        return pressed;
    }

    @Override
    public boolean isDown() {
        if(controller == null) { return false; }
        final boolean pressed = controller.getAxis(1) > 0.75;
        if(pressed) { inputTimeRecorder.recordDown(); }
        return pressed;
    }

    @Override
    public boolean isLeft() {
        if(controller == null) { return false; }
        final boolean pressed = controller.getAxis(0) < -0.75;
        if(pressed) { inputTimeRecorder.recordLeft(); }
        return pressed;
    }

    @Override
    public boolean isRight() {
        if(controller == null) { return false; }
        final boolean pressed = controller.getAxis(0) > 0.75;
        if(pressed) { inputTimeRecorder.recordUp(); }
        return pressed;
    }

    @Override
    public boolean isStart() {
        if(controller == null) { return false; }
        final boolean pressed = controller.getButton(buttonMapper.get(Button.START));
        if(pressed) { inputTimeRecorder.recordStart(); }
        return pressed;
    }

    @Override
    public boolean isSelect() {
        if(controller == null) { return false; }
        final boolean pressed = controller.getButton(buttonMapper.get(Button.SELECT));
        if(pressed) { inputTimeRecorder.recordSelect(); }
        return pressed;
    }

    @Override
    public boolean isA() {
        if(controller == null) { return false; }
        final boolean pressed = controller.getButton(buttonMapper.get(Button.A));
        if(pressed) { inputTimeRecorder.recordA(); }
        return pressed;
    }

    @Override
    public boolean isB() {
        if(controller == null) { return false; }
        final boolean pressed = controller.getButton(buttonMapper.get(Button.B));
        if(pressed) { inputTimeRecorder.recordB(); }
        return pressed;
    }

    @Override
    public boolean isX() {
        if(controller == null) { return false; }
        final boolean pressed = controller.getButton(buttonMapper.get(Button.X));
        if(pressed) { inputTimeRecorder.recordX(); }
        return pressed;
    }

    @Override
    public boolean isY() {
        if(controller == null) { return false; }
        final boolean pressed = controller.getButton(buttonMapper.get(Button.Y));
        if(pressed) { inputTimeRecorder.recordUp(); }
        return pressed;
    }

    @Override
    public boolean isL1() {
        if(controller == null) { return false; }
        final boolean pressed = controller.getButton(buttonMapper.get(Button.L1));
        if(pressed) { inputTimeRecorder.recordL1(); }
        return pressed;
    }

    @Override
    public boolean isL2() {
        if(controller == null) { return false; }
        final boolean pressed = controller.getButton(buttonMapper.get(Button.L2));
        if(pressed) { inputTimeRecorder.recordL2(); }
        return pressed;
    }

    @Override
    public boolean isR1() {
        if(controller == null) { return false; }
        final boolean pressed = controller.getButton(buttonMapper.get(Button.R1));
        if(pressed) { inputTimeRecorder.recordR1(); }
        return pressed;
    }

    @Override
    public boolean isR2() {
        if(controller == null) { return false; }
        final boolean pressed = controller.getButton(buttonMapper.get(Button.R2));
        if(pressed) { inputTimeRecorder.recordR2(); }
        return pressed;
    }

    @Override
    public boolean isAny() {
        return isUp() || isDown() || isLeft() || isRight()
                || isSelect() || isStart()
                || isL1() || isL2() || isR1() || isR2()
                || isA() || isB() || isX() || isY();
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
