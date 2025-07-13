package com.deedee.thelemia.scene.component;

import com.badlogic.gdx.math.Vector2;
import com.deedee.thelemia.core.IGameObject;
import com.deedee.thelemia.scene.IComponent;

public class UIComponent implements IComponent {
    protected IGameObject gameObject;
    protected Vector2 position = new Vector2();
    protected float scale = 1.0f;
    protected boolean visible = true;
    protected boolean enabled = true;

    public UIComponent() {

    }

    @Override
    public void update(float delta) {
        if (!enabled) return;
        gameObject.update(delta);
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

    public boolean isVisible() {
        return visible;
    }
    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public boolean isEnabled() {
        return enabled;
    }
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
