package com.deedee.thelemia.graphics.ui;

import com.deedee.thelemia.core.IGameObject;
import com.deedee.thelemia.graphics.ui.behavior.IRenderable;

public abstract class Widget implements IGameObject, IRenderable {
    protected boolean visible = true;
    protected boolean enabled = true;

    public Widget() {

    }

    @Override
    public void create() {

    }
    @Override
    public void start() {

    }
    @Override
    public void update(float delta) {

    }
    @Override
    public void dispose() {

    }

    @Override
    public void render(int x, int y) {

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
