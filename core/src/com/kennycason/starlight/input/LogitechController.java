package com.kennycason.starlight.input;

import com.badlogic.gdx.controllers.Controllers;
import com.kennycason.starlight.input.controls.Controls;
import com.kennycason.starlight.input.mapping.Axis;
import com.kennycason.starlight.input.mapping.AxisMapper;
import com.kennycason.starlight.input.mapping.ButtonMapper;

/**
 * Created by kenny on 5/22/15.
 */
public class LogitechController<V extends Controls> extends Controller<V> {

    private final com.badlogic.gdx.controllers.Controller controller;

    public LogitechController(final int controllerNumber,
                              final ButtonMapper<V> buttonMapper,
                              final AxisMapper axisMapper) {
        super.buttonMapper = buttonMapper;
        super.axisMapper = axisMapper;

        if(Controllers.getControllers().size < (controllerNumber + 1)) {
            controller = null;
            return;
        }
        controller = Controllers.getControllers().get(controllerNumber);
    }

    @Override
    public boolean isPressed(V control) {
        if (controller == null) { return false; }

        boolean pressed = false;
        if (axisMapper.get(control) != null) {
            final Axis axis = this.axisMapper.get(control);
            if (axis.threshold < 0) {
                pressed = controller.getAxis(axis.id) < axis.threshold;
            }
            if (axis.threshold > 0) {
                pressed = controller.getAxis(axis.id) > axis.threshold;
            }
        }
        else {
            pressed = controller.getButton(buttonMapper.get(control));
        }

        if (pressed) { record(control); }
        return pressed;
    }
}
