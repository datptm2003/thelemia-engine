package com.deedee.thelemia.scene.component;

import com.deedee.thelemia.graphics.IContainer;
import com.deedee.thelemia.graphics.sprite.Animation;
import com.deedee.thelemia.scene.Component;
import com.deedee.thelemia.scene.enumerate.ComponentGroup;

public class SpriteComponent extends Component implements IGraphicsComponent {
    private IContainer container;
    private boolean visible = true;

    private Animation animation;

    public SpriteComponent(IContainer container, Animation animation) {
        this.container = container;
        this.animation = animation;

        this.container.create();
    }
    public SpriteComponent(IContainer container) {
        this.container = container;
        this.animation = new Animation();

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

    public Animation getAnimation() {
        return animation;
    }
    public void setAnimation(Animation animation) {
        this.animation = animation;
    }
}
