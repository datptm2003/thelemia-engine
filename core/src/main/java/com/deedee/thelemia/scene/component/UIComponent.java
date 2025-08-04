package com.deedee.thelemia.scene.component;

import com.deedee.thelemia.graphics.ui.IContainer;
import com.deedee.thelemia.scene.Component;
import com.deedee.thelemia.scene.enumerate.ComponentGroup;

public class UIComponent extends Component implements IGraphicsComponent {
    private IContainer container;
    private boolean visible = true;

    public UIComponent(IContainer container) {
        this.container = container;
        this.container.create();
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
    public void dispose() {
        container.dispose();
    }

    @Override
    public void render(int x, int y) {
        if (!visible) return;

        container.render(x, y);
    }

    @Override
    public boolean isVisible() {
        return visible;
    }
    @Override
    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    @Override
    public ComponentGroup getGroup() {
        return ComponentGroup.GRAPHICS;
    }

    @Override
    public IContainer getContainer() {
        return container;
    }
    @Override
    public void setContainer(IContainer container) {
        this.container = container;
    }

}
