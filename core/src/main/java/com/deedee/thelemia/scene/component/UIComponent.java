package com.deedee.thelemia.scene.component;

import com.badlogic.gdx.math.Vector2;
import com.deedee.thelemia.graphics.ui.IContainer;

public class UIComponent implements IGraphicsComponent {
    protected IContainer container;
    protected boolean visible = true;
    protected boolean enabled = true;

    public UIComponent(IContainer container) {
        this.container = container;
    }

    @Override
    public void update(float delta) {
        if (!enabled) return;

        container.update(delta);
    }
    @Override
    public void reset() {
        visible = true;
        enabled = true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
    @Override
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public void render() {
        if (!visible) return;

        container.render();
    }

    @Override
    public boolean isVisible() {
        return visible;
    }
    @Override
    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public IContainer getContainer() {
        return container;
    }
    public void setContainer(IContainer container) {
        this.container = container;
    }

}
