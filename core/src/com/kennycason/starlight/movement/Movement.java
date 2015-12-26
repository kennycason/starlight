package com.kennycason.starlight.movement;

import com.kennycason.starlight.entity.Entity;

/**
 * Created by kenny on 4/25/15.
 */
public interface Movement {

    void move(Entity entity, float deltaTime);

}
