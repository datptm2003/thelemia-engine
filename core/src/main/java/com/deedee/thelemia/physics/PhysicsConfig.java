package com.deedee.thelemia.physics;

import com.badlogic.gdx.math.Vector2;

public class PhysicsConfig {
    private final Vector2 gravity;

    public PhysicsConfig(Vector2 gravity) {
        this.gravity = gravity;
    }

    public Vector2 getGravity() {
        return gravity;
    }
}
