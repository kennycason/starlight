package com.kennycason.starlight.input.mapping;

import com.badlogic.gdx.utils.ObjectMap;
import com.kennycason.starlight.input.controls.Controls;

/**
 * Created by kenny on 5/27/15.
 */
public class ButtonMapper<V extends Controls> {

    private final ObjectMap<V, Integer> mapping = new ObjectMap<>();

    public ButtonMapper() {}

    public void map(V control, Integer mapping) {
        this.mapping.put(control, mapping);
    }

    public final Integer get(V control) {
        return mapping.get(control, -1);
    }

}
