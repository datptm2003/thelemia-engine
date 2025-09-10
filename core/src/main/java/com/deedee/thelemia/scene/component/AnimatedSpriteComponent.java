package com.deedee.thelemia.scene.component;

import com.deedee.thelemia.event.EventBus;
import com.deedee.thelemia.event.common.RenderAnimatedSpriteEvent;
import com.deedee.thelemia.event.common.RenderFragmentEvent;
import com.deedee.thelemia.graphics.AnimatedSprite;
import com.deedee.thelemia.scene.Component;
import com.deedee.thelemia.scene.Entity;
import com.deedee.thelemia.scene.enumerate.ComponentGroup;

public class AnimatedSpriteComponent extends Component implements IGraphicsComponent {
    private final AnimatedSprite sprite;
    private boolean visible = true;

    public AnimatedSpriteComponent(Entity owner, AnimatedSprite sprite) {
        super(owner);
        this.sprite = sprite;

        this.sprite.create();
    }

    @Override
    public void reset() {
        visible = true;
        enabled = true;
    }
    @Override
    public void dispose() {
        sprite.dispose();
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
    public AnimatedSprite getRenderableObject() {
        return sprite;
    }
}
