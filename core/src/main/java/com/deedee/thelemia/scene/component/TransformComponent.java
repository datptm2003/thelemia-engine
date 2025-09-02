package com.deedee.thelemia.scene.component;

import com.badlogic.gdx.math.Vector2;
import com.deedee.thelemia.scene.Component;
import com.deedee.thelemia.scene.Entity;
import com.deedee.thelemia.scene.enumerate.ComponentGroup;

public class TransformComponent extends Component implements ICoreComponent {
    private Vector2 origin = new Vector2(0.0f, 0.0f);
    private Vector2 position = new Vector2(0.0f,0.0f);
    private Vector2 scale = new Vector2(1.0f, 1.0f);
    private float rotation = 0.0f;

    public TransformComponent(Entity owner) {
        super(owner);
    }

    @Override
    public void reset() {

    }

    @Override
    public ComponentGroup getGroup() {
        return ComponentGroup.CORE;
    }

    public Vector2 getOrigin() {
        return origin;
    }
    public void setOrigin(Vector2 origin) {
        this.origin = origin;
    }

    public Vector2 getPosition() {
        return position;
    }
    public void setPosition(float x, float y) {
        this.position.x = x;
        this.position.y = y;
    }

    public Vector2 getScale() {
        return scale;
    }
    public void setScale(float width, float height) {
        this.scale.x = width;
        this.scale.y = height;
    }

    public float getRotation() {
        return rotation;
    }
    public void setRotation(float rotation) {
        this.rotation = rotation;
    }
}
