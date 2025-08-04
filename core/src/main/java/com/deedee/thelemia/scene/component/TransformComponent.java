package com.deedee.thelemia.scene.component;

import com.badlogic.gdx.math.Vector2;
import com.deedee.thelemia.scene.Component;
import com.deedee.thelemia.scene.enumerate.ComponentGroup;

public class TransformComponent extends Component implements ICoreComponent {
    private Vector2 position = new Vector2(0.0f,0.0f);
    private float scale = 1.0f;
    private float rotation = 0.0f;

    public TransformComponent() {

    }

    @Override
    public void update(float delta) {

    }
    @Override
    public void reset() {

    }

    @Override
    public ComponentGroup getGroup() {
        return ComponentGroup.CORE;
    }

    public Vector2 getPosition() {
        return position;
    }
    public void setPosition(Vector2 position) {
        this.position = position;
    }

    public float getScale() {
        return scale;
    }
    public void setScale(float scale) {
        this.scale = scale;
    }

    public float getRotation() {
        return rotation;
    }
    public void setRotation(float rotation) {
        this.rotation = rotation;
    }
}
