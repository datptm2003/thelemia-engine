package com.deedee.thelemia.scene.component;

import com.badlogic.gdx.math.Vector2;
import com.deedee.thelemia.graphics.ui.IContainer;
import com.deedee.thelemia.scene.IComponent;

public class UIComponent implements IComponent {
    protected IContainer container;
    protected boolean visible = true;
    protected boolean enabled = true;

    public UIComponent(IContainer container) {
        this.container = container;
    }

    @Override
    public void update(float delta) {
        if (enabled) container.update(delta);
        if (visible) container.render();
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
