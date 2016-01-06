package com.kennycason.starlight.input;

import com.kennycason.starlight.input.controls.Controls;

/**
 * Created by kenny on 1/5/16.
 */
public class MultiplexedController<V extends Controls> extends Controller<V> {

    private final Controller[] controllers;

    public MultiplexedController(final Controller... controllers) {
        this.controllers = controllers;
    }

    public boolean isPressed(final V control) {
        for (Controller controller : controllers) {
            if (controller.isPressed(control)) {
                return true;
            }
        }
        return false;
    }

    public long whenPressed(final V control) {
        for (Controller controller : controllers) {
            final long when = controller.when(control);
            if (when > 0) {
                return when;
            }
        }
        return 0L;
    }

}